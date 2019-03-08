package com.example.supermai.ui.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.supermai.R;
import com.example.supermai.ui.base.factoryfragments.BasePermissionsFragment;
import com.example.supermai.ui.base.factoryinterfaces.IEventOnFragment;
import com.example.supermai.ui.dialogs.model.DialogContent;

import static com.example.supermai.ui.dialogs.DialogContract.KEY_DIALOG_CONTENT;

public class GenericDialog extends DialogFragment implements View.OnClickListener {
    private final static String MAIL_COLOR_KEY = "mailColor";
    private DialogContent dialogContent;
    private IEventOnFragment eventOnFragment;
    private boolean secondaryActionTransition = false;
    private BasePermissionsFragment permissionsFragment = null;

    public static GenericDialog newInstance(String dialosgContent){

        Bundle args = new Bundle();
        args.putString(KEY_DIALOG_CONTENT, dialosgContent);
        GenericDialog fragment = new GenericDialog();
        fragment.setArguments(args);
        return fragment;
    }

    public static GenericDialog newInstance(String dialogContent, int colorId){
        Bundle args = new Bundle();
        args.putString(KEY_DIALOG_CONTENT, dialogContent);
        args.putInt(MAIL_COLOR_KEY, colorId);
        GenericDialog fragment = new GenericDialog();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(KEY_DIALOG_CONTENT)){
            dialogContent = new Gson().fromJson(getArguments().getString(KEY_DIALOG_CONTENT), DialogContent.class);
        }else {
            throw new RuntimeException("Cant create dialog!!");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        if (dialogContent.getIdLayout() != -1){
            return inflater.inflate(dialogContent.getIdLayout(), container, false);
        } else {
            throw new RuntimeException("first you need set a idLayout resource!!");
        }
    }


    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        setButtonPrimaryProperties(view);
        setButtonSecondaryProperties(view);
        setTitleProperties(view);
        setContentProperties(view);
        setImageResource(view);
    }

    public void setPermissionsFragment(BasePermissionsFragment permissionsFragment){
        this.permissionsFragment = permissionsFragment;
    }

    private void setImageResource(View root){
        AppCompatImageView imageResource = (AppCompatImageView) root.findViewById(R.id.idImageResource)
    }
























    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPrimary:
                switch (dialogContent.getType()){
                    case DIALOG_RUN_TIME_RATIONALE:
                        if(permissionsFragment != null)
                            permissionsFragment.setShouldCheckPermissions(true);
                    default:
                        sendEvent(dialogContent.getActionPrimary(), null);
                        dismiss();
                        break;
                }
                break;
            case R.id.btnSecondary:
                switch (dialogContent.getType()){
                    default:
                        sendEvent(dialogContent.getActionSecondary(), null);
                        secondaryActionTransition = true;
                        dismiss();
                        break;
                }
                break;
            default:
                dismiss();
                break;
        }
    }
}
