package com.example.supermai.ui.factoryactivities;

import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.prefs.Preferences;

public class SupportNotificationsActivity extends SupportUXActivity {
    protected Preferences pref = null;
    private ViewPager mPagerNotifications = null;
    private NotificationsVPAdapter mAdapter = null;
    private List<Mensaje> mensajes = new ArrayList<>();

}
