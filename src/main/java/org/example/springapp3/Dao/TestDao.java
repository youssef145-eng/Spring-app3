package org.example.springapp3.Dao;

import org.example.springapp3.Entity.TestEntity;
import org.example.springapp3.Repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TestDao {

    @Autowired
    private TestRepo testRepo;


        public String Getname(){
        return "test";

    }
         //  Iterator<TestEntity>
    public List<TestEntity> GetAll(){
            return testRepo.findAll();
    }
    public Optional<TestEntity> GetById(int user_id){
            return testRepo.findById(user_id );
    }
    public String DeleteById(int user_id){
            Optional<TestEntity> testEntity = testRepo.findById(user_id);
            if(testEntity.isPresent()){
                testRepo.deleteById(user_id);
                return "user deleted";
            }
            return "user not found";

    }

    public TestEntity SaveUser(TestEntity user){
            return testRepo.save(user);
    }
    public TestEntity UpdateUser(TestEntity user){
        Optional<TestEntity> testEntity = GetById(user.getUser_id());
        if(testEntity.isPresent()){
         return testRepo.save(user);
        }
        return null;
    }
public List<TestEntity> findALLUsers(){
            return this.testRepo.findALLUsers();
}
public TestEntity FindUserById(int user_id){
        return testRepo.findUserById(user_id);

}
public void ResetPassword(int user_id, String password){
            this.testRepo.resetpassword(user_id, password);

}
    public void Deleteuserbyid(Integer user_id){
        this.testRepo.Deleteuserbyid(user_id);

    }
}
