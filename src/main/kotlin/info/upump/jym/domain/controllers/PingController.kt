package info.upump.jym.domain.controllers

import info.upump.jym.domain.db.entity.CycleEntity
import info.upump.jym.domain.db.repo.CycleRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/ping")
class PingController {

    @Autowired
    lateinit var c: CycleRepo

    @GetMapping
    fun ping(): CycleEntity {
        val findAll = c.findAll()

        val cyle = CycleEntity(id = 1).apply {
        }
        return findAll.first()
    }
}