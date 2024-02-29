package info.upump.jym.domain.service.interfaces

import info.upump.jymlight.models.entity.ExerciseDescription

interface ExerciseDescriptionInterface {
    fun getById(id: Long): ExerciseDescription
}
