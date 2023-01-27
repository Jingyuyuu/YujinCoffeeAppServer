package tw.myapp.YujinCoffeeAppServer.appdService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.myapp.YujinCoffeeAppServer.appdbRepository.memberRepository;
import tw.myapp.YujinCoffeeAppServer.appdbRepository.productRepository;

import java.util.List;
import java.util.Map;

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

    public int getMid(String email){
        //呼叫productRepository方法取得訂單編號
        int membererid=productRepo.getMemberderid(email);

        return  membererid;
    }

    public int orderDetailInsert(int oid,int mid,String name,String ice,String sugar,int amount,int dollar){
        //呼叫productRepository方法寫入訂單明細資料
        productRepo.insertInToOderDetail(oid,mid,name,ice,sugar,amount,dollar);

        return  0;
    }

    public List<Map<String,Object>> getHistoryOrderByMid(int mid){
        //呼叫productRepository方法取得歷史訂單
        List<Map<String,Object>> historyOrder=productRepo.getHistoryOrderFromDB(mid);

        return  historyOrder;
    }

}
