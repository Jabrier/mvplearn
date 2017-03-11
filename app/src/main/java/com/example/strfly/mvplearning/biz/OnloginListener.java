package com.example.strfly.mvplearning.biz;

import com.example.strfly.mvplearning.model.User;

/**
 * Created by chenjinbo645 on 2017/3/11.
 */

public interface OnloginListener {
    void success(User user);

    void fail();
}
