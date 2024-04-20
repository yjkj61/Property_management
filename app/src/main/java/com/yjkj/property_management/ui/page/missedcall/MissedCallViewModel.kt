package com.yjkj.property_management.ui.page.missedcall

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.library.base.BaseViewModel
import com.yjkj.property_management.ui.page.missedcall.item.MissedCallItemViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import me.tatarka.bindingcollectionadapter2.ItemBinding

class MissedCallViewModel : BaseViewModel() {


    val missedCallItems = ObservableArrayList<MissedCallItemViewModel>()
    val missedCallItemBinding = ItemBinding.of<MissedCallItemViewModel>(BR.viewModel, R.layout.missed_call_list_item_layout)
    val missedCallGridLayoutManager = ObservableField<GridLayoutManager>()
    val missedCallItemDecoration = ObservableField<RecyclerView.ItemDecoration>()
    val missedCallItemClickFlow = MutableSharedFlow<String>()

    fun initMissedCall(pairs: List<Pair<String, String>>) {
        pairs.forEach {
            missedCallItems.add(MissedCallItemViewModel(this,it))
        }

    }
}