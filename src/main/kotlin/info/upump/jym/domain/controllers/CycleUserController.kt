package info.upump.jym.domain.controllers

import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.exception.NotOwnUserException
import info.upump.jym.domain.model.Cycle
import info.upump.jym.domain.service.CycleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cycle")
class CycleUserController {
    @Autowired
    lateinit var cycleService: CycleService

    @GetMapping("all/{userId}")
    fun getListCycleByOwnUser(@PathVariable userId: Long): List<Cycle> {

        return cycleService.getAllCycleByOwnUserId(userId)
    }

    @GetMapping("{cycleId}")
    fun getCycleById(@PathVariable cycleId: Long): Cycle {
        return cycleService.getCycleById(cycleId)
    }

    @PostMapping("{cycleId}")
    fun changeCycleById(@RequestBody cycle: Cycle): Cycle {
        return cycleService.save(cycle)
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