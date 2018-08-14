package com.navigationcicerone.di;

import com.androidnavigation.auth.AuthActivity;
import com.androidnavigation.auth.fragment.IntroFragment;
import com.androidnavigation.auth.fragment.SignInFragment;
import com.androidnavigation.auth.fragment.SignUpFragment;
import com.androidnavigation.main.MainActivity;
import com.androidnavigation.main.fragment.NewsFragment;
import com.navigationcicerone.di.module.NavigatorModule;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NavigatorModule.class})
public interface AppComponent {
    void inject(AuthActivity authActivity);

    void inject(IntroFragment introFragment);

    void inject(@NotNull SignInFragment signInFragment);

    void inject(@NotNull SignUpFragment signUpFragment);

    void inject(@NotNull NewsFragment newsFragment);

    void inject(@NotNull MainActivity mainActivity);
}
