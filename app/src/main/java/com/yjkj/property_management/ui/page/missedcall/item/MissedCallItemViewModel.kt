package com.yjkj.property_management.ui.page.missedcall.item

import androidx.databinding.ObservableField
import com.blankj.utilcode.util.TimeUtils
import com.yjkj.property_management.ui.page.missedcall.MissedCallViewModel
import java.util.Date

class MissedCallItemViewModel(val viewModel: MissedCallViewModel,val data : Pair<String, String>) {

    val phoneNumber = ObservableField("Tel:${data.first}")

    fun call(){
        viewModel.launch {
            viewModel.missedCallItemClickFlow.emit(data.first)
        }
    }

}