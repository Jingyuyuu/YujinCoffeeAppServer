package tw.myapp.YujinCoffeeAppServer.appdbController;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.myapp.YujinCoffeeAppServer.appdbRepository.productRepository;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/orderSubmit")
    public String orderSubmit(@RequestBody String body){
        JSONObject object=new JSONObject(body);
        System.out.println("後端接收消息"+body);

        JSONObject data=object.getJSONObject("OrderMst");
        System.out.println("---OrderMst="+object.getJSONObject("OrderMst"));

        data.getString("memberEmail");
        data.getString("date");
        data.getJSONArray("OrderDetail");
        System.out.println("---memberEmail="+data.getString("memberEmail"));
        System.out.println("---date="+data.getString("date"));
        System.out.println("---OrderDetail="+data.getJSONArray("OrderDetail"));
        JSONArray orderArray=data.getJSONArray("OrderDetail");
        //Map<String,Object> mo=null ;
        orderDetail orderList=null;
        for(int i=0;i<orderArray.length();i++){
            System.out.println(orderArray.getJSONObject(i).getString("name")+"");
            System.out.println(orderArray.getJSONObject(i).getString("ice")+"");
            System.out.println(orderArray.getJSONObject(i).getString("sugar")+"");
            System.out.println(orderArray.getJSONObject(i).getInt("dollar")+"");
            System.out.println(orderArray.getJSONObject(i).getInt("amount")+"");
            System.out.println("----------------------------------------------------");

        orderList=new orderDetail(
                orderArray.getJSONObject(i).getString("name"),
                orderArray.getJSONObject(i).getString("ice"),
                orderArray.getJSONObject(i).getString("sugar"),
                orderArray.getJSONObject(i).getInt("dollar"),
                orderArray.getJSONObject(i).getInt("amount")
        );
            System.out.println(orderList.getName());
        }
        System.out.println(orderList.getName());


        return "test";
    }

}
