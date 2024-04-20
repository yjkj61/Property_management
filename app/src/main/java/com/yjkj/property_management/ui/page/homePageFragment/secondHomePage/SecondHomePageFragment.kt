package com.yjkj.property_management.ui.page.homePageFragment.secondHomePage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.entity.OwnerEntity
import com.yjkj.property_management.library.base.BaseFragment
import com.yjkj.property_management.library.base.nav
import com.yjkj.property_management.library.utils.ext.dpToPx
import com.yjkj.property_management.library.utils.ext.toast
import com.yjkj.property_management.library.view.GridSpaceItemDecoration
import com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.item.PersonalItemViewModel.Companion.CLICK_AVATAR_TYPE
import com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.item.PersonalItemViewModel.Companion.CLICK_CALL_TYPE
import kotlinx.coroutines.launch


/**
* @Author hxy
* Create at 2024/1/13
* @desc 首页第二个页面
*/
class SecondHomePageFragment : BaseFragment() {
    private lateinit var viewModel: SecondHomePageViewModel
    private var motionLayout : MotionLayout? = null
    override fun initViewModel() {
        viewModel = getFragmentScopeViewModel(SecondHomePageViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_second_home_page,BR.viewModel,viewModel).addBindingParam(BR.click,Click()).addBindingParam(BR.listener,Listener())
    }

    override fun lazyInit() {
        super.lazyInit()
        initPersonalItems()
        initSearchItems()
        initServiceItems()
        viewModel.requestAreaData()
        viewModel.requestData()
    }

    private fun initSearchItems(){
        val space0 = requireContext().dpToPx(10)
        val space1 = requireContext().dpToPx(10)
        viewModel.searchGridLayoutManager.set(GridLayoutManager(requireContext(),3))
        viewModel.searchItemDirection.set(GridSpaceItemDecoration(space0,space1))
        viewModel.initSearchItems()
    }

    private fun initPersonalItems(){
        val space0 = requireContext().dpToPx(20)
        val space1 = requireContext().dpToPx(10)
        viewModel.personalGridLayoutManager.set(GridLayoutManager(requireContext(),3))
        viewModel.personalItemDecoration.set(GridSpaceItemDecoration(space0,space1))
    }

    private fun initServiceItems(){
        val space0 = requireContext().dpToPx(45)
        val space1 = requireContext().dpToPx(30)
        viewModel.serviceGridLayoutManager.set(GridLayoutManager(requireContext(),2))
        viewModel.serviceItemDecoration.set(GridSpaceItemDecoration(space0,space1))
        viewModel.initServiceItems()
    }

    override fun observer() {
        super.observer()
        //点击用户头像以及电话按钮
        lifecycleScope.launch {
            viewModel.personalItemClickFlow.collect{
                when(it.first){
                    CLICK_AVATAR_TYPE ->{
                        val bundle = Bundle()
                        bundle.putSerializable(OWNER_ENTITY_PARAM,it.second as OwnerEntity)
                        nav().navigate(R.id.personalFragment,bundle)
                    }
                    CLICK_CALL_TYPE ->{
                        println("号码:: "+it.second)
                        call(it.second as String)
                    }
                }
            }
        }
        //服务点击事件监听
        lifecycleScope.launch {
            viewModel.serviceItemClickFlow.collect{
                toast(it)
                when(it){
                    "SOS报警"->{

                    }
                    "护理服务"->{

                    }
                    "其他服务"->{

                    }
                    "安防报警"->{

                    }
                    "尿不湿报警"->{

                    }
                    "睡眠垫报警"->{

                    }
                    "电子围栏报警"->{

                    }
                    "未接来电" ->{

                    }
                }
            }
        }
    }

    inner class Click{
        fun search(){
            viewModel.launchSearch()
        }

        fun reset(){
            viewModel.resetSearch()
        }
    }

    inner class Listener{
        val recyclerViewScrollChangeListener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val offset = recyclerView.computeVerticalScrollOffset()
                val extent = recyclerView.computeVerticalScrollExtent()
                val range = recyclerView.computeVerticalScrollRange()

                val percentage = 100.0f * offset / (range - extent).toFloat()
                val progress = percentage/100f
                if(motionLayout == null){
                    motionLayout = binding.root.findViewById(R.id.scroll_bar_layout)
                }
               motionLayout?.progress = progress

                viewModel.personalGridLayoutManager.get()?.let {
                    val visibleItemCount = it.childCount
                    val totalItemCount = it.itemCount
                    val firstVisibleItemPosition = it.findFirstVisibleItemPosition()
                    if(visibleItemCount > 0 && visibleItemCount + firstVisibleItemPosition == totalItemCount){
                        viewModel.requestData()
                    }
                }

            }
        }
    }

    companion object{
        const val OWNER_ENTITY_PARAM = "ownerEntity"
    }
}