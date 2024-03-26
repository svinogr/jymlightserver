package info.upump.jym.domain.service

import info.upump.jym.domain.db.repo.ExerciseRepo
import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.service.interfaces.ExerciseServiceInterface
import info.upump.jymlight.models.entity.Exercise
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExerciseService : ExerciseServiceInterface {
    @Autowired
    private lateinit var exerciseRepo: ExerciseRepo

    @Autowired
    private lateinit var exerciseDescriptionService: ExerciseDescriptionService

    @Autowired
    private lateinit var setsService: SetsService

    @Transactional
    fun getAllFullByParentId(id: Long): List<Exercise> {
        val listExercise = exerciseRepo.findByParentId(id).orElse(listOf()).map { Exercise.mapFromDbEntity(it) }

        listExercise.forEach { ex ->
            val exD = exerciseDescriptionService.getById(ex.descriptionId)
            val listSets = setsService.getAllByParentId(ex.id)

            ex.exerciseDescription = exD
            ex.setsList.addAll(listSets)
        }

        return listExercise
    }

    @Transactional
    fun getFullById(id: Long): Exercise {
        val exercise = Exercise.mapFromDbEntity(exerciseRepo.findById(id).orElseThrow { NotHaveObjectInDB() })
        val listsets = setsService.getAllByParentId(exercise.id)
        val exerciseDescription = exerciseDescriptionService.getById(exercise.descriptionId)
        exercise.setsList.addAll(listsets)
        exercise.exerciseDescription = exerciseDescription

        return exercise
    }

    @Transactional
    fun deleteById(id: Long) {
        exerciseRepo.findById(id).ifPresentOrElse({
           exerciseRepo.deleteById(id)
          // exerciseDescriptionService.delete(id)
           setsService.deleteByParentId(id)
        }, { throw NotHaveObjectInDB() })

    }

    @Transactional
    fun deleteByParentId(parentId: Long) {
        exerciseRepo.findByParentId(parentId).ifPresentOrElse({ exercises ->
            exercises.forEach {
                if (it.default_type != 1 && it.template != 1) {
                    deleteById(it.id)
                    setsService.deleteByParentId(it.id)
                }
            }
        }, {throw NotHaveObjectInDB()})
    }

    @Transactional
    fun clean(id: Long){
        val exerciseDb  = exerciseRepo.findById(id)
        exerciseDb.ifPresentOrElse({
           setsService.deleteByParentId(it.id)
        },{throw NotHaveObjectInDB()})
    }
}