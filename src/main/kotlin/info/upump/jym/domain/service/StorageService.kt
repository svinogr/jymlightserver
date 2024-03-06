package info.upump.jym.domain.service

import info.upump.jym.domain.service.interfaces.StorageServiceInterface
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import kotlin.io.path.absolutePathString

@Service
class StorageService : StorageServiceInterface {
    private val uploadPath: Path = Paths.get("/upload")

    override fun init() {
        try {
            Files.createDirectory(uploadPath)
        } catch (e: IOException) {
            print("не создать директорию")
        }
    }

    override fun storage(file: MultipartFile) {
        try {

            if (file.isEmpty) {
                throw IOException()
            }

            val destinationFile = uploadPath.resolve(file.originalFilename).normalize().toAbsolutePath()

            file.inputStream.use {
                Files.copy(it, destinationFile, StandardCopyOption.REPLACE_EXISTING)
            }

        } catch (e: IOException) {
            print("not storage")
        }
    }

    override fun load(fileName: String): Path {
        return uploadPath.resolve(fileName)
    }

    override fun loadAsResource(fileName: String): Resource {
        TODO("Not yet implemented")
    }
}