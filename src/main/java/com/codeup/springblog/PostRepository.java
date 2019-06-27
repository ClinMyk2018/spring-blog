package com.codeup.springblog;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//CrudRepository, look into it for "OUT OF THE BOX METHODS!"
public interface PostRepository extends CrudRepository<Post, Integer> {


//    String delete(String title);
}
