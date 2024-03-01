package info.upump.jym.domain.service.interfaces

import info.upump.jymlight.models.entity.ExerciseDescription

interface ExerciseDescriptionInterface : CheckableInterface<ExerciseDescription> {
    fun getById(id: Long): ExerciseDescription
}
