package com.codeup.springblog.Repos;

import com.codeup.springblog.Model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends CrudRepository<Post, Long> {


}
