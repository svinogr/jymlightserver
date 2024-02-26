package info.upump.jym.domain.db.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "exercises")
data class ExerciseEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long=0,
        var comment: String? = "",

        var description_id: Long? = 0,

        var type_exercise: String = "",

        var default_type: Int = 0,

        var template: Int = 0,

        var start_date: String = "",

        var finish_date: String = "",

        var parent_id: Long? = 0)