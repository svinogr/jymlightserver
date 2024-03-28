package info.upump.jym.domain.service.interfaces

import info.upump.jym.domain.model.Cycle

interface ServiceTemplateInterface<T> {
    fun getAllTemplates(): List<T>
}