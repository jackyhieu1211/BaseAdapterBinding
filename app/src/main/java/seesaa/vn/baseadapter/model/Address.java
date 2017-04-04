package seesaa.vn.baseadapter.model;


import android.databinding.BaseObservable;

public class Address extends BaseObservable {
    public String street;
    public int number;

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }
}
