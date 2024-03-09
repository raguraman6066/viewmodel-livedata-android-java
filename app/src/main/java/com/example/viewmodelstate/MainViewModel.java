package com.example.viewmodelstate;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    //creating live data
    private MutableLiveData<Integer> countLiveData = new MutableLiveData<>();

    //
    int count = 0;
   /*  //get initial value
    public int getInitial(){
        return count;
    }*/

    public MutableLiveData<Integer> getInitial() {
        countLiveData.setValue(count);
        return countLiveData;
    }

    //while click
//    public int getCount() {
//        return ++count;
//    }

    public void getCount() {
       countLiveData.setValue( ++count);
    }
}
