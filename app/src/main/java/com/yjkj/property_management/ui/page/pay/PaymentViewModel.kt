package com.yjkj.property_management.ui.page.pay

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.library.base.BaseViewModel
import com.yjkj.property_management.ui.page.pay.item.PaymentPeopleItemViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import me.tatarka.bindingcollectionadapter2.ItemBinding

class PaymentViewModel : BaseViewModel() {

    private val repo by lazy {
        PaymentRepo()
    }

    val userName = ObservableField("")
    val buildingNumber = ObservableField("")
    val roomNumber = ObservableField("")

    //充值人员列表
    val paymentItems = ObservableArrayList<PaymentPeopleItemViewModel>()
    val paymentItemBinding = ItemBinding.of<PaymentPeopleItemViewModel>(BR.viewModel,R.layout.payment_list_item_layout)
    val paymentGridLayoutManager = ObservableField<GridLayoutManager>()
    val paymentItemDecoration = ObservableField<ItemDecoration>()
    val paymentItemClickFlow = MutableSharedFlow<Unit>()

    fun initPaymentItems(){
        launch({repo.ownerList()}, onSuccess = {
            it.forEach {
                paymentItems.add(PaymentPeopleItemViewModel(this,it))
            }

        })
    }

    fun launchSearch(){
        if(userName.get().isNullOrEmpty() && buildingNumber.get().isNullOrEmpty() && roomNumber.get().isNullOrEmpty()){
            return
        }
    }

    fun searchReset(){
        userName.set("")
        buildingNumber.set("")
        roomNumber.set("")
    }

    var rvScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            paymentGridLayoutManager.get()?.let {
                val visibleItemCount = it.childCount
                val totalItemCount = it.itemCount
                val firstVisibleItemPosition = it.findFirstVisibleItemPosition()
                if(visibleItemCount > 0 && visibleItemCount + firstVisibleItemPosition == totalItemCount){
                    initPaymentItems()
                }
            }
        }
    }

    fun clear(){
        paymentItems.clear()
        paymentGridLayoutManager.set(null)
        paymentItemDecoration.set(null)
    }
}