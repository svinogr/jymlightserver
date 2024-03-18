package info.upump.jym.domain.service

import info.upump.jym.domain.db.repo.ExerciseRepo
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
}