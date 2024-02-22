package info.upump.jym.domain.db.repo

import info.upump.jym.domain.db.entity.CycleEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CycleRepo : CrudRepository<CycleEntity, Long>