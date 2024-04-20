package com.yjkj.property_management.ui.page.pay

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.library.base.BaseFragment
import com.yjkj.property_management.library.base.nav
import com.yjkj.property_management.library.utils.ext.dpToPx
import com.yjkj.property_management.library.utils.ext.toast
import com.yjkj.property_management.library.view.GridSpaceItemDecoration
import com.yjkj.property_management.ui.main.frag.MainFragmentViewModel
import com.yjkj.property_management.ui.page.pay.dialog.PaymentQRCodeDialog
import kotlinx.coroutines.launch

class PaymentFragment : BaseFragment() {

    private lateinit var viewModel: PaymentViewModel
    private lateinit var mainViewModel: MainFragmentViewModel

    override fun initViewModel() {
        viewModel = getFragmentScopeViewModel(PaymentViewModel::class.java)
        mainViewModel = getActivityScopeViewModel(MainFragmentViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_payment,BR.viewModel,viewModel).addBindingParam(BR.click,Click())
    }

    override fun lazyInit() {
        super.lazyInit()
        initPaymentItems()
    }

    private fun initPaymentItems(){
        val space0 = requireContext().dpToPx(20)
        val space1 = requireContext().dpToPx(10)
        viewModel.paymentGridLayoutManager.set(GridLayoutManager(requireContext(),5))
        viewModel.paymentItemDecoration.set(GridSpaceItemDecoration(space0,space1))
        viewModel.initPaymentItems()
    }

    override fun observer() {
        super.observer()
        lifecycleScope.launch {
            viewModel.paymentItemClickFlow.collect{
                val dialog = PaymentQRCodeDialog()
                dialog.show(childFragmentManager,"")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
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

        //重置搜索
        fun reset(){
            viewModel.searchReset()
        }

        //搜索
        fun search(){
            viewModel.launchSearch()
        }
    }
}