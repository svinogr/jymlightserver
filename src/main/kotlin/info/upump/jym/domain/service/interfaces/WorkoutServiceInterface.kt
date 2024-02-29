package info.upump.jym.domain.service.interfaces

import info.upump.jym.domain.model.Workout

interface WorkoutServiceInterface {
    fun findFullByParentId(id: Long): List<Workout>
}