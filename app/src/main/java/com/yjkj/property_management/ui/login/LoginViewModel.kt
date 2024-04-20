package com.yjkj.property_management.ui.login

import android.os.Debug
import android.view.View
import android.widget.CompoundButton
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.data.UserDataHelper
import com.yjkj.property_management.data.UserLoginHelper
import com.yjkj.property_management.library.base.BaseViewModel
import com.yjkj.property_management.library.utils.ext.toast
import com.yjkj.property_management.ui.login.items.LoginItemsViewModel
import me.tatarka.bindingcollectionadapter2.ItemBinding

class LoginViewModel : BaseViewModel() {

    val loginTipsVisibility = ObservableField(View.GONE)
    val loginTipsText = ObservableField("")

    val loginBtnEnable = ObservableField(false)

    val loginItems = ObservableArrayList<LoginItemsViewModel>()
    val loginItemBinding = ItemBinding.of<LoginItemsViewModel>(BR.viewModel,R.layout.login_item_layout)

    val checkedUsername = ObservableField(UserLoginHelper.checkedUsername())
    val checkedPassword = ObservableField(UserLoginHelper.checkedPassword())
    val checkedRoomId = ObservableField(UserLoginHelper.checkedRoomId())




    fun initLoginItems(){
        loginItems.add(LoginItemsViewModel(this, Triple(R.drawable.group_153,"账号",0x00000001)))
        loginItems.add(LoginItemsViewModel(this,Triple(R.drawable.group_308,"密码",0x000000e1)))

        loginItems[0].apply {
            content.set(UserLoginHelper.username())
            textChangedCallback {
                val item1 = loginItems[1]
                //val item2 = loginItems[2]
                if(it.isNotEmpty() && item1.content.get().toString().isNotEmpty() ){
                    loginBtnEnable.set(true)
                }else{
                    loginBtnEnable.set(false)
                }
            }
        }
        loginItems[1].apply {
            content.set(UserLoginHelper.userpwd())
            textChangedCallback {
                val item0 = loginItems[0]
                //val item2 = loginItems[2]
                if(it.isNotEmpty() && item0.content.get().toString().isNotEmpty() ){
                    loginBtnEnable.set(true)
                }else{
                    loginBtnEnable.set(false)
                }
            }
        }
    }
    private val loginRepo by lazy {
        LoginRepo()
    }

    fun login(username : String = loginItems[0].content.get().toString(),password :String = loginItems[1].content.get().toString(),success : ()->Unit = {}){
        if(checkedUsername.get() == true){
            UserLoginHelper.checkedUsername(true)
            UserLoginHelper.username(username)
        }else{
            UserLoginHelper.username("")
            UserLoginHelper.checkedUsername(false)
        }
        if(checkedPassword.get() == true){
            UserLoginHelper.checkedPassword(true)
            UserLoginHelper.userpwd(password)
        }else{
            UserLoginHelper.userpwd("")
            UserLoginHelper.checkedPassword(false)
        }
        launch({loginRepo.login(username, password)}, onSuccess = {
            println(it)
            UserDataHelper.token(it.access_token)
            success.invoke()
        }, onError = {
            toast(it.errorMessage.toString())
        }, onDataEmpty = {
            toast(it)
        })
    }


    val checkedChangeListener = CompoundButton.OnCheckedChangeListener { compoundButton, p1 ->
        when (compoundButton.id) {
            R.id.remember_username -> {
                checkedUsername.set(p1)
            }

            R.id.remember_pwd -> {
                checkedPassword.set(p1)
            }

        }
    }

}