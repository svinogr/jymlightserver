package info.upump.jym.domain.service

import info.upump.jym.domain.db.repo.CycleRepo
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
}