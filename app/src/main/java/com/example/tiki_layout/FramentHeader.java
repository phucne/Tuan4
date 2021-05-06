package com.example.tiki_layout;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FramentHeader#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FramentHeader extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  ImageButton btnAdd,btnTru;
    private  TextView tvSL;
    private int SL=0;
    SendingData data;
    double tt=0;
    public FramentHeader() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        data = (SendingData) context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FramentHeader.
     */
    // TODO: Rename and change types and number of parameters
    public static FramentHeader newInstance(String param1, String param2) {
        FramentHeader fragment = new FramentHeader();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frament_header,container,false);


         btnAdd = view.findViewById(R.id.btnAdd);
         btnTru = view.findViewById(R.id.btnTru);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    SL = Integer.parseInt(tvSL.getText().toString());
                    SL++;
                    tvSL.setText(String.valueOf(SL));
                    tt = SL * 148000;
                    data.sendingData((String.valueOf(tt)));

            }
        });
      btnTru.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
                 if (Integer.parseInt(tvSL.getText().toString())>0){
                     SL = Integer.parseInt(tvSL.getText().toString());
                     SL--;
                     tt = SL * 148000;
                     data.sendingData((String.valueOf(tt)));
                     tvSL.setText(String.valueOf(SL));
                 }


          }
      });

        tvSL =view.findViewById(R.id.tvSL);
        return view;
    }

}