package info.upump.jymlight.models.entity

import info.upump.jym.domain.db.entity.ExerciseEntity
import info.upump.jym.domain.model.BaseModel

data class Exercise(
    var typeMuscle: String = "CALVES",
    var isDefaultType: Boolean = false,
    var isTemplate: Boolean = false,
    var setsList: MutableList<Sets> = ArrayList(),
    var descriptionId: Long = 0,
    var exerciseDescription: ExerciseDescription? = null,

    ) : BaseModel() {

    override fun toString(): String {
        return "Exercise{" +
                "template" + isTemplate +
                ", desc " + descriptionId +
                ", typeMuscle=" + typeMuscle +
                ", defaultType=" + isDefaultType +
                ", setsList=" + setsList.size +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                ", parentId=" + parentId + "descr" + exerciseDescription.toString()
        '}'
    }

    companion object {
        fun mapFromDbEntity(entity: ExerciseEntity): Exercise {
            val exercise = Exercise()
            exercise.id = entity.id
            exercise.parentId = entity.parent_id!!
            exercise.descriptionId = entity.description_id!!
            exercise.typeMuscle = entity.type_exercise
            exercise.isTemplate = entity.template == 1
            exercise.comment = entity.comment?: ""

            return exercise
        }

        fun mapToEntity(exercise: Exercise): ExerciseEntity {
            val exerciseEntity = ExerciseEntity()
            exerciseEntity.id = exercise.id
            exerciseEntity.parent_id = exercise.parentId
            exerciseEntity.description_id = exercise.descriptionId
            exerciseEntity.comment = exercise.comment
            exerciseEntity.type_exercise = exercise.typeMuscle.toString()
            exerciseEntity.default_type = if(exercise.isDefaultType) 1 else 0
            exerciseEntity.template = if(exercise.isTemplate) 1 else 0
            exerciseEntity.start_date = exercise.startStringFormatDate
            exerciseEntity.finish_date = exercise.finishStringFormatDate

            return exerciseEntity
        }

  /*      fun mapFromFullDbEntity(entity: ExerciseFullEntity): Exercise {
            val exercise = mapFromDbEntity(entity.exerciseEntity)
            val exerciseDescription =
                ExerciseDescription.mapFromDbEntity(entity.exerciseDescriptionEntity)
            val listSets = mutableListOf<Sets>()

            entity.listSetsEntity.forEach {
                val set = Sets.mapFromDbEntity(it)
                listSets.add(set)
            }
            exercise.exerciseDescription = exerciseDescription
            exercise.comment = entity.exerciseEntity.comment!!
            exercise.setsList = listSets

            return exercise
        }*/
    }
}