package info.upump.jym.domain.service.interfaces

import info.upump.jymlight.models.entity.Sets

interface SetsServiceInterface {
    fun getByParentId(id: Long): List<Sets>
}
