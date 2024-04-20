package com.yjkj.property_management.ui.login

import com.yjkj.property_management.library.base.BaseRepository
import com.yjkj.property_management.library.http.ApiService
import com.yjkj.property_management.library.http.RetrofitManager
import com.yjkj.property_management.library.utils.ext.toRequestBody

class LoginRepo : BaseRepository() {

    suspend fun login(username : String,password : String)=flowOf {
        val map = HashMap<String,Any>()
        map["username"] = username
        map["password"] = password
        RetrofitManager.getApiService(ApiService::class.java).login(body = map.toRequestBody())
    }
}