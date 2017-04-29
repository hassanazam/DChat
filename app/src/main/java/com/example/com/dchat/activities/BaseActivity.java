package com.example.com.dchat.activities;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.com.dchat.R;
import com.example.com.dchat.infrastructure.DChatApplication;
import com.example.com.dchat.views.NavDrawer;

public abstract class BaseActivity extends AppCompatActivity{
    protected DChatApplication application;
    protected Toolbar toolbar;
    protected NavDrawer navDrawer;
    protected boolean isTablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        application = (DChatApplication) getApplication();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        isTablet = (metrics.widthPixels / metrics.density ) >= 600;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResId) {
        super.setContentView(layoutResId);

        toolbar = (Toolbar) findViewById(R.id.include_toolbar);
        if(toolbar != null)
            setSupportActionBar(toolbar);
    }

    public void fadeOut(final FadeOutListener listener) {
        View rootView = findViewById(android.R.id.content);
        rootView.animate()
                .alpha(0)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        listener.onFadeOutEnd();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .setDuration(300)
                .start();
    }

    protected void setNavDrawer(NavDrawer drawer) {
        this.navDrawer = drawer;
        this.navDrawer.create();

        //donot use default animation
        overridePendingTransition(0, 0);
        View rootView  = findViewById(android.R.id.content);
        rootView.setAlpha(0);
        rootView.animate().alpha(1).setDuration(450).start();

    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public DChatApplication getDChatApplication() {
        return application;
    }

    public interface FadeOutListener {
        public void onFadeOutEnd();
    }
}



