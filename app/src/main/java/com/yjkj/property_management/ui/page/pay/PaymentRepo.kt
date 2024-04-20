package com.yjkj.property_management.ui.page.pay

import com.yjkj.property_management.library.base.BaseRepository
import com.yjkj.property_management.library.http.ApiService
import com.yjkj.property_management.library.http.RetrofitManager

class PaymentRepo : BaseRepository() {

    private var pageNum = 0

    suspend fun ownerList()= flowOf {
        pageNum++
        RetrofitManager.getApiService(ApiService::class.java).ownerList(pageNum = pageNum)
    }

}