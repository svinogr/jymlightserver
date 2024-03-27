package info.upump.jym.domain.service

import info.upump.jym.domain.db.entity.ExerciseDescriptionEntity
import info.upump.jym.domain.db.repo.ExerciseDescriptionRepo
import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.service.interfaces.ExerciseDescriptionInterface
import info.upump.jymlight.model.ExerciseDescription
import info.upump.jymlight.model.Sets
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExerciseDescriptionService : ExerciseDescriptionInterface {
    @Autowired
    private lateinit var exerciseDescriptionRepo: ExerciseDescriptionRepo
    override fun getById(id: Long): ExerciseDescription {
        //return ExerciseDescription.mapFromDbEntity(exerciseDescriptionRepo.findById(id).orElse(ExerciseDescriptionEntity()))
        return ExerciseDescription.mapFromDbEntity(exerciseDescriptionRepo.findById(id).orElseThrow { NotHaveObjectInDB() })
    }

    @Transactional
    fun save(exerciseDescription: ExerciseDescription): ExerciseDescription {
        return if (exerciseDescription.id == 0L) {
            ExerciseDescription.mapFromDbEntity(exerciseDescriptionRepo.save(ExerciseDescription.mapToEntity(exerciseDescription)))
        } else {
            change(exerciseDescription)
        }
    }

    private fun change(exerciseDescription: ExerciseDescription): ExerciseDescription {
        isIdInDB(exerciseDescription.id)

        isUserOwnerOf(exerciseDescription.id)

        return ExerciseDescription.mapFromDbEntity(exerciseDescriptionRepo.save(ExerciseDescription.mapToEntity(exerciseDescription)))
    }

    @Transactional
    fun delete(exerciseDescriptionId: Long) {

        isUserOwnerOf(exerciseDescriptionId)
        exerciseDescriptionRepo.findById(exerciseDescriptionId).ifPresentOrElse({


        },{})

        exerciseDescriptionRepo.deleteById(exerciseDescriptionId)
    }

    override fun isIdInDB(id: Long): ExerciseDescription {
        val prep = exerciseDescriptionRepo.findById(id)

        if (prep.isEmpty) throw NotHaveObjectInDB()

        return ExerciseDescription.mapFromDbEntity(prep.get())
    }

    override fun isUserOwnerOf(id: Long) {
        //TODO  если id = 0  то подумать как обыграть это
        // TODO
        // проверка на соответсвие userId залогиненому user если нет то
        // NotOwnUserException
        //   throw NotOwnUserException()
    }
}
