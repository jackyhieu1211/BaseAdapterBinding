package seesaa.vn.baseadapter.presenter;

import android.content.Context;
import android.content.Intent;

import seesaa.vn.baseadapter.activity.TestActivity;
import seesaa.vn.baseadapter.model.Address;
import seesaa.vn.baseadapter.model.User;
import seesaa.vn.baseadapter.utils.ToastUtils;
import seesaa.vn.library.base_adapter.BaseViewAdapter;

public class MainPresenter implements BaseViewAdapter.Presenter {

    private Context context;

    public MainPresenter(Context context) {
        this.context = context;

    }

    public void onItemClick(User user) {
        ToastUtils.showToast(context, "User " + user.name);
        context.startActivity(new Intent(context, TestActivity.class));
    }

    public void onItemClick(Address address) {
        ToastUtils.showToast(context, "Address " + address.street);
    }

}
