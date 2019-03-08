package com.example.supermai.ui.factoryactivities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import com.example.supermai.R;
import com.example.supermai.ui.base.factoryinterfaces.IProcessData;

import java.util.ArrayList;
import java.util.List;

import static com.example.supermai.ui.base.BaseEventContract.SHOW_APP_SETTINGS;

public abstract class BasePresenterPermissionActivity<iProcessData extends IProcessData> extends BasePresenterActivity<iProcessData> {

    private final static int PERMISSIONS_ID = 122333;
    private final static  String PACKAGE_LBL = "package";

    protected void showAppSettings(){
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts(PACKAGE_LBL, getPackageName(), null));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    protected void requestPermissions(String[] permissions){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!arePermissionsGranted(permissions))
                requestPermissions(permissions, PERMISSIONS_ID);
            else
                doPermissionsGrantedAction();
        }else
            doPermissionsGrantedAction();
    }


    private boolean arePermissionsGranted(String[] permissions){
        boolean permissionsAreGranted = true;
        for (String permission :permissions){
            if (checkSelfPermission(permission) == PackageManager.PERMISSION_DENIED)
                permissionsAreGranted = false;
        }
        return permissionsAreGranted;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        List<String> deniedPermissions = new ArrayList<>();
        int index = 0;
        Log.v("Permission", String.valueOf(requestCode));
        switch (requestCode){
            case PERMISSIONS_ID:
                if (grantResults.length > 0){

                    for (int grantResult : grantResults){
                        if (grantResult == PackageManager.PERMISSION_DENIED)
                            deniedPermissions.add(permissions[index]);
                        index++;
                    }

                    if (deniedPermissions.size() > 0){
                        boolean showRationale = true;

                        for (String permission : deniedPermissions){
                            if (!shoulShowRequestPermissionRationale(permission))
                                showRationale = false;
                        }

                        if (showRationale){
                            DialogFactory.buildRationaleRunTimeDialog(this, getDeniedPermissionsMessage(getDeniedPermissionsGroups(deniedPermissions)));
                        } else {
                            DialogFactory.buildAppSettingsRationaleRTDialog(this, getDeniedPermissionsMessage(getDeniedPermissionsGroups(deniedPermissions)));
                        }
                    }else
                        doPermissionsGrantedAction();
                }

                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }

    protected void doPermissionsGrantedAction(){}

    private List<String> getDeniedPermissionsGroups(List<String> permissions){
        List<String> deniedGroups = new ArrayList<>();
        for (String permission : permissions){
            switch (permission){
                case Manifest.permission.CAMERA:
                    deniedGroups.add(Manifest.permission_group.CAMERA);
                    break;
                case Manifest.permission.READ_SMS:
                case Manifest.permission.RECEIVE_SMS:
                    if (!deniedGroups.contains(Manifest.permission_group.SMS))
                        deniedGroups.add(Manifest.permission_group.SMS);
                    break;
                case Manifest.permission.READ_EXTERNAL_STORAGE:
                case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                    if (!deniedGroups.contains(Manifest.permission_group.STORAGE))
                        deniedGroups.add(Manifest.permission_group.STORAGE);
                    break;
            }
        }

        return deniedGroups;
    }

    protected String getDeniedPermissionsMessage(List<String> permissionsGroup){
        StringBuffer buffer = new StringBuffer();
        buffer.append(getString(R.string.general_run_time_message) + "\n\n\n");
        for (String permission : permissionsGroup){
            if (getDeniedPermissionsMessage(permission).trim().length() <= 0)
                continue;
            else{
                buffer.append(getDeniedPermissionsMessage(permission));
                if (permission.indexOf(permission) != permissionsGroup.size()-1);
                    buffer.append("\n\n");
            }

        }

        return buffer.toString();
    }

    protected String getDeniedPermissionMessage(String permissionGroup){
        switch (permissionGroup){
            case Manifest.permission_group.CAMERA:
                return getString(R.string.runtime_camera);
            case Manifest.permission_group.SMS:
                return getString(R.string.runtime_sms);
            case Manifest.permission_group.STORAGE:
                return getString(R.string.runtime_storage);
        }
        return "";
    }

    @Override
    public void onEvent(String event, Object data) {
        super.onEvent(event, data);
        switch (event) {
            case SHOW_APP_SETTINGS:
                showAppSettings();
                break;
        }
    }
}