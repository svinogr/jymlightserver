package info.upump.jym.domain.service.interfaces

import info.upump.jym.domain.model.Cycle

interface ServiceCycleTemplateInterface {
    fun getAllTemplateCycle(): List<Cycle>
}