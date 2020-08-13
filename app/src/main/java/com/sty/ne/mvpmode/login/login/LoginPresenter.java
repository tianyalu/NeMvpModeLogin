package com.sty.ne.mvpmode.login.login;

import android.os.SystemClock;

import com.sty.ne.mvpmode.login.LoginActivity;
import com.sty.ne.mvpmode.login.base.BasePresenter;
import com.sty.ne.mvpmode.login.bean.UserInfo;
import com.sty.ne.mvpmode.login.http_lib.HttpEngine;

/**
 * @Author: tian
 * @UpdateDate: 2020-08-13 20:37
 */
//接收到P层交给他的需求
public class LoginPresenter extends BasePresenter<LoginActivity, LoginModel, LoginContract.Presenter> {

    @Override
    public LoginContract.Presenter getContract() {
        //既要履行View给它的需求，又要分配工作给Model去完成这个需求
        return new LoginContract.Presenter<UserInfo>() {

            @Override
            public void requestLogin(String name, String pwd) {
                //三种风格(P层很极端，要么不做事只做转发，要么就是拼命一个人干活)
                try {
                    //第一种，自己只做转发
                    m.getContract().executeLogin(name, pwd);

                    //第二种，让功能模块去工作（Library: 下载、请求、图片加载）
//                    HttpEngine engine = new HttpEngine<>(LoginPresenter.this);
//                    engine.post(name, pwd);

                    //第三种、P层自己处理（谷歌例子）
//                    if("sty".equalsIgnoreCase(name) && "123".equals(pwd)) {
//                        responseResult(new UserInfo("天涯路", "sty"));
//                    }else {
//                        responseResult(null);
//                    }

                    //内存泄漏测试
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            SystemClock.sleep(50000);
//                        }
//                    }).start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void responseResult(UserInfo userInfo) {
                //不管谁完成需求，有结果就告知View层
                getView().getContract().handlerResult(userInfo);
            }
        };
    }

    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }
}
