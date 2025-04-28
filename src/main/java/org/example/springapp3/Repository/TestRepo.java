package org.example.springapp3.Repository;

import org.example.springapp3.Entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// create read update delete
// when using CRUD class we should use iterable class and when using jpaRepository
// we can use list
public interface TestRepo extends JpaRepository<TestEntity, Integer> {

    @Query(value = "select t from TestEntity t")
    List<TestEntity> findALLUsers();
@Query(value = "select t from TestEntity t where t.user_id=:id ")
TestEntity findUserById(Integer id);

    // with JPQL when use insert or update or delete you should use void with method
    @Modifying
    @Transactional
   @Query(value = "update TestEntity t set t.password=:password where t.user_id=:id")
    void  resetpassword(Integer id,String password);
    @Modifying
    @Transactional
    @Query(value = "DELETE  from TestEntity t where t.user_id=:id")
    void Deleteuserbyid(Integer id);
}
