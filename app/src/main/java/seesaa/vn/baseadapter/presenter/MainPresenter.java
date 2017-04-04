package seesaa.vn.baseadapter.presenter;

import android.content.Context;
import android.content.Intent;

import seesaa.vn.baseadapter.activity.TestActivity;
import seesaa.vn.baseadapter.base_adapter.BaseViewAdapter;
import seesaa.vn.baseadapter.model.Address;
import seesaa.vn.baseadapter.model.User;
import seesaa.vn.baseadapter.utils.ToastUtils;

public class MainPresenter implements BaseViewAdapter.Presenter {

    private Context context;

    public MainPresenter(Context context) {
        this.context = context;

    }

    public void onItemClick(User user) {
        ToastUtils.showToast("User " + user.name);
        context.startActivity(new Intent(context, TestActivity.class));
    }

    public void onItemClick(Address address) {
        ToastUtils.showToast("Address " + address.street);
    }

}
