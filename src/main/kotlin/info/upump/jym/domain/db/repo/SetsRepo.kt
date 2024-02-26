package info.upump.jym.domain.db.repo

import info.upump.jym.domain.db.entity.SetsEntity
import info.upump.jymlight.models.entity.Sets
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SetsRepo : CrudRepository<SetsEntity, Long>
