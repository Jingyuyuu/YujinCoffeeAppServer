package tw.myapp.YujinCoffeeAppServer.appdbController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.myapp.YujinCoffeeAppServer.appdbRepository.StoreRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    StoreRepository storeRepository;



    @GetMapping("/allStore")
    public List<Map<String,Object>> getAllStore(){
        return storeRepository.getStore();
    }



}
