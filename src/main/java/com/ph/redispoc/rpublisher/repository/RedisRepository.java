package com.ph.redispoc.rpublisher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ph.redispoc.rpublisher.entity.Produto;

@Repository
public interface RedisRepository extends CrudRepository<Produto, String> {

}
