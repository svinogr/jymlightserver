package info.upump.jym.domain.controllers


import info.upump.jym.domain.db.repo.*
import info.upump.jym.domain.model.Cycle
import info.upump.jym.domain.model.Workout
import info.upump.jymlight.model.Exercise
import info.upump.jymlight.model.ExerciseDescription
import info.upump.jymlight.model.Sets
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/ping")
class PingController {

    @Autowired
    lateinit var c: CycleRepo

    @Autowired
    lateinit var w: WorkoutRepo

    @Autowired
    lateinit var e: ExerciseRepo

    @Autowired
    lateinit var ed: ExerciseDescriptionRepo

    @Autowired
    lateinit var s: SetsRepo

    @GetMapping
    fun ping(): Cycle {
        val findAll = Cycle.mapFromDbEntity(c.findAll().first())
        val work = Workout.mapFromDbEntity(w.findAll().first())
        val ex = Exercise.mapFromDbEntity(e.findAll().first())
        val exd = ExerciseDescription.mapFromDbEntity(ed.findAll().first())
        val se = Sets.mapFromDbEntity(s.findAll().first())

        ex.exerciseDescription = exd
        ex.setsList = mutableListOf(se)
        work.exercises = mutableListOf(ex)
        findAll.workoutList = mutableListOf(work)

        return findAll
    }
}