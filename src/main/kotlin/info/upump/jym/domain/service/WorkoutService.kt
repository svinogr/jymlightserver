package info.upump.jym.domain.service

import info.upump.jym.domain.db.repo.WorkoutRepo
import info.upump.jym.domain.model.Workout
import info.upump.jym.domain.service.interfaces.WorkoutServiceInterface
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WorkoutService : WorkoutServiceInterface {
    @Autowired
    private lateinit var workoutRepo: WorkoutRepo

    @Autowired
    private lateinit var exerciseService: ExerciseService

    @Transactional
    override fun findFullByParentId(id: Long): List<Workout> {
        val listWorkout = workoutRepo.findByParentId(id).map { Workout.mapFromDbEntity(it) }
        listWorkout.forEach{w ->
            val listExercise = exerciseService.findFullByParentId(w.id)
            w.exercises.addAll(listExercise)
        }

        return listWorkout
    }

}