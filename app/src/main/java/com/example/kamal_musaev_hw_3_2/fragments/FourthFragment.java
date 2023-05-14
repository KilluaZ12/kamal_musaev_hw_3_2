package com.example.kamal_musaev_hw_3_2.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamal_musaev_hw_3_2.R;

public class FourthFragment extends Fragment {

    TextView textViewName, textViewLastname, textViewAge,
            textViewGender, textViewPlaceOfStudy, textViewPlaceOfWork;
    String name, lastname, age, gender, placeOfStudy, placeOfWork;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        receivingArguments();
        setTextToTextView();
    }

    private void findViews() {
        textViewName = requireActivity().findViewById(R.id.text_view_name);
        textViewLastname = requireActivity().findViewById(R.id.text_view_lastname);
        textViewAge = requireActivity().findViewById(R.id.text_view_age);
        textViewGender = requireActivity().findViewById(R.id.text_view_gender);
        textViewPlaceOfStudy = requireActivity().findViewById(R.id.text_view_place_of_study);
        textViewPlaceOfWork = requireActivity().findViewById(R.id.text_view_place_of_work);
    }

    private void receivingArguments() {
        assert getArguments() != null;
        name = getArguments().getString("name");
        lastname = getArguments().getString("lastname");
        age = getArguments().getString("age");
        gender = getArguments().getString("gender");
        placeOfStudy = getArguments().getString("study");
        placeOfWork = getArguments().getString("work");
    }

    @SuppressLint("SetTextI18n")
    private void setTextToTextView() {
        textViewName.setText("Name: " + name);
        textViewLastname.setText("Lastname: " + lastname);
        textViewAge.setText("Age: " + age);
        textViewGender.setText("Gender: " + gender);
        textViewPlaceOfStudy.setText("Place of study: " + placeOfStudy);
        textViewPlaceOfWork.setText("Place of work: " + placeOfWork);
    }
}