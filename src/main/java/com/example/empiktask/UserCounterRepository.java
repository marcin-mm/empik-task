package com.example.empiktask;

import org.springframework.data.repository.CrudRepository;

interface UserCounterRepository extends CrudRepository<UserCounter, String> {
}
