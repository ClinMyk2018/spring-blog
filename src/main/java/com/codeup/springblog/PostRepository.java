package com.codeup.springblog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
//CrudRepository, look into it for "OUT OF THE BOX METHODS!"
public interface PostRepository extends CrudRepository<Post, Integer> {


}
