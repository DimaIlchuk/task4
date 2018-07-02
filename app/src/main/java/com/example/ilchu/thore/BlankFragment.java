package com.example.ilchu.thore;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TEXT = "text";


    // TODO: Rename and change types of parameters
    private String mText;


    private OnFragmentInteractionListener mListener;
    private EditText  editTextFragment;
    private Button buttonFragment;

    public BlankFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String text) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(TEXT, text);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mText = getArguments().getString(TEXT);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank,container,false);

        buttonFragment = view.findViewById(R.id.button_fragment);
        editTextFragment = view.findViewById(R.id.edittext_fragment);
        editTextFragment.setText(mText);
        editTextFragment.requestFocus();

        buttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sendBackText = editTextFragment.getText().toString();
                sendBack(sendBackText);
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void sendBack(String senBackText) {
        if (mListener != null) {
            mListener.onFragmentInteraction(senBackText);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String sendBackText);
    }
}
