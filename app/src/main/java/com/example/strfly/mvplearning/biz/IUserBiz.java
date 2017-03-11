package com.example.strfly.mvplearning.biz;

/**
 * Created by chenjinbo645 on 2017/3/11.
 */

public interface IUserBiz {
    void login(String userName, String passWord, OnloginListener onloginListener);
}
