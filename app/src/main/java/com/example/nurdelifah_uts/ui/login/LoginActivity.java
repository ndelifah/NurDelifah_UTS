package com.example.nurdelifah_uts.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nurdelifah_uts.MainActivity;
import com.example.nurdelifah_uts.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText nip_nim,password;
    Button login;
    private ArrayList<UserList> usersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nip_nim = findViewById(R.id.etNIP_NIM);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.loginButton);

        usersList.add(new UserList("12250123957", "12345"));
        usersList.add(new UserList("22222", "22222"));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nim_nimInput = nip_nim.getText().toString().trim();
                    String passwordInput = password.getText().toString().trim();

                    boolean isValidLogin = false;
                    for (UserList user : usersList) {
                        if (user.getNik_nim().equals(nim_nimInput) && user.getPassword().equals(passwordInput)) {
                            isValidLogin = true;
                            break;
                        }
                    }

                    if (isValidLogin) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Gagal Login!", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    login.performClick();
                    return true;
                }
                return false;
            }
        });
    }
}