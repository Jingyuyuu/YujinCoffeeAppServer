package tw.myapp.YujinCoffeeAppServer.appdbController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.config.JdbcRepositoryConfigExtension;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.myapp.YujinCoffeeAppServer.appdbRepository.dbRepository;

import java.util.List;
import java.util.Map;

@RestController
public class dbController {
    @Autowired
    dbRepository repository;

    @GetMapping("api/test")
    public List<Map<String,Object>> getTest(){
        return  repository.getTest();
    }
}
