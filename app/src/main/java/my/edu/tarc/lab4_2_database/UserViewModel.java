package my.edu.tarc.lab4_2_database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

//TODO 7: Create an Android View Model class to link data to UI

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<List<User>> allUsers; // A cache copy of record

    public UserViewModel(@NonNull Application application) {
        super(application);
        //CREATE AN INSTANCE OF REPOSITORY
        userRepository = new UserRepository(application);
        //RETRIEVE ALL THE USER RECORDS
        allUsers = userRepository.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public  void insertUser(User user){
        userRepository.insertUser(user);
    }

    public  void deleteUser(User user){
        userRepository.deleteUser(user);
    }
}
