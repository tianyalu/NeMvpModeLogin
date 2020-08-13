package com.sty.ne.mvpmode.login.http_lib;

import com.sty.ne.mvpmode.login.bean.UserInfo;
import com.sty.ne.mvpmode.login.login.LoginModel;
import com.sty.ne.mvpmode.login.login.LoginPresenter;

/**
 * @Author: tian
 * @UpdateDate: 2020-08-13 21:04
 */

//有可能是公有的Model
public class HttpEngine<P extends LoginPresenter> {
    private P p;

    public HttpEngine(P p) {
        this.p = p;
    }

    public void post(String name, String pwd) {
        if("sty".equalsIgnoreCase(name) && "123".equals(pwd)) {
            p.getContract().responseResult(new UserInfo("天涯路", "sty"));
        }else {
            p.getContract().responseResult(null);
        }
    }
}
