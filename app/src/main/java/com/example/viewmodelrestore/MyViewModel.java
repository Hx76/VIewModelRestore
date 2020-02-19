package com.example.viewmodelrestore;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private SavedStateHandle handle;
    public MyViewModel(SavedStateHandle handle){
        this.handle = handle;
    }
    public MutableLiveData<Integer> getNumber() {
        if(!handle.contains(MainActivity.KEY_NUMBER)){
            handle.set(MainActivity.KEY_NUMBER,0);
        }
//        if (number == null){
//            number = new MutableLiveData<>();
//            number.setValue(0);
//        }
        return handle.getLiveData(MainActivity.KEY_NUMBER);
    }

    public void add(){
        getNumber().setValue(getNumber().getValue()+1);
    }


    private MutableLiveData<Integer> number;

}
