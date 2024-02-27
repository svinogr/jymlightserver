package info.upump.jym.domain.controllers

import info.upump.jym.domain.exception.NotOwnUserException
import info.upump.jym.domain.model.Cycle
import info.upump.jym.domain.service.CycleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cycle")
class CycleUserController {
    @Autowired
    lateinit var cycleService: CycleService

    @GetMapping("{userId}")
    fun getListCycleByOwnUser(@PathVariable userId: Long): List<Cycle> {
        // var list = listOf<Cycle>()
        val list = cycleService.getAllCycleByOwnUserId(userId)

        return list
    }

    @ExceptionHandler(NotOwnUserException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid")
    fun responseHandlerException(e: NotOwnUserException) {
    }
}