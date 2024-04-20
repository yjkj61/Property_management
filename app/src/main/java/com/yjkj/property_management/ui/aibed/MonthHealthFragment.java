package com.yjkj.property_management.ui.aibed;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.yjkj.property_management.BR;
import com.yjkj.property_management.R;
import com.yjkj.property_management.library.base.BaseFragment;

public class MonthHealthFragment extends BaseFragment {

    private MonthHealthViewModel viewModel;


    @Override
    protected void initViewModel() {
        viewModel = getActivityScopeViewModel(MonthHealthViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_month_health, BR.viewModel,viewModel);
    }
}
