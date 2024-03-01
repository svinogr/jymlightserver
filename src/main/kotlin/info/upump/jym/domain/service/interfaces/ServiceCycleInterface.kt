package info.upump.jym.domain.service.interfaces

import info.upump.jym.domain.model.Cycle
import info.upump.jym.domain.service.interfaces.CheckableInterface

interface ServiceCycleInterface : CheckableInterface<Cycle> {
    fun getById(id: Long): Cycle
    fun save(model: Cycle): Cycle
    fun delete(id: Long)

    fun getAllCycleByOwnerUserId(id: Long): List<Cycle>
}