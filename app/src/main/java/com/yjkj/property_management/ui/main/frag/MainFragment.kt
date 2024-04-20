package com.yjkj.property_management.ui.main.frag


import android.annotation.SuppressLint
import android.view.View
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.library.base.BaseFragment
import com.yjkj.property_management.library.base.checkPermission
import com.yjkj.property_management.library.utils.ext.dp
import com.yjkj.property_management.library.utils.ext.initFragment
import com.yjkj.property_management.library.utils.ext.setDimensions
import com.yjkj.property_management.library.utils.ext.toast
import com.yjkj.property_management.ui.page.homePageFragment.firstHomePage.FirstHomePageFragment
import com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.SecondHomePageFragment
import kotlinx.coroutines.launch


class MainFragment : BaseFragment() {
    private lateinit var viewModel: MainFragmentViewModel
    private lateinit var vp2 : ViewPager2

    private val firstHomepage = FirstHomePageFragment()

    private val secondHomePageFragment = SecondHomePageFragment()

    override fun initViewModel() {
        viewModel = getActivityScopeViewModel(MainFragmentViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_main,BR.viewModel,viewModel).addBindingParam(BR.click,Click())
    }

    override fun lazyInit() {
        super.lazyInit()
        initViewPager2()
        checkPermission {

        }
    }

    override fun observer() {
        super.observer()
        //监听回首页的事件
        lifecycleScope.launch {
            viewModel.toHomeClickFlow.collect{
                vp2.setCurrentItem(0,true)
            }
        }
    }

    private fun initViewPager2(){
        val fragments = mutableListOf<Fragment>()
        fragments.add(firstHomepage)
        fragments.add(secondHomePageFragment)
        vp2 =  binding.root.findViewById<ViewPager2>(R.id.main_vp2)
        val firstIndicator = binding.root.findViewById<View>(R.id.first_indicator)
        val secondIndicator = binding.root.findViewById<View>(R.id.second_indicator)
        vp2.apply {
            offscreenPageLimit = 1
            initFragment(childFragmentManager,lifecycle, fragments)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                @SuppressLint("ResourceAsColor")
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when(position){
                        0->{
                            firstIndicator.setBackgroundResource(R.drawable.indicator_selected_shape)
                            secondIndicator.setBackgroundResource(R.drawable.indicator_unselected_shape)
                            firstIndicator.setDimensions(20,20)
                            secondIndicator.setDimensions(14,14)
                        }
                        1->{
                            firstIndicator.setBackgroundResource(R.drawable.indicator_unselected_shape)
                            secondIndicator.setBackgroundResource(R.drawable.indicator_selected_shape)
                            firstIndicator.setDimensions(14,14)
                            secondIndicator.setDimensions(20,20)
                        }
                    }
                }
            })
        }


    }

    inner class Click{

        fun exchangeFirstPage(){
            vp2.setCurrentItem(0,true)
        }

        fun exchangeSecondPage(){
            vp2.setCurrentItem(1,true)
        }

    }

}