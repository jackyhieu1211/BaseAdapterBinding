package seesaa.vn.baseadapter.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import seesaa.vn.baseadapter.R;
import seesaa.vn.baseadapter.databinding.ActivityMainBinding;
import seesaa.vn.baseadapter.model.User;
import seesaa.vn.baseadapter.presenter.MainDecorator;
import seesaa.vn.baseadapter.presenter.MainPresenter;
import seesaa.vn.library.base_adapter.SingleTypeAdapter;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private SingleTypeAdapter<User> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        adapter = new SingleTypeAdapter<>(this, R.layout.item_user);
        adapter.setPresenter(new MainPresenter(this));
        adapter.setDecorator(new MainDecorator());
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User("Android", i);
            users.add(user);
        }
        Log.e("User ", users.size() + "");
        adapter.addAll(users);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(adapter);
    }
}
