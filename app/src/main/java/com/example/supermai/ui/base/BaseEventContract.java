package com.example.supermai.ui.base;

/**
 * Created by cjimenez on 07/03/2019.
 *
 * Eventos que desencadenan acciones dentro de la aplicación en la capa activity.
 *
 * Ademas están los TAGS de los fragments para ser manipulados en la capa activity.
 */

public class BaseEventContract {

    //EVENTOS de mensajes
    public static final String EVENT_SHOW_PROGRESS          = "showdialog";
    public static final String EVENT_DISMISS_PROGRESS       = "dismissdialog";
    public static final String EVENT_SHOW_ERROR             = "showError";
    public static final String EVENT_SHOW_MESSAGE           = "showMessage";
    public static final String EVENT_HIDE_KEYBOARD          = "hideKeyboard";
    public static final String EVENT_SHOW_KEYBOARD          = "showKeyboard";
    public static final String EVENT_DISSMISS_DIALOG        = "dimissDialog";
    public static final String EVENT_OPEN_TERMS             = "openTerms";
    public static final String EVENT_ENABLE_BACK_BUTTON     = "enableBackButton";
    public static final String EVENT_SET_TOOLBAR            = "setToolbar";

    //Run Time Permissions
    public static final String SHOW_APP_SETTINGS            = "appSettings";
    public static final String RT_OPTION_DECLINED           = "rtWereDeclined";
    public static final String HOME_RT_SHOW_DIALOG          = "HomeViewActivityShowRTFlag";

}
