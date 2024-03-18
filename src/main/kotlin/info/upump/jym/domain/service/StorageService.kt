package info.upump.jym.domain.service

import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.exception.NotHaveResource
import info.upump.jym.domain.service.interfaces.StorageServiceInterface
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.NotFound
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@Service
class StorageService : StorageServiceInterface {
    private final val UPLOAD_PATH: Path = Paths.get("./upload")

    override fun init() {
        try {
            print("create dir")
            Files.createDirectory(UPLOAD_PATH)
        } catch (e: IOException) {
            print("не создать директорию")
        }
    }

    override fun storage(file: MultipartFile) {
        if (!Files.exists(UPLOAD_PATH)) init()

        try {

            if (file.isEmpty) {
                throw IOException()
            }

            val destinationFile = UPLOAD_PATH.resolve(file.originalFilename!!).normalize().toAbsolutePath()

            file.inputStream.use {
                Files.copy(it, destinationFile, StandardCopyOption.REPLACE_EXISTING)
                print(destinationFile)
            }

        } catch (e: IOException) {
            print("not storage")
        }
    }

    override fun load(fileName: String): Path {
        return UPLOAD_PATH.resolve(fileName)
    }

    override fun loadAsResource(fileName: String): Resource {
        val file = load(fileName)

        val resource = UrlResource(file.toUri())

        if (resource.exists() && resource.isReadable) {
            return resource
        } else{
           throw NotHaveResource(message = "image not found")
        }
    }
}