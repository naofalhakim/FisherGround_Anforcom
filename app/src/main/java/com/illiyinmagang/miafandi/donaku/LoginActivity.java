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

import com.illiyinmagang.miafandi.donaku.AppConfig.SessionManager;
import com.illiyinmagang.miafandi.donaku.RetrofitConfig.APIInterface;
import com.illiyinmagang.miafandi.donaku.RetrofitConfig.ApiClient;
import com.illiyinmagang.miafandi.donaku.model.TempModel.TempUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button btnMasuk;
    TextInputEditText xusername, xpassword;
    TextInputLayout tilUser, tilPass;
    public String user, pass;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(LoginActivity.this);

        btnMasuk = (Button) findViewById(R.id.btnLogin);
        tilUser = (TextInputLayout) findViewById(R.id.textLayoutUser);
        tilPass = (TextInputLayout) findViewById(R.id.textLayoutPass);
        xusername = (TextInputEditText) findViewById(R.id.edUsername);
        xpassword = (TextInputEditText) findViewById(R.id.edPassword);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = xusername.getText().toString();
                pass = xpassword.getText().toString();

                if (user.equals("") && pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Tolong isi username dan password", Toast.LENGTH_LONG).show();
                }else{
                    getData(user, pass);
                }
            }
        });
    }

    private void getData (final String email, final String pass){
        APIInterface apiInterface = ApiClient.getApiClient().create(APIInterface.class);
        Call<TempUser> call = apiInterface.getUsers(email, pass);
        call.enqueue(new Callback<TempUser>() {
            @Override
            public void onResponse(Call<TempUser> call, Response<TempUser> response) {
                String user = response.body().getUsers().get(0).getUsername();
                String pass = response.body().getUsers().get(0).getPasseword();
                String telp = response.body().getUsers().get(0).getNotelp();
                String status = response.body().getUsers().get(0).getStatus();

                Log.e("myEmail",user);
                sessionManager.setLogin(user,pass,telp,status, "online");

                Toast.makeText(LoginActivity.this, user + " pass " + pass, Toast.LENGTH_LONG).show();
                linkHalaman(response.body().getUsers().get(0).getStatus());
            }

            @Override
            public void onFailure(Call<TempUser> call, Throwable t) {
                Log.e("login", t.getMessage());
                Toast.makeText(LoginActivity.this,"No Internet Connection",Toast.LENGTH_LONG).show();

                //offline mode
                if(email.equals("nelayan@gmail.com")){
                    sessionManager.setLogin(user,pass,"082214119368","nelayan","offline");
                    linkHalaman("nelayan");
                }else{
                    sessionManager.setLogin("user@gmail.com","user","082214119368","user","offline");
                    linkHalaman("user");
                }
            }
        });
    }

    private void linkHalaman(String status){
         if (!status.equals("nelayan")) {
            Intent intent = new Intent(LoginActivity.this, HomeUserActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
