package info.upump.jym.domain.service

import info.upump.jym.domain.db.repo.ExerciseRepo
import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.service.interfaces.ServiceTemplateInterface
import info.upump.jymlight.model.Exercise
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExerciseTemplateService : ServiceTemplateInterface<Exercise> {
    @Autowired
    lateinit var exerciseRepo: ExerciseRepo

    @Autowired
    lateinit var exerciseDescriptionService: ExerciseDescriptionService
    override fun getAllTemplates(): List<Exercise> {
        val listExercise = exerciseRepo.getAllTemplates().orElse(listOf()).map { Exercise.mapFromDbEntity(it) }

        listExercise.forEach { ex ->
            val exD = exerciseDescriptionService.getById(ex.descriptionId)
            ex.exerciseDescription = exD
        }

        return listExercise
    }
}
