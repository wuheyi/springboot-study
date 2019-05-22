package com.zyhy.disposal.repository;

import com.zyhy.disposal.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by wuheyi on 2019/5/21.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByNameAndEmail(String name, String email);

}