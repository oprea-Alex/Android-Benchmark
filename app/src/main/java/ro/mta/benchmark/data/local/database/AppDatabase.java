package ro.mta.benchmark.data.local.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ro.mta.benchmark.data.local.dao.UserDao;
import ro.mta.benchmark.data.local.entity.UserEntity;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
