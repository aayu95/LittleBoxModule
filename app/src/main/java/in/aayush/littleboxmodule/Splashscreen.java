package in.aayush.littleboxmodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;






public class Splashscreen extends AppCompatActivity implements Animation.AnimationListener {
    ProgressBar pb;
    ImageView iv;
    Animation slide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        iv =(ImageView)findViewById(R.id.iv);
        slide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        slide.setAnimationListener(this);
        iv.startAnimation(slide);
       // pb.setVisibility(View.INVISIBLE);

        Thread background = new Thread() {
            public void run() {

                try {
                    for (int i = 0; i < 4; i++) {
                        Thread.sleep(1000);
                        //pb.incrementProgressBy(25);

                    }

                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                    finish();

                } catch (Exception e) {

                }
            }
        };

        background.start();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

