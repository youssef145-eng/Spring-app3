package org.example.springapp3.Repository;

import org.example.springapp3.Entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
// create read update delete
// when using CRUD class we should use iterable class and when using jpaRepository
// we can use list
public interface TestRepo extends JpaRepository<TestEntity, Integer> {


}
