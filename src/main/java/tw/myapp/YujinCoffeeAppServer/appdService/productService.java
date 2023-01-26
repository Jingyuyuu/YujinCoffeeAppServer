package tw.myapp.YujinCoffeeAppServer.appdService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.myapp.YujinCoffeeAppServer.appdbRepository.memberRepository;
import tw.myapp.YujinCoffeeAppServer.appdbRepository.productRepository;

@Service
public class productService {

    @Autowired
    productRepository productRepo;


    public JSONObject orderMstInsert(String email,String date,int total){
        //呼叫productRepository方法寫入訂單主檔資料
        productRepo.insertInToOderMster(email,date,total);
        JSONObject responseObject=new JSONObject();
        responseObject.put("type",10);
        responseObject.put("status",1000);
        responseObject.put("mesg","訂單成功送出");
        return  responseObject;
    }


    public int getOid(String email,String date){
        //呼叫productRepository方法取得訂單編號
        int orderid=productRepo.getOderid(email,date);

        return  orderid;
    }

    public int orderDetailInsert(int oid,String name,String ice,String sugar,int amount,int dollar){
        //呼叫productRepository方法寫入訂單明細資料
        productRepo.insertInToOderDetail(oid,name,ice,sugar,amount,dollar);

        return  0;
    }


}
