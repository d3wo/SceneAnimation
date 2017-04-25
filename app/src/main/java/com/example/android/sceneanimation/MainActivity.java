package com.example.android.sceneanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {


    private ViewGroup mSceneRoot;
    private Scene mAScene;
    private Scene mAnotherScene;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        // Create the scene root for the scenes in this app
        mSceneRoot = (ViewGroup) findViewById(R.id.scene_root);

        // Create the scenes
        mAScene = Scene.getSceneForLayout(mSceneRoot, R.layout.a_scene, this);
        mAnotherScene =
                Scene.getSceneForLayout(mSceneRoot, R.layout.another_scene, this);



    }


    @Override
    protected void onStart() {
        super.onStart();

        View anyView = findViewById(R.id.scene_root);
        anyView.post(new Runnable()
        {
            @Override
            public void run()
            {
                // Your code goes here
                TransitionManager.go(mAnotherScene, new ChangeBounds());
            }
        });

    }



    public void buttonClicked(View view){
        TransitionManager.go(mAScene, new ChangeBounds());

    }



}
