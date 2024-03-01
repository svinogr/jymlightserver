package info.upump.jym.domain.service.interfaces

import info.upump.jym.domain.exception.NotHaveObjectInDB

 interface CheckableInterface<T> {


    fun isIdInDB(id: Long): T

     fun isUserOwnerOf(id: Long)
}
