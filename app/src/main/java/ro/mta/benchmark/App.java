package ro.mta.benchmark;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

import timber.log.Timber;

public class App extends Application {

    public static App mApplicationInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();

        // Application initialization
        mApplicationInstance = this;
        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());
        AndroidThreeTen.init(this);

        //Initialization of singleton components



        Timber.d("App has been initialized...");
    }
}
