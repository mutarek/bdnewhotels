package com.techtrickbd.nshop.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.techtrickbd.nshop.R;
import com.techtrickbd.nshop.activities.HomeActivity;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    public SignUpFragment() {
        // Required empty public constructor
    }
    private EditText numberEt;
    private Button btnNext;
    private View view;
    private PinView pinView;
    private EditText nameET;
    private EditText gameET;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        casting(view);



        return view;
    }

    private void onClickLister(View view) {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNullValue();
            }
        });
    }

    private void checkNullValue() {
        String number = numberEt.getText().toString();
        if (number.isEmpty())
        {
            Toasty.error(getContext(), "Please enter your number", Toast.LENGTH_SHORT, true).show();
        }
        else if (!number.startsWith("01"))
        {
            Toasty.warning(getContext(), "Please enter a valid number", Toast.LENGTH_SHORT, true).show();
        }
        else if (!(number.length() ==11))
        {
            Toasty.warning(getContext(), "Number should be 11 character", Toast.LENGTH_SHORT, true).show();
        }
        else
        {
            sendOTP();
        }


    }

    private void sendOTP() {
        numberEt.setVisibility(View.GONE);
        pinView.setVisibility(View.VISIBLE);
        btnNext.setText("Verify");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goForVerify();
            }
        });
    }

    private void goForVerify() {
        pinView.setVisibility(View.GONE);
        nameET.setVisibility(View.VISIBLE);
        numberEt.setText(null);
        gameET.setVisibility(View.VISIBLE);
        btnNext.setText("Done");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void casting(View view) {
        numberEt = view.findViewById(R.id.number_ET);
        btnNext = view.findViewById(R.id.btn_next);
        pinView = view.findViewById(R.id.firstPinView);
        gameET = view.findViewById(R.id.game_id);
        nameET = view.findViewById(R.id.name_ET);
    }

    @Override
    public void onStart() {
        super.onStart();
        onClickLister(view);
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
