package info.upump.jym.domain.service

import info.upump.jym.domain.db.repo.ExerciseDescriptionRepo
import info.upump.jym.domain.service.interfaces.ExerciseDescriptionInterface
import info.upump.jymlight.models.entity.ExerciseDescription
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExerciseDescriptionService : ExerciseDescriptionInterface {
    @Autowired
    private lateinit var exerciseDescriptionRepo: ExerciseDescriptionRepo
    override fun getById(id: Long): ExerciseDescription {
        return ExerciseDescription.mapFromDbEntity(exerciseDescriptionRepo.findById(id).get())
    }
}
