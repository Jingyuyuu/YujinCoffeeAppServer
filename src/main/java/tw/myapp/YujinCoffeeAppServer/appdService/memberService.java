package tw.myapp.YujinCoffeeAppServer.appdService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.myapp.YujinCoffeeAppServer.appdbRepository.memberRepository;

@Service
public class memberService {
    @Autowired
    memberRepository memberRepo;
    public JSONObject getLoginResult(String Username,String Passwd){
        long c = memberRepo.memberCheck(Username,Passwd);
        //準備一個回傳用的JSONObject
        JSONObject responseObject=new JSONObject();
        responseObject.put("type",2);
        if(c==0){
            responseObject.put("status",444);
            responseObject.put("mesg","驗證失敗");
        }else{
            responseObject.put("status",666);
            responseObject.put("mesg","驗證成功");
        }
        return  responseObject;
    }



}
