package info.upump.jym.domain.service.interfaces

import info.upump.jym.domain.exception.NotHaveObjectInDB

 interface CheckableInterface {


    fun isIdInDB(id: Long)

     fun isUserOwnerWith(id: Long)
}
