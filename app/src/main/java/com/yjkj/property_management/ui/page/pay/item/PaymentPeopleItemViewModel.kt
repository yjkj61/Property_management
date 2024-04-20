package com.yjkj.property_management.ui.page.pay.item

import androidx.databinding.ObservableField
import com.yjkj.property_management.R
import com.yjkj.property_management.entity.OwnerEntity
import com.yjkj.property_management.library.utils.ext.ifNull
import com.yjkj.property_management.ui.page.pay.PaymentViewModel

class PaymentPeopleItemViewModel(
    val viewModel: PaymentViewModel,
    ownerEntities: OwnerEntity
) {

    val avatar = ObservableField(ownerEntities.ownerPic)
    val roomId = ObservableField(ownerEntities.ownerRoomNum)
    val personalName = ObservableField(ownerEntities.ownerName)
    val gender = ObservableField(when(ownerEntities.ownerSex){
        "1" -> "男"
        "0" -> "女"
        else -> "未知"
    })
    val age = ObservableField("${ownerEntities.ownerAge}岁")

    fun pay(){
        viewModel.launch {
            viewModel.paymentItemClickFlow.emit(Unit)
        }
    }
}