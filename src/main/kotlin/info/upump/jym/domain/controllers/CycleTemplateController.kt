package info.upump.jym.domain.controllers

import info.upump.jym.domain.model.Cycle
import info.upump.jym.domain.service.CycleService
import info.upump.jym.domain.service.CycleTemplateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cycle")
class CycleTemplateController {
    @Autowired
    lateinit var cycleTemplateService: CycleTemplateService

    @GetMapping("templates")
    fun getAllTemplate(): ResponseEntity<List<Cycle>> {
        return ResponseEntity.ok().body(cycleTemplateService.getAllTemplateCycle())
    }

    @GetMapping("templates/{cycleId}")
    fun getAllTemplate(@PathVariable cycleId: Long): ResponseEntity<Cycle> {
        return ResponseEntity.ok().body(cycleTemplateService.getFullTemplateCycleById(cycleId))
    }
}