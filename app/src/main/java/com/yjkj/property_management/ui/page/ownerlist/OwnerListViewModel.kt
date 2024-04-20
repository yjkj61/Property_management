package com.yjkj.property_management.ui.page.ownerlist

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.entity.OwnerEntity
import com.yjkj.property_management.library.base.BaseViewModel
import me.tatarka.bindingcollectionadapter2.ItemBinding

class OwnerListViewModel : BaseViewModel() {

    private val repo by lazy {
        OwnerListRepo()
    }

    val searchName = ObservableField("")
    val searchCommunity = ObservableField("")
    val searchBuilding = ObservableField("")
    val ownerListItems = ObservableArrayList<OwnerListItemViewModel>()
    val ownerListItemBinding = ItemBinding.of<OwnerListItemViewModel>(BR.viewModel, R.layout.owner_list_item_layout)
    val ownerListGridLayoutManager = ObservableField<GridLayoutManager>()
    val ownerListItemDecoration = ObservableField<RecyclerView.ItemDecoration>()

    private var pageType : Int = OwnerListType.OVER_60

    fun initOwnerListItems(type: Int,isLoadMore : Boolean = false) {
        pageType = type
        when(type){
            OwnerListType.OVER_60 ->{
                launch({repo.requestOver60(searchName.get().toString(),searchBuilding.get().toString(),searchCommunity.get().toString())}, onSuccess = {
                    loadItemData(it,isLoadMore)
                })
            }
            OwnerListType.OWNER ->{
                launch({repo.requestOwner(searchName.get().toString(),searchBuilding.get().toString(),searchCommunity.get().toString())}, onSuccess = {
                    loadItemData(it, isLoadMore)
                })
            }
            OwnerListType.OWNER_LIVING->{
                launch({repo.requestOwnerLiving(searchName.get().toString(),searchBuilding.get().toString(),searchCommunity.get().toString())}, onSuccess = {
                    loadItemData(it, isLoadMore)
                })
            }
            OwnerListType.OWNER_WORK_LIST ->{
                launch({repo.requestWorkList()}, onSuccess = {
                    loadItemData(it, isLoadMore)
                })
            }
            OwnerListType.OWNER_SERVICE_LIST ->{
                launch({repo.requestServiceList()}, onSuccess = {
                    loadItemData(it, isLoadMore)
                })
            }
            OwnerListType.OWNER_BED_WARNING ->{
                launch({repo.requestBedWarnList()}, onSuccess = {

                })
            }
            OwnerListType.TODAY_SERVICE_BOOK_LIST ->{
                launch({repo.todayServiceBookList()}, onSuccess = {

                })
            }
            OwnerListType.TODAY_OLD_BOOK_LIST ->{
                launch({repo.todayOldBookList()}, onSuccess = {

                })
            }
            OwnerListType.TODAY_GOODS_ORDER_LIST ->{
                launch({repo.todayGoodsOrderList()}, onSuccess = {

                })
            }
            OwnerListType.TODAY_RESTAURANT_LIST ->{
                launch({repo.todayRestaurantOrderList()}, onSuccess = {

                })
            }

        }
    }

    fun  resetSearch(){
        searchName.set("")
        searchBuilding.set("")
        searchCommunity.set("")
    }

    private fun loadItemData(it: MutableList<OwnerEntity>, isLoadMore: Boolean){
        if(!isLoadMore){
            ownerListItems.clear()
        }
        it.forEach {
            ownerListItems.add(OwnerListItemViewModel(this,it))
        }
    }

    var rvScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            ownerListGridLayoutManager.get()?.let {
                val visibleItemCount = it.childCount
                val totalItemCount = it.itemCount
                val firstVisibleItemPosition = it.findFirstVisibleItemPosition()
                if(visibleItemCount > 0 && visibleItemCount + firstVisibleItemPosition == totalItemCount){
                    initOwnerListItems(pageType,false)
                }
            }
        }
    }

    fun clear(){
        ownerListItems.clear()
        ownerListGridLayoutManager.set(null)
        ownerListItemDecoration.set(null)
    }

}