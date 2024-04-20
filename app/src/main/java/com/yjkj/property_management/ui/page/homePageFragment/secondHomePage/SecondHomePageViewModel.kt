package com.yjkj.property_management.ui.page.homePageFragment.secondHomePage

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.entity.City
import com.yjkj.property_management.entity.District
import com.yjkj.property_management.library.base.BaseViewModel
import com.yjkj.property_management.library.utils.ext.toast
import com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.item.PersonalItemViewModel
import com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.item.SearchItemViewModel
import com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.item.ServiceItemViewModel
import com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.repo.SecondHomePageRepo
import kotlinx.coroutines.flow.MutableSharedFlow
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.OnItemBind

class SecondHomePageViewModel : BaseViewModel() {

    private val repo by lazy {
        SecondHomePageRepo()
    }

    //条件搜索相关
    val searchItemDirection = ObservableField<ItemDecoration>()
    val searchGridLayoutManager = ObservableField<GridLayoutManager>()
    val searchItems = ObservableArrayList<SearchItemViewModel>()
    //val searchItemBinding = ItemBinding.of<SearchItemViewModel>(BR.viewModel, R.layout.search_grid_item_layout)
    val searchItemBinding = OnItemBind<SearchItemViewModel>{itemBinding, position, item ->
        if(position <= 2){
            itemBinding.set(BR.viewModel,R.layout.search_grid_area_item_layout)
        }else{
            itemBinding.set(BR.viewModel,R.layout.search_grid_item_layout)
        }
    }

    //业主列表
    val personalItemDecoration = ObservableField<ItemDecoration>()
    val personalGridLayoutManager = ObservableField<GridLayoutManager>()
    val personalItems = ObservableArrayList<PersonalItemViewModel>()
    val personalItemBinding = ItemBinding.of<PersonalItemViewModel>(BR.viewModel, R.layout.personal_grid_item_layout)
    val personalItemClickFlow = MutableSharedFlow<Pair<String, Any>>()

    //服务列表
    val serviceItemDecoration = ObservableField<ItemDecoration>()
    val serviceGridLayoutManager = ObservableField<GridLayoutManager>()
    val serviceItems = ObservableArrayList<ServiceItemViewModel>()
    val serviceItemBinding = ItemBinding.of<ServiceItemViewModel>(BR.viewModel, R.layout.second_service_item_layout)
    val serviceItemClickFlow = MutableSharedFlow<String>()

    fun initSearchItems() {
        searchItems.add(SearchItemViewModel(this, "\r\r\r\r省\r\r\r\r"))
        searchItems.add(SearchItemViewModel(this, "\r\r\r\r市\r\r\r\r"))
        searchItems.add(SearchItemViewModel(this, "\r\r\r\r区\r\r\r\r"))
        searchItems.add(SearchItemViewModel(this, "姓\r\r\r\r名"))
        searchItems.add(SearchItemViewModel(this, "小\r\r\r\r区"))
        searchItems.add(SearchItemViewModel(this, "楼\r\r\r\r栋"))
        searchItems.add(SearchItemViewModel(this, "单元号"))
        searchItems.add(SearchItemViewModel(this, "楼\r\r\r\r层"))
        searchItems.add(SearchItemViewModel(this, "房间号"))
    }

    fun requestData(){
        launch({repo.requestData()}, onSuccess = {
            personalItems.clear()
            it.forEach {
                personalItems.add(PersonalItemViewModel(this,it))
            }

        })
    }


    fun initServiceItems() {
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.missed_calls_icon, "0", "未接来电")))
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.camera_icon, "0", "安防报警")))
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.sos_icon, "0", "SOS报警")))
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.mattress_icon, "0", "睡眠垫报警")))
        serviceItems.add(ServiceItemViewModel(this,Triple(R.drawable.nurse_icon, "0", "护理服务")))
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.baby_diapers_icon, "0", "尿不湿报警")))
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.orthers_service_icon, "0", "其他服务")))
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.ele_fence_icon, "0", "电子围栏报警")))
    }

    fun launchSearch() {
        val filter = searchItems.filter {
            it.isNotEmpty()
        }

        if (filter.isEmpty()) {
            return
        }
        val province = searchItems.first().getValue()
        val city = searchItems[1].getValue()
        val area = searchItems[2].getValue()
        val ownerUsername = searchItems[3].getValue()
        val ownerCommunity = searchItems[4].getValue()
        val ownerBuilding = searchItems[5].getValue()
        val ownerUnit = searchItems[6].getValue()
        val ownerFloor = searchItems[7].getValue()
        val ownerRoomNum = searchItems[8].getValue()
        launch({repo.requestData(province,city,area,ownerUsername,ownerCommunity,ownerBuilding,ownerUnit,ownerFloor,ownerRoomNum)}, onSuccess = {
            personalItems.clear()
            it.forEach {
                personalItems.add(PersonalItemViewModel(this,it))
            }

        })

    }

    fun resetSearch() {
        searchItems.forEach {
            it.clear()
        }
    }

    fun requestAreaData(){
        launch({repo.requestAreaData()}, onSuccess = {
            val data = it.districts[0]
            val provinceList =  data.districts
            val provinceMap = mutableMapOf<String,List<City>>()

            provinceList.forEach {
                provinceMap[it.name] = it.districts
            }

            searchItems[0].setProvinceData(provinceMap)

        })


        searchItems[0].OnSpinnerProvinceItemSelected {
            val citys = it.second
            val cityMap = mutableMapOf<String,List<District>>()
            citys.forEach {
                cityMap[it.name] = it.districts
            }
            val item = searchItems[1]
            item.setCityData(cityMap)
        }
        searchItems[1].OnSpinnerCityItemSelected {
            val district = it.second
            val item = searchItems[2]
            item.setDistrictsData(district)
        }

        searchItems[2].OnSpinnerDistrictsItemSelected { s, s2 ->

        }


    }



}