package info.upump.jym.domain.service

import info.upump.jym.domain.db.entity.CycleEntity
import info.upump.jym.domain.db.repo.CycleRepo
import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.exception.NotOwnUserException
import info.upump.jym.domain.model.Cycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CycleService {
    @Autowired
    lateinit var cycleRepo: CycleRepo

    fun getAllTemplateCycle(): List<Cycle> {
        val allEn = cycleRepo.getAllTemplate()
        val allC = allEn.map { Cycle.mapFromDbEntity(it) }

        return allC
    }

    fun getAllCycleByOwnUserId(userId: Long): List<Cycle> {

        // проверка на соответсвие userId залогиненому user если нет то
        // NotOwnUserException

        val userCycleEn = cycleRepo.findAllByUserId(userId)
        //   throw NotOwnUserException()
        return userCycleEn.map { Cycle.mapFromDbEntity(it) }
    }

    fun getCycleById(cycleId: Long): Cycle {
        // проверка на соответсвие принадлежности cycled залогиненому user если нет то
        // NotOwnUserException
        return cycleRepo.findById(cycleId).map { Cycle.mapFromDbEntity(it) }.orElse(Cycle())
    }

    fun save(cycle: Cycle): Cycle {
        return if (cycle.id == 0L) {
            Cycle.mapFromDbEntity(cycleRepo.save(Cycle.mapToEntity(cycle)))
        } else {
            change(cycle)
        }
    }

    private fun change(cycle: Cycle): Cycle {
        // проверка на соответсвие принадлежности cycled залогиненому user если нет то
        // NotOwnUserException
        val prep = cycleRepo.findById(cycle.id)
        if (prep.isEmpty) throw NotHaveObjectInDB()

        return Cycle.mapFromDbEntity(cycleRepo.save(Cycle.mapToEntity(cycle)))
    }
}