package com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.repo

import com.yjkj.property_management.library.base.BaseRepository
import com.yjkj.property_management.library.http.ApiService
import com.yjkj.property_management.library.http.RetrofitManager

class SecondHomePageRepo : BaseRepository() {


    suspend fun requestAreaData()=flowOf {
        RetrofitManager.getApiService(ApiService::class.java).requestAreaData()
    }

    private var pageNum = 1
    suspend fun requestData(province : String = "",
                            city : String = "",
                            area : String = "",
                            ownerUsername : String = "",
                            ownerCommunity :String = "",
                            ownerBuilding :String = "",
                            ownerUnit :String = "",
                            ownerFloor:String = "",
                            ownerRoomNum:String = "") = flowOf {
//        pageNum++
        RetrofitManager.getApiService(ApiService::class.java).secondPageOwnerList(province = province, city = city, area = area, ownerName = ownerUsername, ownerCommunity = ownerCommunity, ownerBuilding = ownerBuilding, ownerUnit = ownerUnit, ownerFloor = ownerFloor, ownerRoomNum = ownerRoomNum, pageNum = pageNum)
    }


}