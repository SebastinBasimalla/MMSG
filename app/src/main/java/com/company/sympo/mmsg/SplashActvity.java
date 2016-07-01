package com.company.sympo.mmsg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActvity extends Activity implements Animation.AnimationListener{

    Animation ZoomIn,fadein;
    ImageView splashMainImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_actvity);

        splashMainImage=(ImageView)findViewById(R.id.splashMainImage);
       // ZoomIn= AnimationUtils.loadAnimation(SplashActvity.this,R.anim.zoom_in);
        fadein= AnimationUtils.loadAnimation(SplashActvity.this,R.anim.fade);


        splashMainImage.setVisibility(View.VISIBLE);

        //splashMainImage.startAnimation(ZoomIn);
         splashMainImage.startAnimation(fadein);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                   Intent intent = new Intent(SplashActvity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();


    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
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
