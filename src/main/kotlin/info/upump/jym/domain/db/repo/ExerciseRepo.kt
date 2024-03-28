package info.upump.jym.domain.db.repo

import info.upump.jym.domain.db.entity.ExerciseEntity
import info.upump.jymlight.model.Exercise
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ExerciseRepo : CrudRepository<ExerciseEntity, Long> {

    @Query(value = "select * from exercises where parent_id = ?1", nativeQuery = true)
    fun findByParentId(parent: Long): Optional<List<ExerciseEntity>>

    @Query(value = "select * from exercises  where template = 1", nativeQuery = true)
    fun getAllTemplates(): Optional<List<ExerciseEntity>>
}