package com.example.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView titleTextView;
    private TextView bodyTextView;
    private Button getDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        titleTextView = findViewById(R.id.title_textView);
        bodyTextView = findViewById(R.id.body_textView);
        getDataButton = findViewById(R.id.getData_button);

        getDataButton.setOnClickListener(view -> getData());


    }

    private void getData() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait");
        progressDialog.show();


        Retrofit_instance.getRetrofitInstance().create(UserApi_interface.class).get_User_data().enqueue(new Callback<User_data>() {
            @Override
            public void onResponse(Call<User_data> call, Response<User_data> response) {
                Toast.makeText(MainActivity.this, "Sucess", Toast.LENGTH_SHORT).show();
                User_data responseData = response.body();
                if (responseData != null) {
                    titleTextView.setText(responseData.getName());
                    //bodyTextView.setText(responseData.getBody());
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<User_data> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                titleTextView.setText(t.getLocalizedMessage());
                Log.i("Faillllllllilde", t.getLocalizedMessage());
                progressDialog.dismiss();
            }
        });
    }

}