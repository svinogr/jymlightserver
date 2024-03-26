package info.upump.jym.domain.model

import info.upump.jym.domain.db.entity.WorkoutEntity
import info.upump.jymlight.models.entity.Exercise
import java.util.*
import kotlin.collections.ArrayList

data class Workout(
        var isWeekEven: Boolean = false,
        var isDefaultType: Boolean = false,
        var isTemplate: Boolean = false,
        var day: String = "MONDAY",
        var exercises: MutableList<Exercise> = ArrayList(),
        var id: Long = 0,
        var title: String = "",
        var startDate: Date = Date(),
        var finishDate: Date = Date(),
        var comment: String = "",
        var parentId: Long = 0,
) {
    companion object {
        fun mapFromDbEntity(workoutEntity: WorkoutEntity): Workout {
            val workout = Workout(
                    isWeekEven = workoutEntity.week_even == 1,
                    isDefaultType = workoutEntity.default_type == 1,
                    isTemplate = workoutEntity.default_type == 1,
                    day = workoutEntity.day,
                    exercises = mutableListOf<Exercise>()
            )
            workout.title = workoutEntity.title
            workout.parentId = workoutEntity.parent_id!!
            workout.id = workoutEntity.id
            workout.comment = workoutEntity.comment?: ""
            workout.setStartDate(workoutEntity.start_date)
            workout.setFinishDate(workoutEntity.finish_date)

            return workout
        }

        fun mapToEntity(workout: Workout): WorkoutEntity {
            val workoutEntity = WorkoutEntity(workout.id)
            workoutEntity.title = workout.title
            workoutEntity.start_date = workout.startStringFormatDate
            workoutEntity.finish_date = workout.finishStringFormatDate
            workoutEntity.comment = workout.comment
            workoutEntity.day = workout.day
            workoutEntity.default_type = if (workout.isDefaultType) 1 else 0
            workoutEntity.week_even = if (workout.isWeekEven) 1 else 0
            workoutEntity.template = if (workout.isTemplate) 1 else 0
            workoutEntity.template = 0
            workoutEntity.parent_id = workout.parentId

            return workoutEntity
        }

        /*    fun mapFromFullDbEntity(entity: WorkoutFullEntity): Workout {
                val listEntityWorkout = entity.listExerciseEntity
                val listExercises = mutableListOf<Exercise>()

                listEntityWorkout.forEach() {
                    listExercises.add(Exercise.mapFromFullDbEntity(it))
                }

                val workout = Workout(
                        isWeekEven = entity.workoutEntity.week_even == 1,
                        isDefaultType = entity.workoutEntity.default_type == 1,
                        isTemplate = entity.workoutEntity.default_type == 1,
                        day = Day.valueOf(entity.workoutEntity.day!!),
                        exercises = listExercises
                )
                workout.title = entity.workoutEntity.title
                workout.parentId = entity.workoutEntity.parent_id!!
                workout.id = entity.workoutEntity._id
                workout.comment = entity.workoutEntity.comment!!
                workout.setStartDate(entity.workoutEntity.start_date)
                workout.setFinishDate(entity.workoutEntity.finish_date)

                return workout
            }*/

        /*       fun formatDateToString(date: Date): String {
                   val simpleDateFormat = SimpleDateFormat(FORMAT_DATE, Locale.getDefault())
                   return simpleDateFormat.format(date)
               }

               fun formatStringToDate(stringDate: String): Date {
                   val simpleDateFormat = SimpleDateFormat(FORMAT_DATE, Locale.getDefault())
                   var date = Date()
                   try {
                       date = simpleDateFormat.parse(stringDate)!!
                   } catch (e: ParseException) {
                       e.printStackTrace()
                   }

                   return date
               }*/
    }

    val startStringFormatDate: String
        get() {
            return BaseModel.formatDateToString(startDate)
        }

    fun setStartDate(stringDate: String) {
        startDate = BaseModel.formatStringToDate(stringDate)
    }

    val finishStringFormatDate: String
        get() {
            return BaseModel.formatDateToString(finishDate)
        }

    fun setFinishDate(stringDate: String) {
        finishDate = BaseModel.formatStringToDate(stringDate)
    }

    override fun toString(): String {
        return "Workout($title  --  $id  -- $parentId  isWeekEven=$isWeekEven, isDefaultType=$isDefaultType, isTemplate=$isTemplate, day=$day, exercises=$exercises) "
    }
}