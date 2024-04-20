package com.yjkj.property_management.ui.page.homePageFragment.firstHomePage

import com.yjkj.property_management.library.base.BaseRepository
import com.yjkj.property_management.library.http.ApiService
import com.yjkj.property_management.library.http.RetrofitManager

class FirstPageRepo : BaseRepository() {

    suspend fun requestHouseholdAnalysis()=flowOf {
        RetrofitManager.getApiService(ApiService::class.java).requestHouseholdAnalysis()
    }

    suspend fun requestHomePageData()=flowOf {
        RetrofitManager.getApiService(ApiService::class.java).requestHomePageData()
    }

    suspend fun requestEmployeesNumber()=flowOf {
        RetrofitManager.getApiService(ApiService::class.java).employeesNumber()
    }

    suspend fun requestServingNumber()=flowOf {
        RetrofitManager.getApiService(ApiService::class.java).servingNumber()
    }

    suspend fun requestTodayServiceBook() = flowOf {
        RetrofitManager.getApiService(ApiService::class.java).todayServiceBook()
    }

    suspend fun requestTodayGoodsOrder() = flowOf {
        RetrofitManager.getApiService(ApiService::class.java).todayGoodsOrder()
    }

    suspend fun requestTodayOldBook() = flowOf {
        RetrofitManager.getApiService(ApiService::class.java).todayOldBook()
    }

    suspend fun requestTodayRestaurantOrder() = flowOf {
        RetrofitManager.getApiService(ApiService::class.java).todayRestaurantOrder()
    }

    suspend fun requestApprovalAgencyCount() = flowOf {
        RetrofitManager.getApiService(ApiService::class.java).approvalAgencyCount()
    }

    suspend fun requestSearchExpireNumber() = flowOf {
        RetrofitManager.getApiService(ApiService::class.java).searchExpireNumber()
    }

    suspend fun requestBedWarningNum() = flowOf {
        RetrofitManager.getApiService(ApiService::class.java).warningNUm()
    }


}