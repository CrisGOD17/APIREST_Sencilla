package com.example.APIREST.repositories;


import com.example.APIREST.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IuserRepository extends JpaRepository<UserModel, Long> {



}
