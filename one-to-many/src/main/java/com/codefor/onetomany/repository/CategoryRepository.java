package com.codefor.onetomany.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codefor.onetomany.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
