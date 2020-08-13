package com.sty.ne.mvpmode.login.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * @Author: tian
 * @UpdateDate: 2020-08-13 19:50
 */

/**
 * View层基类
 */
public abstract class BaseView<P extends BasePresenter, CONTRACT> extends Activity {
    protected P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //弱引用
        p = getPresenter();
        //绑定
        p.bindView(this);
    }

    //让P层做什么需求
    public abstract CONTRACT getContract();

    //从子类中获取具体的契约
    public abstract P getPresenter();

    //如果Presenter层出现了异常，需要告知View层
    public void error(Exception e){}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除绑定
        p.unBindView();
    }
}
