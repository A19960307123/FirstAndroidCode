package com.example.myapplication.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class AFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String TAG = "AFragment";
    private String param1;

    TextView textView;
    Button mBtnChange,mBtnReset;
    Fragment bFragment;
    public static AFragment newInstance(String str){
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1,str);
        AFragment aFragment = new AFragment();
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test_a, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        if (getArguments() != null) {
            param1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.fragment_text_a);
        mBtnChange = view.findViewById(R.id.next_Fragment);
        mBtnReset = view.findViewById(R.id.next_text);
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("new Text");
                param1 = "new Text";
            }
        });
        mBtnChange.setOnClickListener(v -> {
            if(bFragment==null){
                bFragment = new BFragment();
            }
            getFragmentManager().beginTransaction().replace(R.id.fragment, bFragment).addToBackStack(null).commitAllowingStateLoss();
        });
        if (param1!=null){
            textView.setText(param1);
            Log.d(TAG, "param1="+param1);
        }

    }
}
