package com.example.kamal_musaev_hw_3_2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kamal_musaev_hw_3_2.R;

public class ThirdFragment extends Fragment {

    EditText editTextPlaceOfStudy, editTextPlaceOfWork;
    AppCompatButton buttonThird;
    String name, lastname, age, gender, placeOfStudy, placeOfWork;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        receivingArguments();
        setClick();
    }

    private void findViews() {
        editTextPlaceOfStudy = requireActivity().findViewById(R.id.edit_text_place_of_study);
        editTextPlaceOfWork = requireActivity().findViewById(R.id.edit_text_place_of_work);
        buttonThird = requireActivity().findViewById(R.id.button_in_third_fragment);
    }

    private void setClick() {
        buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initEditText();
            }
        });
    }

    private void initEditText() {
        placeOfStudy = editTextPlaceOfStudy.getText().toString();
        placeOfWork = editTextPlaceOfWork.getText().toString();
        if (placeOfStudy.length() > 3 && placeOfWork.length() > 3) {
            navigationToFourthFragment();
        } else {
            Toast.makeText(getActivity(),
                    "Fill in all fields, input data must be more than three characters",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void receivingArguments() {
        assert getArguments() != null;
        name = getArguments().getString("name");
        lastname = getArguments().getString("lastname");
        age = getArguments().getString("age");
        gender = getArguments().getString("gender");
    }
    private void navigationToFourthFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("lastname", lastname);
        bundle.putString("age", age);
        bundle.putString("gender", gender);
        bundle.putString("study", placeOfStudy);
        bundle.putString("work", placeOfWork);

        FourthFragment fourthFragment = new FourthFragment();
        fourthFragment.setArguments(bundle);

        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, fourthFragment)
                .addToBackStack(null)
                .commit();
    }
}