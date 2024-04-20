package com.yjkj.property_management.ui.page.homePageFragment.firstHomePage.item

import androidx.databinding.ObservableField
import com.yjkj.property_management.ui.page.homePageFragment.firstHomePage.FirstHomePageViewModel

class OrderItemViewModel(val viewModel: FirstHomePageViewModel,val data : Triple<Int,String,String>) {

    val orderItemImage = ObservableField(data.first)
    val orderLabel = ObservableField(data.second)
    val orderCount = ObservableField(data.third)

    fun click(){
        viewModel.launch {
            viewModel.orderItemClickFlow.emit(data.second)
        }
    }
}