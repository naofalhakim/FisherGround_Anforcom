package com.illiyinmagang.miafandi.donaku;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btnMasuk;
    TextInputEditText xusername, xpassword;
    TextInputLayout tilUser, tilPass;
    public String user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnMasuk = (Button) findViewById(R.id.btnLogin);
        tilUser = (TextInputLayout) findViewById(R.id.textLayoutUser);
        tilPass = (TextInputLayout) findViewById(R.id.textLayoutPass);
        xusername = (TextInputEditText) findViewById(R.id.edUsername);
        xpassword = (TextInputEditText) findViewById(R.id.edPassword);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = xusername.getText().toString();
                pass= xpassword.getText().toString();

//                Toast.makeText(LoginActivity.this,user+" pass "+pass,Toast.LENGTH_LONG).show();
//                if(user.equals("") && pass.equals("")){
//                    Toast.makeText(LoginActivity.this,"Tolong isi username dan password",Toast.LENGTH_LONG).show();
//                }else if (user.equals("a") && pass.equals("a")){
//                    Intent intent= new Intent(LoginActivity.this, HomeUserActivity.class);
//                    startActivity(intent);
//                }else if(user.equals("nelayan") && pass.equals("nelayan")){
                    Intent intent= new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
//                }else{
//                    Toast.makeText(LoginActivity.this,"Tolong isi username dan password",Toast.LENGTH_LONG).show();
//                }
            }
        });
    }
}
