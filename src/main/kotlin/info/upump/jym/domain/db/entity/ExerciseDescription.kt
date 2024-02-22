package info.upump.jym.domain.db.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "exercise_description")
data class ExerciseDescriptionEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long=0,
        var default_img: String? = "",

        var img: String? = "",

        var title: String? = "")