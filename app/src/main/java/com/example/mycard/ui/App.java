package com.example.mycard.ui;

import android.app.Application;

import com.example.mycard.data.BusinessCardRepository;

import org.jetbrains.annotations.NotNull;

public class App extends Application {
    @NotNull
    public final BusinessCardRepository repository;

    public App(@NotNull BusinessCardRepository repository) {
        this.repository = repository;
    }
}
