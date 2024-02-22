package info.upump.jym.domain.db.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "workouts")
data class WorkoutEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var title: String = "",

        var comment: String? = "",

        var week_even: Int = 0,

        var default_type: Int = 0,

        var template: Int = 0,

        var day: String? = "",

        var start_date: String = "",

        var finish_date: String = "",

        var parent_id: Long? = 0
)