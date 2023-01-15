package tw.myapp.YujinCoffeeAppServer.appdbController;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.myapp.YujinCoffeeAppServer.appdbRepository.memberRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/member")
public class memberController {

    @Autowired
    memberRepository memberRepository;

    @GetMapping("/allMember")
    public List<Map<String,Object>> getAllMemberData(){
        return  memberRepository.getMemberData();
    }

    @GetMapping("/{email}")
    public Map<String,Object> getMemberDataByAcc(@PathVariable String email){
        return memberRepository.getMemberByAcc(email);
    }

    @PostMapping("/login")
    public String login(@RequestBody String body){
        JSONObject object=new JSONObject(body);
        System.out.println("後端接收消息"+body);
        System.out.println("後端接收消息JSONObject"+object.toString(4));
        System.out.println("後端接收消息object.getJSONObject="+object.getJSONObject("logData").toString(4));
        JSONObject data=object.getJSONObject("logData");
        System.out.println("帳號 :"+data.getString("acc")+"密碼 :"+data.getString("pwd"));
        long c = memberRepository.memberCheck(data.getString("acc"),data.getString("pwd"));
        System.out.println("server回應login需求,登入結果="+c);
        return "server回應login需求,登入結果="+c;
    }


}
