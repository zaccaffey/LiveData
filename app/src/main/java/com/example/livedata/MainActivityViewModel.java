package com.example.livedata;

import android.os.CountDownTimer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private CountDownTimer timer;
    private MutableLiveData seconds = new MutableLiveData();

    public LiveData getSeconds() {
        return seconds;
    }

    public void startTimer() {
        timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                long timeRemaining = l/1000;
                seconds.setValue(timeRemaining);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void stopTimer() {
        timer.cancel();
    }
}
