package info.upump.jym.domain.db.repo

import info.upump.jym.domain.db.entity.WorkoutEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkoutRepo : CrudRepository<WorkoutEntity, Long>