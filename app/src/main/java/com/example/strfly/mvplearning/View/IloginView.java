package com.example.strfly.mvplearning.View;

import com.example.strfly.mvplearning.model.User;

/**
 * Created by chenjinbo645 on 2017/3/11.
 */

public interface IloginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
