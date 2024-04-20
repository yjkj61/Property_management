package com.yjkj.property_management.library.http

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 *@Created by houxiaoyao on 2022/3/28 11:18
 * 统一处理请求数据，根据实际开发情况定义即可
 *
 */
class DataResult<T> : Serializable {
    var data: T? = null

    var rows : T? = null
    var code = 0
    var msg  = ""
    var success : Boolean? = null
    var dataState : DataState? = null
    var exception : DataException? = null


    fun data(): T? {
        when(code){
            ResponseCodes.SUCCESS ->{
                if(rows != null && data == null){
                    data = rows
                }
                return data


            }
            ResponseCodes.ACCOUNT_EXIST ->{
                throw DataException(msg,code)
            }
            ResponseCodes.DATA_ERROR ->{
                //数据异常，只要不是成功就是状态码就是500
                throw DataException(msg,code)
            }
            ResponseCodes.TOKEN_INVALID ->{
                throw DataException(msg,code)
            }
            else ->{
                throw DataException(msg,code)
            }

        }
    }

    override fun toString(): String {
        return "DataResult(data=$data, returnCode=$code, message='$msg', success=$success, dataState=$dataState, exception=$exception)"
    }


}

enum class DataState{
    OnEmpty,//data == null
    OnError,//异常
    OnComplete//httpCode=200且服务端也请求成功
}