package com.yjkj.property_management.ui.page.pay.dialog

import android.graphics.Bitmap
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import com.uuzuche.lib_zxing.activity.CodeUtils
import com.yjkj.property_management.library.base.BaseViewModel
import com.yjkj.property_management.library.utils.ext.dpToPx

class PaymentQRCodeViewModel : BaseViewModel() {

    val qrCodeBitmap = ObservableField<Bitmap>()
    val paymentUsername = ObservableField("用户名")

    val paymentIngVisibility = ObservableField(View.VISIBLE)
    val paymentSuccessVisibility = ObservableField(View.GONE)


    fun initQrCode(qrcodeStr : String = "Hello World"){
        val bitmap = CodeUtils.createImage(qrcodeStr,230,230,null)
        qrCodeBitmap.set(bitmap)
    }

    /**
     * 充值成功
     */
    fun paymentSuccess(){
        paymentIngVisibility.set(View.GONE)
        paymentSuccessVisibility.set(View.VISIBLE)
    }

}