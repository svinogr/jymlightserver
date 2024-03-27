package info.upump.jym.domain.service.interfaces

import info.upump.jymlight.model.Sets

interface SetsServiceInterface : CheckableInterface<Sets> {
    fun getAllByParentId(id: Long): List<Sets>
}
