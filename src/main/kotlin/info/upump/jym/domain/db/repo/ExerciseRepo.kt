package info.upump.jym.domain.db.repo

import info.upump.jym.domain.db.entity.ExerciseEntity
import info.upump.jymlight.models.entity.Exercise
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ExerciseRepo : CrudRepository<ExerciseEntity, Long>