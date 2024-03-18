package info.upump.jym.domain.service

import info.upump.jym.domain.db.repo.SetsRepo
import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.model.Workout
import info.upump.jym.domain.service.interfaces.SetsServiceInterface
import info.upump.jymlight.models.entity.Sets
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SetsService : SetsServiceInterface {
    @Autowired
    private lateinit var setsRepo: SetsRepo
    override fun getAllByParentId(id: Long): List<Sets> {
        return setsRepo.findParentId(id).orElse(listOf()).map { Sets.mapFromDbEntity(it) }
    }

    fun getById(setId: Long): Sets {
        return Sets.mapFromDbEntity(setsRepo.findById(setId).get())
    }

    @Transactional
    fun save(sets: Sets): Sets {
        return if (sets.id == 0L) {
            Sets.mapFromDbEntity(setsRepo.save(Sets.mapToEntity(sets)))
        } else {
            change(sets)
        }
    }

    private fun change(sets: Sets): Sets {
        isIdInDB(sets.id)

        isUserOwnerOf(sets.id)

        return Sets.mapFromDbEntity(setsRepo.save(Sets.mapToEntity(sets)))
    }

    @Transactional
    fun delete(setsId: Long) {
        isIdInDB(setsId)

        isUserOwnerOf(setsId)

        setsRepo.deleteById(setsId)
    }

    override fun isIdInDB(id: Long): Sets {
        val prep = setsRepo.findById(id)

        if (prep.isEmpty) throw NotHaveObjectInDB()

        return Sets.mapFromDbEntity(prep.get())
    }

    override fun isUserOwnerOf(id: Long) {
        //TODO  если id = 0  то подумать как обыграть это
        // TODO
        // проверка на соответсвие userId залогиненому user если нет то
        // NotOwnUserException
        //   throw NotOwnUserException()
    }
}
