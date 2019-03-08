package com.example.supermai.ui.factoryactivities;

import android.view.View;

import com.example.supermai.R;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by cjimenez on 07/03/2019.
 */

public abstract class BaseActivity extends SupportNotificationsActivity implements View.OnClickListener {

    protected final static String RESULT_KEY = "result";
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected int setIdCoordinatorLayout(){
        return R.id.clContainer;
    }
}
