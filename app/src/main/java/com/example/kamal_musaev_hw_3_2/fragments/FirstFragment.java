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

public class FirstFragment extends Fragment {

    EditText editTextName, editTextLastName;
    AppCompatButton buttonFirst;
    String name, lastName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        setClick();
    }

    private void findViews() {
        editTextName = requireActivity().findViewById(R.id.edit_text_name);
        editTextLastName = requireActivity().findViewById(R.id.edit_text_lastname);
        buttonFirst = requireActivity().findViewById(R.id.button_in_first_fragment);
    }

    private void setClick() {
        buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initEditText();
            }
        });
    }

    private void initEditText() {
        name = editTextName.getText().toString();
        lastName = editTextLastName.getText().toString();
        if (name.length() > 3 && lastName.length() > 3) {
            navigationToSecondFragment();
        } else {
            Toast.makeText(getActivity(),
                    "Fill in all fields, input data must be more than three characters",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void navigationToSecondFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("lastname", lastName);

        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);

        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, secondFragment)
                .addToBackStack(null)
                .commit();
    }
}