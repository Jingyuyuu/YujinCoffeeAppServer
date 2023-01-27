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

    public JSONObject memberCheckService(String name,String email,String pwd,String phone){
        long emailIsExits=memberRepo.emailCheck(email);
        //檢查email是否存在
        JSONObject responseObject=new JSONObject();
        responseObject.put("type",1);
        if (emailIsExits == 0){

            responseObject.put("status",000);
            responseObject.put("mesg","帳號註冊成功");
            System.out.println("註冊成功");
            memberRepo.registerMember(name,email,pwd,phone);

        }else{
            responseObject.put("status",111);
            responseObject.put("mesg","email已存在，請重新註冊");
            System.out.println("Email已經存在");
        }
        return responseObject;
    }

    public JSONObject reNewMemberResult(String name,String pwd,String phone,String email){
        memberRepo.reNewMember(name,pwd,phone,email);

        JSONObject responseObject=new JSONObject();
        responseObject.put("type",3);
        responseObject.put("status",123);
        responseObject.put("mesg","會員資料更新成功");

        return  responseObject;
    }

    /*
    public JSONObject getMemberDataSer(String email){
       memberRepo.getMemberDataFromDB(email);

        JSONObject responseObject=new JSONObject();
        responseObject.put("type",4);
        responseObject.put("status",456);
        responseObject.put("mesg","會員資料取得成功");

        return  responseObject;
    }

     */


}
