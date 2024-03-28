package info.upump.jym.domain.controllers

import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.exception.NotOwnUserException
import info.upump.jym.domain.model.Workout
import info.upump.jym.domain.service.ExerciseService
import info.upump.jymlight.model.Exercise
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/exercise")
class ExerciseController {

    @Autowired
    lateinit var exerciseService: ExerciseService

    @GetMapping("{id}")
    fun getExerciseById(@PathVariable("id") id: Long): ResponseEntity<Exercise> {
        return ResponseEntity.ok(exerciseService.getFullById(id))
    }


    @DeleteMapping("{id}/clean")
    fun cleanById(@PathVariable("id") id: Long): ResponseEntity<String> {
        exerciseService.clean(id)
        return ResponseEntity.ok().body("resources deleted")
    }

    @PostMapping("{id}/copy")
    fun copyExercise(@PathVariable("id") id: Long, @RequestBody workout: Workout): ResponseEntity<String> {
        val exercise: Exercise = exerciseService.copy(id, workout.id )

        return ResponseEntity.created(URI("api/workout/${exercise.id}")).build()
    }

    @DeleteMapping("{id}")
    fun deleteExercise(@PathVariable id: Long): ResponseEntity<String> {
        exerciseService.deleteById(id)

        return  ResponseEntity.ok().body("resource deleted")
    }


    // хендлер для обработки если идет попытка получить чужие данные
    @ExceptionHandler(NotOwnUserException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN, reason = "This object is not yours")
    fun responseHandlerNotOwnUserException(e: NotOwnUserException) {
    }

    // хендлер для обработки  отсутсвия обьекта в базе
    @ExceptionHandler(NotHaveObjectInDB::class)
    @ResponseStatus(HttpStatus.NOT_FOUND, reason = "Db haven't this object")
    fun responseHandlerNotHaveObjectInDB(e: NotHaveObjectInDB) {
    }
}