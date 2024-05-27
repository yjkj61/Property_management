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
import com.yjkj.property_management.java.ui.AfActivity
import com.yjkj.property_management.java.ui.DzwlActivity
import com.yjkj.property_management.java.ui.HlfwActivity
import com.yjkj.property_management.java.ui.NbsActivity
import com.yjkj.property_management.java.ui.OtherfwActivity
import com.yjkj.property_management.java.ui.SleepActivity
import com.yjkj.property_management.java.ui.SosActivity
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
    private var motionLayout: MotionLayout? = null
    override fun initViewModel() {
        viewModel = getFragmentScopeViewModel(SecondHomePageViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(
            R.layout.fragment_second_home_page,
            BR.viewModel,
            viewModel
        ).addBindingParam(BR.click, Click()).addBindingParam(BR.listener, Listener())
    }

    override fun lazyInit() {
        super.lazyInit()
        initPersonalItems()
        initSearchItems()
        initServiceItems()
        viewModel.requestAreaData()
        viewModel.requestData()
    }

    private fun initSearchItems() {
        val space0 = requireContext().dpToPx(10)
        val space1 = requireContext().dpToPx(10)
        viewModel.searchGridLayoutManager.set(GridLayoutManager(requireContext(), 3))
        viewModel.searchItemDirection.set(GridSpaceItemDecoration(space0, space1))
        viewModel.initSearchItems()
    }

    private fun initPersonalItems() {
        val space0 = requireContext().dpToPx(20)
        val space1 = requireContext().dpToPx(10)
        viewModel.personalGridLayoutManager.set(GridLayoutManager(requireContext(), 3))
        viewModel.personalItemDecoration.set(GridSpaceItemDecoration(space0, space1))
    }

    private fun initServiceItems() {
        val space0 = requireContext().dpToPx(45)
        val space1 = requireContext().dpToPx(30)
        viewModel.serviceGridLayoutManager.set(GridLayoutManager(requireContext(), 2))
        viewModel.serviceItemDecoration.set(GridSpaceItemDecoration(space0, space1))
        viewModel.initServiceItems()
    }

    override fun observer() {
        super.observer()

        //服务点击事件监听
        lifecycleScope.launch {
            viewModel.serviceItemClickFlow.collect {
                when (it) {
                    "SOS报警" -> {
                        Click().toSos()
                    }

                    "护理服务" -> {
                        Click().toHlfw()
                    }

                    "其他服务" -> {
                        Click().toOtherfw()
                    }

                    "安防报警" -> {
                        Click().toAf()
                    }

                    "尿不湿报警" -> {
                        Click().toNbs()
                    }

                    "睡眠垫报警" -> {
                        Click().bedWarningNum()
                    }

                    "电子围栏报警" -> {
                        Click().toDzwl()
                    }

                    "未接来电" -> {
                        Click().missedCall()
                    }
                }
            }
        }

        //点击用户头像以及电话按钮
        lifecycleScope.launch {
            viewModel.personalItemClickFlow.collect {
                when (it.first) {
                    CLICK_AVATAR_TYPE -> {
                        val bundle = Bundle()
                        bundle.putSerializable(OWNER_ENTITY_PARAM, it.second as OwnerEntity)
                        nav().navigate(R.id.personalFragment, bundle)
                    }

                    CLICK_CALL_TYPE -> {
                        println("号码:: " + it.second)
                        call(it.second as String)
                    }
                }
            }
        }
    }

    private fun unReadPhoneList(){
        var intent = Intent(Intent.ACTION_VIEW)
        intent?.setType("vnd.android.cursor.dir/calls")
        startActivity(intent)
    }

    inner class Click {
        fun search() {
            viewModel.launchSearch()
        }

        fun reset() {
            viewModel.resetSearch()
        }

        fun toSos() {
            var intent = Intent(activity, SosActivity::class.java)
            startActivity(intent)
        }

        fun toHlfw() {
            var intent = Intent(activity, HlfwActivity::class.java)
            startActivity(intent)
        }

        fun toOtherfw() {
            var intent = Intent(activity, OtherfwActivity::class.java)
            startActivity(intent)
        }

        fun toAf() {
            var intent = Intent(activity, AfActivity::class.java)
            startActivity(intent)
        }

        fun toNbs() {
            var intent = Intent(activity, NbsActivity::class.java)
            startActivity(intent)
        }

        fun toSleep() {
            var intent = Intent(activity, SleepActivity::class.java)
            startActivity(intent)
        }

        fun toDzwl() {
            var intent = Intent(activity, DzwlActivity::class.java)
            startActivity(intent)
        }

        fun missedCall(){
//            nav().navigate(R.id.missedCallFragment)
            unReadPhoneList()
        }

        fun bedWarningNum(){
//            val bundle = Bundle()
//            bundle.putInt(PARAM_KEY,OwnerListType.OWNER_BED_WARNING)
//            act(AiBedActivity::class.java,bundle,false)
            var intent = Intent(activity, SleepActivity::class.java)
            startActivity(intent)
        }

    }

    inner class Listener {
        val recyclerViewScrollChangeListener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val offset = recyclerView.computeVerticalScrollOffset()
                val extent = recyclerView.computeVerticalScrollExtent()
                val range = recyclerView.computeVerticalScrollRange()

                val percentage = 100.0f * offset / (range - extent).toFloat()
                val progress = percentage / 100f
                if (motionLayout == null) {
                    motionLayout = binding.root.findViewById(R.id.scroll_bar_layout)
                }
                motionLayout?.progress = progress

                viewModel.personalGridLayoutManager.get()?.let {
                    val visibleItemCount = it.childCount
                    val totalItemCount = it.itemCount
                    val firstVisibleItemPosition = it.findFirstVisibleItemPosition()
                    if (visibleItemCount > 0 && visibleItemCount + firstVisibleItemPosition == totalItemCount) {
//                        viewModel.requestData()
                    }
                }

            }
        }
    }

    companion object {
        const val OWNER_ENTITY_PARAM = "ownerEntity"
    }
}