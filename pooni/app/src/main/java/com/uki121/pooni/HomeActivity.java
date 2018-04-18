package com.uki121.pooni;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;


import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by uki121 on 2018-04-03.
 */

public class HomeActivity extends AppCompatActivity {//} implements FragmentHomeMenu.OnHomeMenuSelectedListener{

    //private bookShelf sb;
    //private View setting_dial_view;
    private onKeyBackPressedListener mOnKeyBackPressedListener;

    @Override
    protected void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        try {
            setContentView(R.layout.activity_home);
            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();

            fragmentTransaction.add(R.id.frag_home_container, new FragmentHomeMenu());
            fragmentTransaction.commit();
        } catch(Exception e) {
            Log.e("ERROR", e.getMessage());
        }
    }
    /*
    @Override
    public void onClicked( View v )  {
        switch( v.getId() ) {
            case R.id.btn_new_start: {
                // Do something in response to button click
                boolean wrapInScrollView = true;
                final MaterialDialog startDialog = new MaterialDialog.Builder(HomeActivity.this)
                        .title("setting")
                        .positiveText("확인")
                        .negativeText("취소")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                // Some unimportant data stuff
                                try {
                                    setting_dial_view = dialog.getCustomView();
                                    if (setting_dial_view != null) {
                                        //View v = dialog.getCustomView();
                                        sb.AddBooks(setting_dial_view);
                                        sb.printBooks();
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        })
                        .customView(R.layout.customview_setting, wrapInScrollView)
                        .build();
                startDialog.show();
                break;
            }
            case R.id.btn_quick_start: {
                Fragment newFragment = new FragmentLap();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.frag_home_container, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
                break;
            }
            case R.id.btn_setlog : {
                Fragment newFragment = new FragmentSetLog();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.frag_home_container, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
                break;
            }
        }
    }
    */
    public interface onKeyBackPressedListener {
        public void onBack();
    }
    public void setOnKeyBackPressedListener(onKeyBackPressedListener listener) {
        mOnKeyBackPressedListener = listener;
    }
    public void onBackPressed() {
        if (mOnKeyBackPressedListener != null) {
            mOnKeyBackPressedListener.onBack();
        } else {
            super.onBackPressed();
        }
    }
}
