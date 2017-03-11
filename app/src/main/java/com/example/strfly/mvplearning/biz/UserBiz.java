package com.example.strfly.mvplearning.biz;

import android.text.TextUtils;

import com.example.strfly.mvplearning.model.User;

/**
 * Created by chenjinbo645 on 2017/3/11.
 */

public class UserBiz implements IUserBiz{
    @Override
    public void login(final String userName, final String passWord, final OnloginListener onloginListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (TextUtils.equals("chenjinbo", userName) && TextUtils.equals("123", passWord)) {
                    User user = new User();
                    user.userName = userName;
                    user.userPassword = passWord;
                    onloginListener.success(user);
                }else {
                    onloginListener.fail();
                }
            }
        }).start();
    }
}
