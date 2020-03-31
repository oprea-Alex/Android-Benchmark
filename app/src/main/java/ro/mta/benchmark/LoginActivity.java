package ro.mta.benchmark;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private Button callSignUpBtn, loginBtn;
    private ImageView logoIv;
    private TextView logoTV, sloganTV;
    private TextInputLayout usernameET, passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_login);

        //Hooks
        this.callSignUpBtn = findViewById(R.id.loginBTN_go_to_signup);
        this.logoIv = findViewById(R.id.downscaled_splashscreen_logo);
        this.logoTV = findViewById(R.id.loginTV_welcome_text);
        this.sloganTV = findViewById(R.id.loginTV_please_signin);
        this.usernameET = findViewById(R.id.loginET_username);
        this.passwordET = findViewById(R.id.loginET_password);
        this.loginBtn = findViewById(R.id.loginBTN_login);


        this.callSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);

                Pair[] pairs = new Pair[7];

                pairs[0] = new Pair<View, String>(logoIv, "logo_image");
                pairs[1] = new Pair<View, String>(logoTV,"logo_text");
                pairs[2] = new Pair<View, String>(sloganTV,"logo_desc");
                pairs[3] = new Pair<View, String>(usernameET,"username_tran");
                pairs[4] = new Pair<View, String>(passwordET,"password_tran");
                pairs[5] = new Pair<View, String>(loginBtn,"login_button_tran");
                pairs[6] = new Pair<View, String>(callSignUpBtn,"login_signup_tran");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
                startActivity(intent,options.toBundle());

            }
        });

    }

    public void launchMenu(View view) {
        Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}
