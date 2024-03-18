package info.upump.jym.domain.db.repo

import info.upump.jym.domain.db.entity.CycleEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CycleRepo : CrudRepository<CycleEntity, Long> {
    @Query(value = "select * from cycles where default_type = 1", nativeQuery = true)
    fun findAllTemplate(): Optional<List<CycleEntity>>

    @Query(value = "select * from cycles where parent_user  = ?1", nativeQuery = true)
    fun findAllByUserId(userId: Long): Optional<List<CycleEntity>>


}