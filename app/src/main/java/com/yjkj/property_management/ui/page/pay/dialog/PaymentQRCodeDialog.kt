package com.yjkj.property_management.ui.page.pay.dialog

import com.kunminx.architecture.ui.page.DataBindingConfig
import com.uuzuche.lib_zxing.activity.CodeUtils
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.library.base.BaseDialogFragment
import com.yjkj.property_management.library.utils.ext.dpToPx

/**
* @Author hxy
* Create at 2024/1/14
* @desc 充值中弹窗
*/
class PaymentQRCodeDialog : BaseDialogFragment() {
    private lateinit var viewModel: PaymentQRCodeViewModel
    override fun getDialogFragmentConfig(): ConfigDialogFragment {
        return ConfigDialogFragment(canceledOnTouchOutSide = false, width = percentWidth(0.63f), height = percentHeight(0.68f), dimAmount = 0.9f)
    }

    override fun initViewModel() {
        viewModel = getFragmentScopeViewModel(PaymentQRCodeViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.payment_qr_code_dialog_layout,BR.viewModel,viewModel).addBindingParam(BR.click,Click())
    }

    override fun lazyInit() {
        super.lazyInit()
        viewModel.initQrCode()
    }

    inner class Click{
        fun close(){
            dismiss()
        }
    }
}