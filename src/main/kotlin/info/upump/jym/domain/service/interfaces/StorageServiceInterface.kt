package info.upump.jym.domain.service.interfaces

import org.springframework.core.io.Resource
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Path

interface StorageServiceInterface {
    fun init()
    fun storage(file: MultipartFile)

    fun load(fileName: String): Path
    fun loadAsResource(fileName: String): Resource
}