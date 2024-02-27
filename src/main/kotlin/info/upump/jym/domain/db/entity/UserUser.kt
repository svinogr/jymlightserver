package info.upump.jym.domain.db.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "user_user")
data class UserUser(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long,
        val userId: Long,
        val userId2: Long,
        val active: Boolean)