package com.codeup.springblog.Repos;



import com.codeup.springblog.Model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <Users, Long> {
    Users findByname(String name);


}
