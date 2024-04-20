package com.yjkj.property_management.ui.page.ownerlist

import androidx.databinding.ObservableField
import com.yjkj.property_management.entity.OwnerEntity

class OwnerListItemViewModel(val viewModel : OwnerListViewModel,ownerEntities: OwnerEntity) {

    val avatar = ObservableField<String>(ownerEntities.ownerPic)
    val roomId = ObservableField<String>(ownerEntities.ownerRoomNum)
    val personalName = ObservableField<String>(ownerEntities.ownerName)
    val gender = ObservableField<String>(when(ownerEntities.ownerSex){
        "1" -> "男"
        "0" -> "女"
        else -> "未知"
    })
    val age = ObservableField<String>("${ownerEntities.ownerAge}岁")

}