package com.webtech.whattowear.repository;

import com.webtech.whattowear.model.Clothes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepository extends CrudRepository <Clothes,Integer> {
}
