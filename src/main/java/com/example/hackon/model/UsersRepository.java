package com.example.hackon.model;


import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<RegisteredUser, Long>
{

}
