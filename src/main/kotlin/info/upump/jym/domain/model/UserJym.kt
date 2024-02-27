package info.upump.jym.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class UserJym(
        val id: Long,
        val name: String,
        val email: String,
        val password: String
)

