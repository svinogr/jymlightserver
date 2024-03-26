package info.upump.jym.domain.service

import info.upump.jym.domain.db.repo.WorkoutRepo
import info.upump.jym.domain.exception.NotHaveObjectInDB
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
    override fun getAllFullByParentId(id: Long): List<Workout> {
        val listWorkout = workoutRepo.findByParentId(id).orElse(listOf()).map { Workout.mapFromDbEntity(it) }
        listWorkout.forEach { w ->
            val listExercise = exerciseService.getAllFullByParentId(w.id)
            w.exercises.addAll(listExercise)
        }

        return listWorkout
    }

    fun getAllByParentId(parentId: Long): List<Workout> {
        return workoutRepo.findByParentId(parentId).orElse(listOf()).map { Workout.mapFromDbEntity(it) }
    }

    @Transactional
    fun getFullById(workoutId: Long): Workout {
        val workout = Workout.mapFromDbEntity(workoutRepo.findById(workoutId).get())
        val listExercise = exerciseService.getAllFullByParentId(workout.id)
        workout.exercises.addAll(listExercise)

        return workout
    }

    @Transactional
    fun save(workout: Workout): Workout {
        return if (workout.id == 0L) {
            Workout.mapFromDbEntity(workoutRepo.save(Workout.mapToEntity(workout)))
        } else {
            change(workout)
        }
    }

    private fun change(workout: Workout): Workout {
        isIdInDB(workout.id)

        isUserOwnerOf(workout.id)

        val workoutChange = Workout.mapFromDbEntity(workoutRepo.save(Workout.mapToEntity(workout)))

        return workoutChange
    }

    @Transactional
    fun deleteById(workoutId: Long) {
        //  isUserOwnerOf(workoutId)
        workoutRepo.findById(workoutId).ifPresentOrElse({
            workoutRepo.deleteById(workoutId)
            exerciseService.deleteByParentId(workoutId)
        }, { throw NotHaveObjectInDB() })
    }

    @Transactional
    override fun clean(id: Long) {
        val workoutDb = workoutRepo.findById(id)
        workoutDb.ifPresentOrElse({
            exerciseService.deleteByParentId(id)
        }, { throw NotHaveObjectInDB() })
    }


    override fun isIdInDB(id: Long): Workout {
        val prep = workoutRepo.findById(id)

        if (prep.isEmpty) throw NotHaveObjectInDB()

        return Workout.mapFromDbEntity(prep.get())
    }

    override fun isUserOwnerOf(id: Long) {
        //TODO  если id = 0  то подумать как обыграть это
        // TODO
        // проверка на соответсвие userId залогиненому user если нет то
        // NotOwnUserException
        //   throw NotOwnUserException()
    }

    fun deleteByParentId(id: Long) {
        workoutRepo.findByParentId(id).ifPresent() {
            it.forEach() { w ->
                deleteById(w.id)
            }
        }
    }

}