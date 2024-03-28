package info.upump.jym.domain.service

import info.upump.jym.domain.model.Cycle
import info.upump.jym.domain.service.interfaces.ServiceTemplateInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CycleTemplateService : ServiceTemplateInterface<Cycle> {
    @Autowired
    private lateinit var cycleService: CycleService
    override fun getAllTemplates(): List<Cycle> {
        return cycleService.getAllCycleByOwnerUserId(0)
    }

    fun getFullTemplateCycleById(id: Long): Cycle {
        return cycleService.getFullAllCycleById(id)
    }
}