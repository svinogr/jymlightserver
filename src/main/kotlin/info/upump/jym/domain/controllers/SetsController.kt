package info.upump.jym.domain.controllers

import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.exception.NotOwnUserException
import info.upump.jym.domain.service.SetsService
import info.upump.jymlight.model.Sets
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("api/sets")
class SetsController {

    @Autowired
    lateinit var setsService: SetsService

    @DeleteMapping("{id}")
    fun deleteSetsById(@PathVariable id: Long): ResponseEntity<String> {
        setsService.deleteById(id)

        return ResponseEntity.ok().body("resource deleted")
    }

    @GetMapping("{id}")
    fun getSetsById(@PathVariable id: Long): ResponseEntity<Sets> {
        return ResponseEntity.ok().body(setsService.getById(id))

    }

    @PutMapping()
    fun updateSets(@RequestBody sets: Sets): ResponseEntity<Void> {
        setsService.update(sets)
        return ResponseEntity.noContent().build()
    }

    @PostMapping("list")
    fun save(@RequestBody listSets: List<Sets>): ResponseEntity<List<Sets>> {
        return ResponseEntity.ok(setsService.saveList(listSets))
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