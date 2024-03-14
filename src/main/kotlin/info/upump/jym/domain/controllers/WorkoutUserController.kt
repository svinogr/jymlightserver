package info.upump.jym.domain.controllers

import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.exception.NotOwnUserException
import info.upump.jym.domain.model.Workout
import info.upump.jym.domain.service.WorkoutService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/workout")
class WorkoutUserController {
    @Autowired
    lateinit var workoutService: WorkoutService

    @GetMapping("all/{parentId}")
    fun getListWorkoutByParentId(@PathVariable parentId: Long): ResponseEntity<List<Workout>> {
        return ResponseEntity.ok().body(workoutService.getAllByParentId(parentId))
    }

    @GetMapping("full/{workoutId}")
    fun getFullWorkoutById(@PathVariable workoutId: Long): ResponseEntity<Workout?> {
        return ResponseEntity.ok().body(workoutService.getFullById(workoutId))
    }

    @PostMapping()
    fun save(@RequestBody workout: Workout): ResponseEntity<Workout> {
        val workoutDb = workoutService.save(workout)

        return ResponseEntity.created(URI("api/workout/${workoutDb.id}")).body(workoutDb)
    }

    @DeleteMapping("{workoutId}")
    fun delete(@PathVariable workoutId: Long): ResponseEntity<String> {
        workoutService.delete(workoutId)

        return ResponseEntity.ok().body("resource deleted")
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