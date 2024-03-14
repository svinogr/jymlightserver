package info.upump.jym.domain.controllers

import com.google.gson.JsonObject
import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.exception.NotOwnUserException
import info.upump.jym.domain.model.Cycle
import info.upump.jym.domain.service.CycleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/cycle")
class CycleUserController {
    @Autowired
    lateinit var cycleService: CycleService

    @GetMapping("all/{userId}")
    fun getListCycleByOwnUser(@PathVariable userId: Long): ResponseEntity<List<Cycle>> {
        return ResponseEntity.ok().body(cycleService.getAllCycleByOwnerUserId(userId))
    }

    @GetMapping("full/{cycleId}")
    fun getFullCycleById(@PathVariable cycleId: Long): ResponseEntity<Cycle> {
        return ResponseEntity.ok().body(cycleService.getFullAllCycleById(cycleId))
    }

    @GetMapping("{cycleId}")
    fun getCycleById(@PathVariable cycleId: Long): ResponseEntity<Cycle> {
        return ResponseEntity.ok().body(cycleService.getById(cycleId))
    }

    @PostMapping()
    fun save(@RequestBody cycle: Cycle): ResponseEntity<Void> {
        val cycleDb = cycleService.save(cycle)

        return ResponseEntity.created(URI("/api/cycle/${cycleDb.id}")).build()
    }

    @PutMapping()
    fun update(@RequestBody cycle: Cycle): ResponseEntity<Void> {
        cycleService.save(cycle)

        return ResponseEntity.noContent().build()
    }


    @DeleteMapping("{cycleId}")
    fun delete(@PathVariable cycleId: Long): ResponseEntity<Void> {
        cycleService.delete(cycleId)

        return ResponseEntity.ok().build()
    }


    // хендлер для обработки если идет попытка получить чужие данные
    @ExceptionHandler(NotOwnUserException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN, reason = "This object is not yours")
    fun responseHandlerNotOwnUserException(e: NotOwnUserException) {
    }

    // хендлер для обработки  отсутсвия обьекта в базе
    @ExceptionHandler(NotHaveObjectInDB::class)
    fun responseHandlerNotHaveObjectInDB(e: NotHaveObjectInDB): ResponseEntity<String> {
        val responseJSON = JsonObject()
        responseJSON.addProperty("message", e.message)

        return ResponseEntity<String>(responseJSON.toString(), HttpStatus.NOT_FOUND)
    }
}