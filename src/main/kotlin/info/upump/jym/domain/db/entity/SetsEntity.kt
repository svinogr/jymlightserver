package info.upump.jym.domain.db.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "sets")
data class SetsEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long=0,
        var comment: String? = "",

        var weight: Double? = 0.0,

        var reps: Int? = 0,

        var start_date: String = "",

        var finish_date: String = "",

        var parent_id: Long? = 0,

        var past_set: Double ? = 0.0)