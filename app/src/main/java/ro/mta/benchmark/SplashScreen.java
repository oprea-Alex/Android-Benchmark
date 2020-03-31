package ro.mta.benchmark;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private Animation topAnim, bottomAnim;
    private ImageView imageView;
    private TextView logo, motto;
    private View fullScreenView;
    private final static int SPLASH_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_splashscreen);

        //Animations
        this.topAnim = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.top_animation);
        this.bottomAnim = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.bottom_animation);

        //Hooks
        this.imageView = findViewById(R.id.ssIV_logo);
        this.logo = findViewById(R.id.ssTV_app_title);
        this.motto = findViewById(R.id.ssTV_welcome_motto);

        this.imageView.setAnimation(topAnim);
        this.logo.setAnimation(bottomAnim);
        this.motto.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(imageView,"logo_image");
                pairs[1] = new Pair<View,String>(logo,"logo_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this,pairs);

                startActivity(intent,options.toBundle());

                finish();

            }
        },SPLASH_DURATION);


    }
}
