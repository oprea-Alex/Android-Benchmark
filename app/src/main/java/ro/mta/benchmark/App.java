package ro.mta.benchmark;

import android.app.Application;

import androidx.room.Room;

import com.jakewharton.threetenabp.AndroidThreeTen;

import ro.mta.benchmark.data.local.database.AppDatabase;
import timber.log.Timber;

public class App extends Application {

    private static App mApplicationInstance = null;
    private static AppDatabase mDatabaseInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();

        // Application initialization
        mApplicationInstance = this;
        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());
        AndroidThreeTen.init(this);

        //Initialization of singleton components
        mDatabaseInstance = Room.databaseBuilder(
                this,
                AppDatabase.class,
                "benchmark_database").fallbackToDestructiveMigration()
                .build();


        Timber.d("App has been initialized...");
    }

    public static App getInstance() {
        return mApplicationInstance;
    }

    public static AppDatabase getDatabaseInstance(){
        return mDatabaseInstance;
    }
}
