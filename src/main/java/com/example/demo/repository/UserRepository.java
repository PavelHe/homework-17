package com.example.demo.repository;

import java.util.*;

import com.example.demo.model.*;
import org.springframework.data.repository.*;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

}
