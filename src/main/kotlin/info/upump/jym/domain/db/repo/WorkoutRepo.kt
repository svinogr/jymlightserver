package info.upump.jym.domain.db.repo

import info.upump.jym.domain.db.entity.WorkoutEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkoutRepo : CrudRepository<WorkoutEntity, Long> {
    @Query(value = "select * from workouts where parent_id = ?1", nativeQuery = true)
    fun findByParentId(parent: Long): List<WorkoutEntity>
}