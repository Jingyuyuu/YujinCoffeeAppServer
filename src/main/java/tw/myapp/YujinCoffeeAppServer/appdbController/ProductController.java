package tw.myapp.YujinCoffeeAppServer.appdbController;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.myapp.YujinCoffeeAppServer.appdService.productService;
import tw.myapp.YujinCoffeeAppServer.appdbRepository.productRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    productRepository productRepo;
    @Autowired
    productService productSer;
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

        String email=data.getString("memberEmail");
        String date=data.getString("date");

        data.getJSONArray("OrderDetail");
        System.out.println("---memberEmail="+data.getString("memberEmail"));
        System.out.println("---date="+data.getString("date"));

        System.out.println("---OrderDetail="+data.getJSONArray("OrderDetail"));
        JSONArray orderArray=data.getJSONArray("OrderDetail");
        //Map<String,Object> mo=null ;
        orderDetail orderList=null;
        int total=0;
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
            total+=orderList.getAmount()*orderList.getPrice();

            System.out.println(orderList.getName());
            System.out.println("----------------------------------------------------");

        }
        System.out.println("total price="+total);
        //抓出訂單主檔資料傳給Service 並接收回傳的JsonObject給Android
        JSONObject orderResult=productSer.orderMstInsert(email,date,total);
        //取得訂單編號
        int orderid=productSer.getOid(email,date);
        System.out.println("orderid="+orderid);
        //取得會員編號
        int memberid=productSer.getMid(email);

        for(int i=0;i<orderArray.length();i++){
            orderList=new orderDetail(
                    orderArray.getJSONObject(i).getString("name"),
                    orderArray.getJSONObject(i).getString("ice"),
                    orderArray.getJSONObject(i).getString("sugar"),
                    orderArray.getJSONObject(i).getInt("dollar"),
                    orderArray.getJSONObject(i).getInt("amount")
            );
            //呼叫productService的方法把訂單明細寫入資料庫
            productSer.orderDetailInsert(
                    orderid,
                    memberid,
                    orderList.getName(),
                    orderList.getIce(),
                    orderList.getSugar(),
                    orderList.getAmount(),
                    orderList.getPrice()
            );
        }
        return orderResult.toString();
    }


    //取得會員歷史訂單
    @PostMapping("/getHistoryOrder")
    public productMO getHistoryOrder(@RequestBody String body){
        JSONObject object=new JSONObject(body);
        System.out.println("後端接收會員email以取得歷史訂單"+body);

        JSONObject data=object.getJSONObject("Email");
        System.out.println("會員email="+data.getString("email"));

        int mid=productSer.getMid(data.getString("email"));
        List<Map<String,Object>> historyOrder=productSer.getHistoryOrderByMid(mid);

        //印出historyOrder的所有內容
        for(int i=0;i<historyOrder.size();i++){
            Map<String,Object> map=historyOrder.get(i);
            Iterator<String> it=map.keySet().iterator();
            while(it.hasNext()){
                String key=it.next();
                Object value=map.get(key);
                System.out.println(key+":"+value);

            }
        }
        productMO pMo=new productMO(2000,"回傳歷史訂單成功",historyOrder);

        return  pMo;

    }

    @GetMapping("/data")
    public List<Map<String,Object>> getAllData(){
        return productRepo.getAllPrdouctData();
    }


}
