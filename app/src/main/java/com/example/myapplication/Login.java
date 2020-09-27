package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.myapplication.Signup.makeMeShake;

public class Login extends Fragment  {


    public Login() {
        // Required empty public constructor

    }

    // TODO: Rename and change types and number of parameters
    EditText username;
    EditText password;
    TextView userpass;
    Button login;
    RadioButton remember_password;

    public static Login newInstance() {
        Login fragment = new Login();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        login = (Button) rootView.findViewById(R.id.login);
        username = (EditText) rootView.findViewById(R.id.username_login);
        password = (EditText) rootView.findViewById(R.id.password_login);
        remember_password = (RadioButton) rootView.findViewById(R.id.remember_password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.length() < 3) {
                    Toast.makeText(getActivity().getApplicationContext(), "Username must be more than 3 digits", Toast.LENGTH_SHORT).show();
                    makeMeShake(username, 20, 9);
                } else if (password.length() < 3) {
                    Toast.makeText(getActivity().getApplicationContext(), "Password must be more than 3 digits", Toast.LENGTH_SHORT).show();
                    makeMeShake(password, 20, 9);
                } else if (!(remember_password.isChecked())) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please accept our terms and conditions", Toast.LENGTH_SHORT).show();
                    makeMeShake(remember_password, 20, 9);
                } else {
                    Intent i = new Intent(getActivity(), MainActivity.class);
//                String name = username.getText().toString();
                    i.putExtra("name", "Sunil");
                    startActivity(i);
                }
            }
            // Inflate the layout for this fragment

        });
        return rootView;
    }
}

