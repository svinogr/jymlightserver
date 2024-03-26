package info.upump.jym.domain.service

import info.upump.jym.domain.db.repo.SetsRepo
import info.upump.jym.domain.exception.NotHaveObjectInDB
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
        return Sets.mapFromDbEntity(setsRepo.findById(setId).orElseThrow { throw NotHaveObjectInDB() })
    }

    fun save(sets: Sets): Sets {
        if (sets.id != 0L) throw NotHaveObjectInDB()

        return Sets.mapFromDbEntity(setsRepo.save(Sets.mapToEntity(sets)))
    }

    @Transactional
    fun deleteById(setsId: Long) {
        //    isIdInDB(setsId)

        isUserOwnerOf(setsId)

        setsRepo.findById(setsId).ifPresentOrElse({ setsRepo.deleteById(setsId) }, { throw NotHaveObjectInDB() })
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

    @Transactional
    fun deleteByParentId(parentId: Long) {
        setsRepo.findParentId(parentId).ifPresent { sets ->
            sets.forEach {
                deleteById(it.id)
            }
        }
    }

    @Transactional
    fun update(sets: Sets) {
        setsRepo.findById(sets.id).ifPresentOrElse({
            with(it) {
                /* parent_id = sets.parentId*/
                reps = sets.reps
                weight = sets.weight
                past_set = sets.weightPast
            }

        }, { throw NotHaveObjectInDB() })
    }

    @Transactional
    fun saveList(listSets: List<Sets>): List<Sets> {
        listSets.forEach {
            if (it.id != 0L) throw NotHaveObjectInDB()
        }

        val listNew = mutableListOf<Sets>()

        listSets.forEach {
            listNew.add(Sets.mapFromDbEntity(setsRepo.save(Sets.mapToEntity(it))))
        }

        return listNew
    }
}
