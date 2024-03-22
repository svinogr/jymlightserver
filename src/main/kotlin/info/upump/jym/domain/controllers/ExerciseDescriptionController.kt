package info.upump.jym.domain.controllers

import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.exception.NotOwnUserException
import info.upump.jym.domain.service.ExerciseDescriptionService
import info.upump.jymlight.models.entity.ExerciseDescription
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/exercise_description")
class ExerciseDescriptionController {
     @Autowired
     lateinit var exerciseDescriptionService: ExerciseDescriptionService


    @GetMapping("{id}")
    fun getExerciseDescription(@PathVariable("id") id: Long): ResponseEntity<ExerciseDescription> {
        return ResponseEntity.ok().body(exerciseDescriptionService.getById(id))
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