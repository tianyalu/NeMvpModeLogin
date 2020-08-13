package com.sty.ne.mvpmode.login.login;

import com.sty.ne.mvpmode.login.base.BaseModel;
import com.sty.ne.mvpmode.login.bean.UserInfo;

/**
 * @Author: tian
 * @UpdateDate: 2020-08-13 20:37
 */
public class LoginModel extends BaseModel<LoginPresenter, LoginContract.Model> {
    public LoginModel(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    @Override
    public LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void executeLogin(String name, String pwd) throws Exception {
                if("sty".equalsIgnoreCase(name) && "123".equals(pwd)) {
                    p.getContract().responseResult(new UserInfo("天涯路", "sty"));
                }else {
                    p.getContract().responseResult(null);
                }
            }
        };
    }
}
