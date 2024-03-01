package info.upump.jym.domain.service.interfaces

import info.upump.jymlight.models.entity.Sets

interface SetsServiceInterface : CheckableInterface<Sets> {
    fun getAllByParentId(id: Long): List<Sets>
}
