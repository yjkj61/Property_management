package com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.item

import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.yjkj.property_management.R
import com.yjkj.property_management.entity.City
import com.yjkj.property_management.entity.District
import com.yjkj.property_management.library.utils.ext.ifNull
import com.yjkj.property_management.library.utils.ext.toast
import com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.SecondHomePageViewModel

private typealias OnSpinnerProvinceItemSelected = (Pair<String,List<City>>)->Unit
private typealias OnSpinnerCityItemSelected = (Pair<String,List<District>>)->Unit
private typealias OnSpinnerDistrictsItemSelected = (name : String,cityCode : String)->Unit

class SearchItemViewModel(val viewModel: SecondHomePageViewModel,val type : String) {


    private var onSpinnerProvinceItemSelectedCallback : OnSpinnerProvinceItemSelected? = null
    private var onSpinnerCityItemSelectedCallback : OnSpinnerCityItemSelected? = null
    private var onSpinnerDistrictsItemSelectedCallback : OnSpinnerDistrictsItemSelected? = null

    val itemType = ObservableField("$type :")
    val editHint = ObservableField("请输入${type.replace("\r","")}")
    val editValue = ObservableField<String>()

    var areaData = ObservableArrayList<String>()
    //省
    var provinceMap = mutableMapOf<String,List<City>>()
    //市
    var cityMap = mutableMapOf<String,List<District>>()
    //区/县
    var districtDatas = mutableListOf<District>()

    val areaItemLayout = ObservableField(R.layout.area_item_layout)

    fun isNotEmpty():Boolean = !editValue.get().isNullOrEmpty()

    fun isEmpty():Boolean = editValue.get().isNullOrEmpty()

    fun getValue():String{
//        return editValue.get().toString().ifNull { "" }
        if ("null".equals(editValue.get().toString())){
            return ""
        }else{
            return editValue.get().toString();
        }

    }

    fun clear(){
        editValue.set("")
    }

    fun setProvinceData(data : MutableMap<String,List<City>>){
        provinceMap = data
        if(areaData.isNotEmpty()){
            areaData.clear()
        }
        provinceMap.keys.forEach {
            areaData.add(it)
        }
    }

    fun setCityData(data : MutableMap<String,List<District>>){
        cityMap = data
        if(areaData.isNotEmpty()){
            areaData.clear()
        }
        cityMap.keys.forEach {
            areaData.add(it)
        }
    }

    fun setDistrictsData(data : List<District>){
        districtDatas = data.toMutableList()
        if(areaData.isNotEmpty()){
            areaData.clear()
        }
        districtDatas.forEach {
            areaData.add(it.name)
        }
    }



    fun OnSpinnerProvinceItemSelected(callback: OnSpinnerProvinceItemSelected){
        onSpinnerProvinceItemSelectedCallback = callback
    }
    fun OnSpinnerCityItemSelected(callback: OnSpinnerCityItemSelected){
        onSpinnerCityItemSelectedCallback = callback
    }
    fun OnSpinnerDistrictsItemSelected(callback: OnSpinnerDistrictsItemSelected){
        onSpinnerDistrictsItemSelectedCallback = callback
    }

    val onSpinnerItemSelected = object : OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            if(provinceMap.isNotEmpty()){
                val var1 = areaData[p2]
                val citys = provinceMap[var1] ?: return
                onSpinnerProvinceItemSelectedCallback?.invoke(Pair(var1,citys))
            }else if(cityMap.isNotEmpty()){
                val var1 = areaData[p2]
                val district = cityMap[var1] ?: return
                onSpinnerCityItemSelectedCallback?.invoke(Pair(var1,district))
            }else if(districtDatas.isNotEmpty()){
                val district = districtDatas[p2]
                val districtName = areaData[p2]
                onSpinnerDistrictsItemSelectedCallback?.invoke(districtName,district.citycode.toString())
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {

        }

    }

}