package ro.mta.benchmark.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.sql.Timestamp;

@Entity(tableName = "user_table", indices = {@Index(value = {"username"}, unique = true)})
public class UserEntity {

    @PrimaryKey
    @NonNull
    private final String username;

    private final String password;

    private final String email;

    private final String name;

    private final Timestamp addedAt;


    public UserEntity(@NonNull String username, String password, String email, String name, Timestamp addedAt) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.addedAt = addedAt;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Timestamp getAddedAt() {
        return addedAt;
    }
}
