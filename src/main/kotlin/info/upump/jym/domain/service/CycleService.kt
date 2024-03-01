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

        val userCycleEn = cycleRepo.findAllByUserId(id)

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
        val cycle = cycleRepo.findById(id).map { Cycle.mapFromDbEntity(it) }.orElse(Cycle())
        isUserOwnerOf(cycle.id)

        return cycle
    }

    @Transactional
    override fun save(model: Cycle): Cycle {
        return if (model.id == 0L) {
            Cycle.mapFromDbEntity(cycleRepo.save(Cycle.mapToEntity(model)))
        } else {
            change(model)
        }
    }

    private fun change(cycle: Cycle): Cycle {
        isIdInDB(cycle.id)

        isUserOwnerOf(cycle.id)

        val cycleChange = Cycle.mapFromDbEntity(cycleRepo.save(Cycle.mapToEntity(cycle)))

        return cycleChange
    }

    @Transactional
    override fun delete(id: Long) {
        val cycle = isIdInDB(id)

        isUserOwnerOf(cycle.id)

        cycleRepo.deleteById(id)
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