package seesaa.vn.baseadapter.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import seesaa.vn.baseadapter.R;
import seesaa.vn.baseadapter.databinding.ActivityTestBinding;
import seesaa.vn.baseadapter.model.Address;
import seesaa.vn.baseadapter.model.User;
import seesaa.vn.baseadapter.presenter.MainDecorator;
import seesaa.vn.baseadapter.presenter.MainPresenter;
import seesaa.vn.library.base_adapter.MultiTypeAdapter;

public class TestActivity extends AppCompatActivity {

    private ActivityTestBinding binding;
    private MultiTypeAdapter adapter;


    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_USER = 1;
    private static final int VIEW_TYPE_ADDRESS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        adapter = new MultiTypeAdapter(this);
        adapter.setPresenter(new MainPresenter(this));
        adapter.setDecorator(new MainDecorator());
        adapter.addViewTypeToLayoutMap(VIEW_TYPE_HEADER, R.layout.item_header);
        adapter.addViewTypeToLayoutMap(VIEW_TYPE_USER, R.layout.item_user);
        adapter.addViewTypeToLayoutMap(VIEW_TYPE_ADDRESS, R.layout.item_address);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User("Team", i);
            users.add(user);
        }

        List<Address> addresses = new ArrayList<>();
        for (int i = 5; i < 10; i++) {
            Address address = new Address("Android", i);
            addresses.add(address);
        }

        adapter.add(0, null, VIEW_TYPE_HEADER);
        adapter.addAll(users, VIEW_TYPE_USER);

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0 && i != 0) {
                adapter.add(i, new Address("Android", 9999), VIEW_TYPE_ADDRESS);
            }
            //Log.e("AAA", i + "");
        }

//        final List<Object> objects = new ArrayList<>();
//        objects.addAll(users);
//        objects.addAll(addresses);
//
//        adapter.addAll(objects, new MultiTypeAdapter.MultiViewTyper() {
//            @Override
//            public int getViewType(Object item) {
//                if (item instanceof User)
//                    return VIEW_TYPE_USER;
//
//                if (item instanceof Address)
//                    return VIEW_TYPE_ADDRESS;
//                return 0;
//            }
//        });

    }
}
