package com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.item

import androidx.databinding.ObservableField
import com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.SecondHomePageViewModel

class ServiceItemViewModel(val viewModel: SecondHomePageViewModel,val data : Triple<Int,String,String>) {

    val itemsIcon = ObservableField(data.first)
    val itemsCount = ObservableField(data.second)
    val itemsLabel = ObservableField(data.third)

    fun click(){
        viewModel.launch {
            viewModel.serviceItemClickFlow.emit(data.third)
        }
    }

}