package com.example.crmn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    EditText edUsername , edPassword ;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         edUsername = findViewById(R.id.editTextTextLoginUsername);
        edPassword = findViewById(R.id.editTextTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);



       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edUsername.getText().toString();
                String password=edPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"CRMN",null,1);


                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(),"please fill All details" ,Toast.LENGTH_LONG).show();


                } else {
                    if (username.equals("adminCRMN") && password.equals("CRMN2023")) {
                        startActivity(new Intent(loginActivity.this, voirActivity.class));

                    }else
                    if (db.login(username, password) == 1) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                        //create new object with share preferences
                        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit(); //create one editor

                        editor.putString("username",username);//in this editor we put this username
                        //to save our data with key and value,
                        editor.apply();;
                        startActivity(new Intent(loginActivity.this,HomeActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "invalid username and password", Toast.LENGTH_LONG).show();

                    }

                }   }
        });


        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this,HomeActivity.class));

            }
        });*/



        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this,RegisterActivity.class));

            }
        });
    }
}