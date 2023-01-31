package tw.myapp.YujinCoffeeAppServer.appdbController;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.myapp.YujinCoffeeAppServer.appdService.memberService;
import tw.myapp.YujinCoffeeAppServer.appdbRepository.memberRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/member")
public class memberController {

    @Autowired
    memberService memberser;
    @Autowired
    memberRepository memberRepo;

    @GetMapping("/allMember")
    public List<Map<String,Object>> getAllMemberData(){
        return  memberRepo.getMemberData();
    }

    @GetMapping("/{email}")
    public Map<String,Object> getMemberDataByAcc(@PathVariable String email){
        return memberRepo.getMemberByAcc(email);
    }

    @PostMapping("/login")
    public String login(@RequestBody String body){
        JSONObject object=new JSONObject(body);
        System.out.println("後端接收消息"+body);
        System.out.println("後端接收消息JSONObject"+object.toString(4));
        System.out.println("後端接收消息object.getJSONObject="+object.getJSONObject("logData").toString(4));
        JSONObject data=object.getJSONObject("logData");
        System.out.println("帳號 :"+data.getString("acc")+"密碼 :"+data.getString("pwd"));
        System.out.println("server回應login需求,登入結果="+memberser.getLoginResult(data.getString("acc"), data.getString("pwd")).toString());

        return memberser.getLoginResult(data.getString("acc"), data.getString("pwd")).toString();
    }
    @PostMapping("/register")
    public String register(@RequestBody String body){
        JSONObject object=new JSONObject(body);
        System.out.println("後端接收消息"+body);

        JSONObject data=object.getJSONObject("regData");
        System.out.println(
                 "name :"+data.getString("name")
                +"email :"+data.getString("email")
                +"pwd :"+data.getString("pwd")
                +"phone :"+data.getString("phone"));

        return  memberser.memberCheckService(
                data.getString("name")
                ,data.getString("email")
                ,data.getString("pwd")
                ,data.getString("phone")).toString();

    }

    @PostMapping("/reNewMemberData")
    public String reNewMemberData(@RequestBody String body){
        JSONObject object=new JSONObject(body);
        System.out.println("後端接收更新的會員資料"+body);

        JSONObject data=object.getJSONObject("NewMemberData");
        System.out.println(
                        "name :"+data.getString("name")
                        +"email :"+data.getString("email")
                        +"pwd :"+data.getString("pwd")
                        +"phone :"+data.getString("phone"));

        return  memberser.reNewMemberResult(
                data.getString("name"),
                data.getString("pwd"),
                data.getString("phone"),
                data.getString("email")).toString();

    }


    @PostMapping("/getMemberData")
    public MemberMO getMemberData(@RequestBody String body){
        JSONObject object=new JSONObject(body);
        System.out.println("後端接收EMAIL="+body);

        JSONObject data=object.getJSONObject("memberEmail");
        System.out.println("email :"+data.getString("email"));
        Map<String, Object> mo =memberRepo.getMemberDataFromDB(data.getString("email"));
        mo.put("status",999);
        System.out.println("Controller: " + mo.toString());
        MemberMO memmo = new MemberMO(999, "正常", mo);

        return  memmo;
    }
    @GetMapping("/point/{email}")
    public int getPoint(@PathVariable String email){

        System.out.println("點數兌換Email: " + email);
        int point =memberRepo.getPoint(email);
        return point;

    }
    @GetMapping("/minuspoint/{point}/{email}")
    public void getMinusPoint(@PathVariable int point,@PathVariable String email){
        memberRepo.minusPoint(point,email);

    }



}
