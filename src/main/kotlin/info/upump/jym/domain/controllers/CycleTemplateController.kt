package info.upump.jym.domain.controllers

import info.upump.jym.domain.model.Cycle
import info.upump.jym.domain.service.CycleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cycle")
class CycleTemplateController {
    @Autowired
    lateinit var cycleService: CycleService

    @GetMapping("templates")
    fun getAllTemplate(): List<Cycle> {
        return cycleService.getAllTemplateCycle()
    }
}