package seesaa.vn.baseadapter.model;

import android.databinding.BaseObservable;

public class User extends BaseObservable{

    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
