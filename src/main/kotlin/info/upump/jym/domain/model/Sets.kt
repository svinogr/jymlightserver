package info.upump.jymlight.models.entity

import info.upump.jym.domain.db.entity.SetsEntity
import info.upump.jym.domain.model.BaseModel

data class Sets(
        var id: Long = 0,
        var weight: Double = 0.0,
        var reps: Int = 0,
        var weightPast: Double = 0.0,
        var parentId: Long = 0
) {

    override fun toString(): String {
        return "Sets{" +
                "weight=" + weight +
                ", reps=" + reps +
                ", formatDate='" + '\'' +
                ", id=" + id +
                '}'
    }

    companion object {
        fun mapFromDbEntity(entity: SetsEntity): Sets {
            val sets = Sets(
                    weight = entity.weight!!,
                    reps = entity.reps!!,
                    weightPast = entity.past_set ?: 0.0
            )
            sets.id = entity.id
            sets.parentId = entity.parent_id!!

            return sets
        }

        fun mapToEntity(newSets: Sets): SetsEntity {
            val sets = SetsEntity(
                    id = newSets.id)
            sets.parent_id = newSets.parentId
            sets.weight = newSets.weight
            sets.reps = newSets.reps
            sets.past_set = newSets.weightPast

            return sets
        }
    }

}