package com.navigationcicerone.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.navigationcicerone.di.qualifier.Global;
import com.navigationcicerone.di.qualifier.Local;
import com.navigationcicerone.domain.GlobalNavigator;
import com.navigationcicerone.domain.LocalNavigator;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public abstract class BaseActivity extends AppCompatActivity{

    @Inject
    @Local
    NavigatorHolder localNavigatorHolder;
    @Inject
    @Global
    NavigatorHolder globalNavigatorHolder;
    @Inject
    @Local
    public Router localRouter;
    @Inject
    @Global
    public Router globalRouter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("code", "create");
        injectDependencies();
    }

    protected abstract int getContainerId();

    @Override
    protected void onResume() {
        super.onResume();
        localNavigatorHolder.setNavigator(new LocalNavigator(getFragmentManager(), getContainerId()));
        globalNavigatorHolder.setNavigator(new GlobalNavigator(this));
    }

    protected abstract void injectDependencies();

}
/*@Override
    protected void onPause() {
        super.onPause();
        localNavigatorHolder.removeNavigator();
        globalNavigatorHolder.removeNavigator();
    }*/