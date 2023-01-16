package tw.myapp.YujinCoffeeAppServer.appdbController;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.myapp.YujinCoffeeAppServer.appdbRepository.productRepository;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    productRepository productRepo;
    @PostMapping("/register")
    public String register(@RequestBody String body){
        JSONObject object=new JSONObject(body);
        System.out.println("後端接收消息"+body);
        JSONObject data=object.getJSONObject("regData");
        System.out.println("name :"+data.getString("name")+"email :"+data.getString("email")
                +"pwd :"+data.getString("pwd")
                +"phone :"+data.getString("phone"));

        return productRepo.getProsuct().toString();
    }

}
