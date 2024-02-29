package info.upump.jym.domain.exception

import org.apache.logging.log4j.message.ObjectMessage

class NotHaveObjectInDB(message: String? = null, cause: Throwable? = null) : Exception(message, cause) {
}