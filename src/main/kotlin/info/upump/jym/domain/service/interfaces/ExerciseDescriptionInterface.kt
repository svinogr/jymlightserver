package info.upump.jym.domain.service.interfaces

import info.upump.jymlight.model.ExerciseDescription

interface ExerciseDescriptionInterface : CheckableInterface<ExerciseDescription> {
    fun getById(id: Long): ExerciseDescription
}
