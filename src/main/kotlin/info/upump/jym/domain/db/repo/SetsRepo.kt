package info.upump.jym.domain.db.repo

import info.upump.jym.domain.db.entity.SetsEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SetsRepo : CrudRepository<SetsEntity, Long> {
    @Query(value = "select * from sets where parent_id = ?1", nativeQuery = true)
    fun findParentId(id: Long): Optional<List<SetsEntity>>
}
