package ro.mta.benchmark.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.sql.Timestamp;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import ro.mta.benchmark.data.local.entity.UserEntity;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user_table")
    Observable<List<UserEntity>> getAllUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserEntity userEntity);

    @Update
    void updateUser(UserEntity userEntity);

    @Delete
    void deleteUser(UserEntity userEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAllUsers(List<UserEntity> userEntityList);

    @Query("SELECT * FROM user_table WHERE username =:userName")
    Single<UserEntity> getUserByUsername(String userName);

    @Query("SELECT addedAt FROM user_table WHERE username =:userName")
    Single<Timestamp> getAddedAtByUsername(String userName);

    @Query("SELECT * FROM user_table WHERE addedAt =:timestamp")
    Observable<UserEntity> getUsersByTimestamp(Timestamp timestamp);
}
