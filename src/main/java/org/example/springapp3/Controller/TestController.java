package org.example.springapp3.Controller;

import org.example.springapp3.Dao.TestDao;
import org.example.springapp3.Entity.TestEntity;
import org.example.springapp3.Repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TestController {
    @Autowired
private TestDao testDao;
    @Autowired
    private TestRepo testRepo;
@GetMapping("/test")
public String test(){
    return testDao.Getname();
}
@GetMapping("/tstdb")
//  Iterator<TestEntity>
public List<TestEntity> getTest(){


    //return this.testRepo.findAll();
    return this.testDao.GetAll();
}
// here we return all user Data from a database by entering his ID
@GetMapping("/find_user-by_id")
public Optional<TestEntity>  getTestById(@RequestParam int id){

    return this.testRepo.findById(id);
}
@GetMapping("/specific")
public String getSpecificData(@RequestParam int id){
    Optional<TestEntity> user = this.testDao.GetById(id);
    if(user.isPresent()){
        return user.get().getFull_name();
    }
else
    return "user not found";

}

@GetMapping("/delete")
    public String deleteuser(@RequestParam int id){
    return this.testDao.DeleteById(id);
}
@PostMapping("/save-user")
public TestEntity saveTestEntity(@RequestBody TestEntity testEntity){
    return this.testDao.SaveUser(testEntity);
}
@PostMapping("/update-user")
public TestEntity updateTestEntity(@RequestBody TestEntity testEntity){
    return this.testDao.UpdateUser(testEntity);
}


}
