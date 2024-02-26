package info.upump.jym.domain.db.repo

import info.upump.jym.domain.db.entity.ExerciseDescriptionEntity
import info.upump.jymlight.models.entity.ExerciseDescription
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ExerciseDescriptionRepo : CrudRepository<ExerciseDescriptionEntity, Long>