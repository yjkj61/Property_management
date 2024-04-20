package com.yjkj.property_management.ui.main.frag

import com.yjkj.property_management.library.base.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow

class MainFragmentViewModel : BaseViewModel() {

    //回首页的事件
    val toHomeClickFlow = MutableSharedFlow<Unit>()
}