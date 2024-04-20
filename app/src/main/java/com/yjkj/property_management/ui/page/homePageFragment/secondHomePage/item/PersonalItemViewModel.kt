package com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.item

import androidx.databinding.ObservableField
import com.yjkj.property_management.R
import com.yjkj.property_management.entity.OwnerEntity
import com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.SecondHomePageViewModel

class PersonalItemViewModel(val viewModel: SecondHomePageViewModel,val ownerEntity: OwnerEntity) {

    val roundAvatarSrc = ObservableField(ownerEntity.ownerPic)
    val roomNumber = ObservableField(ownerEntity.ownerRoomNum)
    val personalName = ObservableField(ownerEntity.ownerName)
    val gender = ObservableField(if(ownerEntity.ownerSex == "0") "女" else "男")
    val age = ObservableField("${ownerEntity.ownerAge}岁")

    fun clickAvatar(){
        viewModel.launch {
            viewModel.personalItemClickFlow.emit(Pair(CLICK_AVATAR_TYPE,ownerEntity))
        }
    }

    fun call(){
        viewModel.launch {
            viewModel.personalItemClickFlow.emit(Pair(CLICK_CALL_TYPE, ownerEntity.ownerPhone ?:"10086"))
        }
    }

    companion object{
        const val CLICK_AVATAR_TYPE = "click_user_avatar"
        const val CLICK_CALL_TYPE = "click_user_phone"
    }
}