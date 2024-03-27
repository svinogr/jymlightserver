package info.upump.jym.domain.db.repo

import info.upump.jym.domain.db.entity.ExerciseDescriptionEntity
import info.upump.jymlight.model.ExerciseDescription
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ExerciseDescriptionRepo : CrudRepository<ExerciseDescriptionEntity, Long>