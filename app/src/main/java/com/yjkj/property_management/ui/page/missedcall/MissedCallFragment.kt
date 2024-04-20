package com.yjkj.property_management.ui.page.missedcall

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.library.base.BaseFragment
import com.yjkj.property_management.library.base.nav
import com.yjkj.property_management.library.utils.ext.dpToPx
import com.yjkj.property_management.library.view.GridSpaceItemDecoration
import com.yjkj.property_management.ui.main.frag.MainFragmentViewModel
import com.yjkj.property_management.ui.page.homePageFragment.firstHomePage.FirstHomePageViewModel
import kotlinx.coroutines.launch

/**
* @Author hxy
* Create at 2024/1/14
* @desc 未接来电
*/
class MissedCallFragment : BaseFragment() {
    private lateinit var viewModel: MissedCallViewModel
    private lateinit var mainViewModel: MainFragmentViewModel
    private lateinit var firstHomePageViewModel: FirstHomePageViewModel
    override fun initViewModel() {
        viewModel = getFragmentScopeViewModel(MissedCallViewModel::class.java)
        mainViewModel = getActivityScopeViewModel(MainFragmentViewModel::class.java)
        firstHomePageViewModel = getFragmentScopeViewModel(FirstHomePageViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.missed_calls_grid_layout,BR.viewModel,viewModel).addBindingParam(BR.click,Click())
    }

    override fun lazyInit() {
        super.lazyInit()
        firstHomePageViewModel.readMissedCalls(requireContext().contentResolver) {
            initMissedCallItems(it)
        }
    }

    private fun initMissedCallItems(pairs: List<Pair<String, String>>) {
        val space0 = requireContext().dpToPx(20)
        val space1 = requireContext().dpToPx(10)
        viewModel.missedCallGridLayoutManager.set(GridLayoutManager(requireContext(),5))
        viewModel.missedCallItemDecoration.set(GridSpaceItemDecoration(space0,space1))
        viewModel.initMissedCall(pairs)
    }

    override fun observer() {
        super.observer()
        lifecycleScope.launch {
            viewModel.missedCallItemClickFlow.collect{
                call(it)
            }
        }
    }

    inner class Click{
        //返回上一个页面
        fun backup(){
            nav().navigateUp()
        }

        //回首页
        fun home(){
            backup()
            lifecycleScope.launch {
                mainViewModel.toHomeClickFlow.emit(Unit)
            }
        }
    }



}