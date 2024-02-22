package info.upump.jym.domain.db.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity(name = "cycles")
data class CycleEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        var title: String = "",

        var comment: String? = "",

        var default_type: Int = 0,

        var img: String? = "",

        var start_date: String = "",

        var finish_date: String = "",

        var default_img: String? = ""
)