package com.yjkj.property_management.ui.page.ownerlist

import androidx.recyclerview.widget.GridLayoutManager
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.library.base.BaseFragment
import com.yjkj.property_management.library.base.nav
import com.yjkj.property_management.library.utils.ext.dpToPx
import com.yjkj.property_management.library.view.GridSpaceItemDecoration
import com.yjkj.property_management.ui.page.homePageFragment.firstHomePage.FirstHomePageFragment

class OwnerListFragment : BaseFragment() {
    private lateinit var viewModel : OwnerListViewModel
    var type = 0;

    override fun initViewModel() {
        viewModel = getFragmentScopeViewModel(OwnerListViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_owner_list,BR.viewModel,viewModel).addBindingParam(BR.click,Click())
    }

    override fun lazyInit() {
        super.lazyInit()
        initPaymentItems()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }

    private fun initPaymentItems(){
        val bundle = arguments?:return
        type = bundle.getInt(FirstHomePageFragment.PARAM_KEY)
        val space0 = requireContext().dpToPx(20)
        val space1 = requireContext().dpToPx(10)
        viewModel.ownerListGridLayoutManager.set(GridLayoutManager(requireContext(),5))
        viewModel.ownerListItemDecoration.set(GridSpaceItemDecoration(space0,space1))
        viewModel.initOwnerListItems(type,false)
    }

    inner class Click{
        fun backup(){
            nav().navigateUp()
        }
        fun home(){
            backup()
        }
        fun searchData(){
            viewModel.ownerListItems.clear()
            viewModel.initOwnerListItems(type,false)

        }

        fun resetSearch(){
            viewModel.resetSearch()
        }
    }
}