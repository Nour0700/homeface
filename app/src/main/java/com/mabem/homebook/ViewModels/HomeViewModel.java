package com.mabem.homebook.ViewModels;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mabem.homebook.Database.Database;
import com.mabem.homebook.Model.Home;
import com.mabem.homebook.Model.Member;
import com.mabem.homebook.Model.Receipt;
import com.mabem.homebook.Model.User;

public class HomeViewModel extends AndroidViewModel {

    private final Database database;
    private final MutableLiveData<Member> currentMember;
    private final MutableLiveData<Home> currentHome;
    private final MutableLiveData<Receipt> currentReceipt;
    private final MutableLiveData<String> resultMessage;

    private boolean shouldShowResultMessage = false;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        database = Database.getInstance(application);
        currentMember = database.getCurrentMember();
        currentReceipt = database.getCurrentReceipt();
        resultMessage = database.getResultMessage();
        currentHome = database.getCurrentHome();
    }


    public LiveData<Member> getCurrentMember() {
        return currentMember;
    }
    public LiveData<Home> getCurrentHome() {
        return currentHome;
    }
    public LiveData<Receipt> getCurrentReceipt() {
        return currentReceipt;
    }
    public LiveData<String> getResultMessage() {
        return resultMessage;
    }

    public void updateUser(Member m, Uri localUri){
        database.updateMember(m, localUri);
    }

    public void updateCurrentMember(){
        database.updateCurrentMember();
    }


    public void addNewHome(String homeName, boolean isPrivate){
        database.createHome(homeName, isPrivate);
    }
    public void updateCurrentHome(String id){
        database.updateCurrentHome(id);
    }
    public void updateHomeWithMembers(){
        database.updateHomeWithMembers();
    }
    public void leaveHome(){
        database.leaveHome();
    }


    public void updateCurrentReceipt(String id){
        database.updateCurrentReceipt(id);
    }



    public boolean getShouldShowResultMessage() {
        return shouldShowResultMessage;
    }
    public void setShouldShowResultMessage(boolean shouldShowResultMessage) {
        this.shouldShowResultMessage = shouldShowResultMessage;
    }



}
