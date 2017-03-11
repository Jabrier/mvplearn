package com.example.strfly.mvplearning.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.strfly.mvplearning.R;
import com.example.strfly.mvplearning.model.User;
import com.example.strfly.mvplearning.persernter.UserLoginPresenter;

public class LoginViewActivity extends AppCompatActivity implements IloginView{

    private EditText username;
    private EditText password;
    private ProgressBar progressBar;
    private Button login;
    private Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        clear = (Button) findViewById(R.id.clear);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        final UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLoginPresenter.login();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLoginPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void clearUserName() {
        username.setText("");

    }

    @Override
    public void clearPassword() {
        password.setText("");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.userName + "登入成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,"登入失败", Toast.LENGTH_SHORT).show();
    }
}
