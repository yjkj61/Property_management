package com.yjkj.property_management.ui.page.homePageFragment.firstHomePage.item

import androidx.databinding.ObservableField
import com.yjkj.property_management.ui.page.homePageFragment.firstHomePage.FirstHomePageViewModel

class ServiceItemViewModel(val viewModel: FirstHomePageViewModel, val data : Triple<Int,String,String>) {

    val itemImage = ObservableField(data.first)
    val warningCount = ObservableField(data.second)
    val itemLabel = ObservableField(data.third)

    fun click(){
        viewModel.launch {
            viewModel.serviceItemClickFlow.emit(data.third)
        }
    }
}