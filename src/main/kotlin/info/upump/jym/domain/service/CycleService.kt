package info.upump.jym.domain.service

import info.upump.jym.domain.db.entity.CycleEntity
import info.upump.jym.domain.db.repo.CycleRepo
import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.model.Cycle
import info.upump.jym.domain.service.interfaces.ServiceCycleInterface
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CycleService : ServiceCycleInterface {
    @Autowired
    private lateinit var cycleRepo: CycleRepo

    @Autowired
    private lateinit var workoutService: WorkoutService

    override fun getAllCycleByOwnerUserId(id: Long): List<Cycle> {
        isUserOwnerOf(id)
        val userCycleEn = cycleRepo.findAllByUserId(id).orElse(listOf())

        return userCycleEn.map { Cycle.mapFromDbEntity(it) }
    }

    @Transactional
    fun getFullAllCycleById(id: Long): Cycle {
        val cycle = Cycle.mapFromDbEntity(cycleRepo.findById(id).orElse(CycleEntity(id = 0)))

        isUserOwnerOf(cycle.parentId)

        val listWorkout = workoutService.getAllFullByParentId(cycle.id)

        cycle.workoutList.addAll(listWorkout)

        return cycle
    }

    override fun getById(id: Long): Cycle {
        // isUserOwnerOf(cycle.id)

        return cycleRepo.findById(id).map { Cycle.mapFromDbEntity(it) }.orElse(Cycle())
    }

    @Transactional
    override fun save(model: Cycle): Cycle {
        isUserOwnerOf(model.id)  // проверить и убрать

        return Cycle.mapFromDbEntity(cycleRepo.save(Cycle.mapToEntity(model)))
    }

    @Transactional
    override fun deleteById(id: Long) {
        val cycleDb = cycleRepo.findById(id)
        cycleDb.ifPresentOrElse({
            cycleRepo.deleteById(id)
            workoutService.deleteByParentId(id)
        }, { throw NotHaveObjectInDB() })
        //  isUserOwnerOf(cycle.id)
    }

    @Transactional
    fun clean(id: Long) {
        val cycleDb = cycleRepo.findById(id)
        cycleDb.ifPresentOrElse({
            workoutService.deleteByParentId(id)
        }, { throw NotHaveObjectInDB() })
    }

    override fun isIdInDB(id: Long): Cycle {
        val prep = cycleRepo.findById(id)
        if (prep.isEmpty) throw NotHaveObjectInDB()

        return Cycle.mapFromDbEntity(prep.get())
    }

    override fun isUserOwnerOf(id: Long) {
        //TODO  если id = 0  то подумать как обыграть это
        // TODO
        // проверка на соответсвие userId залогиненому user если нет то
        // NotOwnUserException
        //   throw NotOwnUserException()
    }

}