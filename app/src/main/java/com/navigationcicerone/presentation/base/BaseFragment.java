package com.navigationcicerone.presentation.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.navigationcicerone.di.qualifier.Global;
import com.navigationcicerone.di.qualifier.Local;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

public abstract class BaseFragment extends Fragment {
    @Inject
    @Local
    public Router localRouter;

    @Inject
    @Global
    public Router globalRouter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    protected abstract void injectDependencies();
}
