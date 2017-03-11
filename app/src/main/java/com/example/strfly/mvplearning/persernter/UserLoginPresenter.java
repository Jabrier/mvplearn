package com.example.strfly.mvplearning.persernter;

import android.os.Handler;

import com.example.strfly.mvplearning.View.IloginView;
import com.example.strfly.mvplearning.biz.IUserBiz;
import com.example.strfly.mvplearning.biz.OnloginListener;
import com.example.strfly.mvplearning.biz.UserBiz;
import com.example.strfly.mvplearning.model.User;

/**
 * Created by chenjinbo645 on 2017/3/11.
 */

public class UserLoginPresenter {
    private IloginView iloginView;
    private IUserBiz iUserBiz;
    private final Handler handler;

    public UserLoginPresenter(IloginView iloginView) {
        this.iloginView = iloginView;
        iUserBiz = new UserBiz();
        handler = new Handler();
    }

    public void login() {
        iloginView.showLoading();
        iUserBiz.login(iloginView.getUserName(), iloginView.getPassword(), new OnloginListener() {
            @Override
            public void success(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iloginView.toMainActivity(user);
                        iloginView.hideLoading();
                    }
                });
            }

            @Override
            public void fail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iloginView.showFailedError();
                        iloginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        iloginView.clearPassword();
        iloginView.clearUserName();
    }
}
