package info.upump.jym.domain.service

import info.upump.jym.domain.db.repo.SetsRepo
import info.upump.jym.domain.service.interfaces.SetsServiceInterface
import info.upump.jymlight.models.entity.Sets
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SetsService : SetsServiceInterface {
@Autowired
private lateinit var setsRepo: SetsRepo
    override fun getByParentId(id: Long): List<Sets> {
        return setsRepo.findParentId(id).map{Sets.mapFromDbEntity(it)}
    }
}
