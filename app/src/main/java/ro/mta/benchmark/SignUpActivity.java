package ro.mta.benchmark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout regName, regUsername, regMail, regPassword;
    private Button regBtn, regToLoginBtn;

    private FirebaseDatabase rootNode;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_sign_up);

        regName = findViewById(R.id.signupET_full_name);
        regUsername = findViewById(R.id.signupET_username);
        regMail = findViewById(R.id.signupET_email);
        regPassword = findViewById(R.id.signupET_password);
        regBtn = findViewById(R.id.signupBTN_signup);
        regToLoginBtn = findViewById(R.id.signupBTN_go_to_login);

    }

    private Boolean validateName(){
        String val = Objects.requireNonNull(regName.getEditText()).getText().toString();
        if(val.isEmpty()){
            regName.setError("Field cannot be empty!");
            return false;
        }
        else{
         regName.setError(null);
         return true;
        }
    }

    private Boolean validateUsername(){
        String val = Objects.requireNonNull(regUsername.getEditText()).getText().toString();
        String noWhiteSpace = " ";

        if(val.isEmpty()){
            regUsername.setError("Field cannot be empty!");
            return false;
        } else if (val.length() >= 15){
            regUsername.setError("Username too long! The upper limit is 15 characters.");
            return false;
        } else if (val.matches(noWhiteSpace)){
            regUsername.setError("White Spaces are not allowed!");
            return false;
        }
        else{
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail(){
        String val = Objects.requireNonNull(regMail.getEditText()).getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            regMail.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(emailPattern)){
            regMail.setError("Invalid address! Try [address@example.domain].");
            return false;
        }
        else{
            regMail.setError(null);
            return true;
        }
    }

    private Boolean validatePassword(){
        String val = Objects.requireNonNull(regPassword.getEditText()).getText().toString();
/*        String passwordVal = "^" +
                "(?=.*[a-zA-Z])" +
                ".{4,}" +
                "(?=.*[0-9])" +
                "(?=.*[A-Z])" +
                "(?=.*[!@#$%^&+=])" +
                "$";*/

        String passwordVal = "A";

        if(val.isEmpty()){
            regPassword.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(passwordVal)){
            regPassword.setError("Password is too weak! Use at least 1 upper case, 1 special character[!@#$%^&] and minimum 4 letters.");
            return false;
        }
        else{
            regPassword.setError(null);
            return true;
        }
    }


    //Save data in FireBase on SignUp button click
    public void registerUser(View view) {

        validateName();
        if(!validateName() || !validateUsername() || !validateEmail() || !validatePassword()){
            return;
        }

        //Get all values in String
        String name = Objects.requireNonNull(regName.getEditText()).getText().toString();
        String username = Objects.requireNonNull(regUsername.getEditText()).getText().toString();
        String email = Objects.requireNonNull(regMail.getEditText()).getText().toString();
        String password = Objects.requireNonNull(regPassword.getEditText()).getText().toString();

        UserInfoContainer userInfoContainer = new UserInfoContainer(name,username,email,password);
        //this.databaseReference.child(username).setValue(userInfoContainer);

        Intent intent = new Intent(SignUpActivity.this,DashboardActivity.class);
        startActivity(intent);
        finish();

    }

    public void launchLoginActivity(View view) {
        Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
