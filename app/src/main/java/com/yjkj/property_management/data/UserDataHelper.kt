package com.yjkj.property_management.data

import com.yjkj.property_management.library.utils.MMKVUtils

object UserDataHelper {

    private const val token_key = "token"

    fun token():String{
        return MMKVUtils.decodeString(token_key)
    }

    fun token(value : String){
        MMKVUtils.encode(token_key,value)
    }

}