package com.example.kamal_musaev_hw_3_2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kamal_musaev_hw_3_2.R;

public class SecondFragment extends Fragment {

    EditText editTextAge, editTextGender;
    AppCompatButton buttonSecond;
    Integer age;
    String gender, name, lastname;
    String male = "male";
    String female = "female";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            findViews();
            receivingArguments();
            setClick();
        }
    }

    private void findViews() {
        editTextAge = requireActivity().findViewById(R.id.edit_text_age);
        editTextGender = requireActivity().findViewById(R.id.edit_text_gender);
        buttonSecond = requireActivity().findViewById(R.id.button_in_second_fragment);
    }

    private void setClick() {
        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initEditText();
            }
        });
    }

    private void initEditText() {
        try {
            age = Integer.valueOf(editTextAge.getText().toString());
            gender = editTextGender.getText().toString();

            if (age > 5 && age <= 100) {
                if (gender.equals(male) || gender.equals(female)) {
                    navigationToThirdFragment();
                } else {
                    Toast.makeText(getActivity(),
                            "Enter full length male or female",
                            Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getActivity(),
                        "Age must be greater than 5 and less than 101",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(),
                    "Enter an integer",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void receivingArguments() {
        assert getArguments() != null;
        name = getArguments().getString("name");
        lastname = getArguments().getString("lastname");
    }

    private void navigationToThirdFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("lastname", lastname);
        bundle.putString("age", String.valueOf(age));
        bundle.putString("gender", gender);

        ThirdFragment thirdFragment = new ThirdFragment();
        thirdFragment.setArguments(bundle);

        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, thirdFragment)
                .addToBackStack(null)
                .commit();
    }
}