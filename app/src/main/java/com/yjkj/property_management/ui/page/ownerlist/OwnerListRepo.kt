package com.yjkj.property_management.ui.page.ownerlist

import com.blankj.utilcode.util.ApiUtils.Api
import com.yjkj.property_management.library.base.BaseRepository
import com.yjkj.property_management.library.http.ApiService
import com.yjkj.property_management.library.http.RetrofitManager
import java.io.Serializable

class OwnerListRepo : BaseRepository() {

    /**
     * 获取超过60岁
     */
    private var over60PageNum = 0
    suspend fun requestOver60(
        ownerName: String = "",
        ownerCommunity:String = "",
        ownerBuilding:String = "", ) = flowOf {
        over60PageNum ++
        RetrofitManager.getApiService(ApiService::class.java).over60OwnerList(pageNum = over60PageNum, ownerName = ownerName, ownerBuilding = ownerBuilding, ownerCommunity = ownerCommunity)
    }

    /**
     * 获取独居老人
     */
    private var ownerLivingPageNum = 0
    suspend fun requestOwnerLiving(
        ownerName: String = "",
        ownerCommunity:String = "",
        ownerBuilding:String = "", ) = flowOf {
        ownerLivingPageNum ++
        RetrofitManager.getApiService(ApiService::class.java).ownerLivingOwnerList(pageNum = ownerLivingPageNum,ownerName = ownerName, ownerBuilding = ownerBuilding, ownerCommunity = ownerCommunity)
    }



    private var ownerPageNum = 0
    suspend fun requestOwner(
        ownerName: String = "",
        ownerCommunity:String = "",
        ownerBuilding:String = "",
    ) = flowOf {
        ownerPageNum ++
        RetrofitManager.getApiService(ApiService::class.java).ownerList(pageNum = ownerPageNum,ownerName = ownerName, ownerBuilding = ownerBuilding, ownerCommunity = ownerCommunity)
    }

    private var workListNum = 0
    suspend fun requestWorkList() = flowOf {
        workListNum++
        RetrofitManager.getApiService(ApiService::class.java).workList(pageNum = workListNum)
    }

    private var serviceListNum = 0
    suspend fun requestServiceList() = flowOf {
        serviceListNum++
        RetrofitManager.getApiService(ApiService::class.java).serviceList(pageNum = serviceListNum)
    }

    private var bedWarnListNum = 0
    suspend fun requestBedWarnList() = flowOf {
        bedWarnListNum++
        RetrofitManager.getApiService(ApiService::class.java).bedWarningList(pageNum = bedWarnListNum)
    }

    private var todayServiceBookListNum = 0
    suspend fun todayServiceBookList()=flowOf {
        todayServiceBookListNum++
        RetrofitManager.getApiService(ApiService::class.java).todayServiceBookList(pageNum = todayServiceBookListNum)
    }

    private var todayGoodsOrderListNum = 0
    suspend fun todayGoodsOrderList()=flowOf {
        todayGoodsOrderListNum++
        RetrofitManager.getApiService(ApiService::class.java).todayGoodsOrderList(pageNum = todayGoodsOrderListNum)
    }

    private var todayOldBookListNum = 0
    suspend fun todayOldBookList()=flowOf {
        todayOldBookListNum++
        RetrofitManager.getApiService(ApiService::class.java).todayOldBookList(pageNum = todayOldBookListNum)
    }

    private var todayRestaurantOrderListNum = 0
    suspend fun todayRestaurantOrderList()=flowOf {
        todayRestaurantOrderListNum++
        RetrofitManager.getApiService(ApiService::class.java).todayRestaurantOrderList(pageNum = todayRestaurantOrderListNum)
    }
}