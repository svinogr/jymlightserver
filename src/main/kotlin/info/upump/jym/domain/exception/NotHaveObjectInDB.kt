package info.upump.jym.domain.exception

import org.apache.logging.log4j.message.ObjectMessage

class NotHaveObjectInDB(message: String? = "this object is not in db ", cause: Throwable? = null) : Exception(message, cause) {
}