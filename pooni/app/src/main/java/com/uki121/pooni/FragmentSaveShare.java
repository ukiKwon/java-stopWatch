package com.uki121.pooni;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentSaveShare extends Fragment {
    private Button btnShare;

    public void FragmentSaveShare(){};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_savenshare, container, false);

        btnShare = (Button) view.findViewById(R.id.btn_share);
        btnShare.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent toggleIntent = new Intent(), getIntent = getIntent();
                String shareStr = getIntent.getDataString();
                toggleIntent.setAction(Intent.ACTION_SEND);
                toggleIntent.putExtra(Intent.EXTRA_TEXT, shareStr);
                toggleIntent.setType("text/plain");

                startActivityForResult(Intent.createChooser(toggleIntent, "Share your Records"), 0);
                getIntent.putExtra("re", ">> Sharing's done");
                //setResult(RESULT_OK, getIntent);
                //finish();
                */
            }
        });
        return view;
    }

}
