package info.upump.jym.domain.service.interfaces

import info.upump.jym.domain.model.Workout

interface WorkoutServiceInterface : CheckableInterface<Workout> {
    fun getAllFullByParentId(id: Long): List<Workout>
}