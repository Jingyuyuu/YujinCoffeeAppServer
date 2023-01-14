package tw.myapp.YujinCoffeeAppServer.appdbController;

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


}
