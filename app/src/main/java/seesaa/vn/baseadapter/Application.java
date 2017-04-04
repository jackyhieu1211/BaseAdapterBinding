package seesaa.vn.baseadapter;

import android.content.Context;

/**
 * Created by jackyhieu1211 on 3/23/17.
 */

public class Application extends android.app.Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
