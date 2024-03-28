package info.upump.jym.domain.controllers

import info.upump.jym.domain.model.Cycle
import info.upump.jym.domain.service.CycleTemplateService
import info.upump.jym.domain.service.ExerciseTemplateService
import info.upump.jymlight.model.Exercise
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/templates")
class CycleTemplateController {
    @Autowired
    lateinit var cycleTemplateService: CycleTemplateService

    @Autowired
    lateinit var exerciseTemplateService: ExerciseTemplateService

    @GetMapping("cycle")
    fun getAllTemplate(): ResponseEntity<List<Cycle>> {
        return ResponseEntity.ok().body(cycleTemplateService.getAllTemplates())
    }

    @GetMapping("{cycleId}")
    fun getAllTemplate(@PathVariable cycleId: Long): ResponseEntity<Cycle> {
        return ResponseEntity.ok().body(cycleTemplateService.getFullTemplateCycleById(cycleId))
    }

    @GetMapping("exercise")
    fun getAllExerciseTemplate(): ResponseEntity<List<Exercise>> {
        return ResponseEntity.ok().body(exerciseTemplateService.getAllTemplates())
    }
}