package com.example.APIREST.services;

import com.example.APIREST.models.UserModel;
import com.example.APIREST.repositories.IuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IuserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return  (ArrayList<UserModel>) userRepository.findAll();
    }


    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){

        return userRepository.findById(id);
    }

    public UserModel updateByID(UserModel request, Long id ){
        UserModel userModel = userRepository.findById(id).get();
        userModel.setFirstName(request.getFirstName());
        userModel.setLastName(request.getLastName());
        userModel.setEmail(request.getEmail());
        userRepository.save(userModel);
        return userModel;
    }

    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
