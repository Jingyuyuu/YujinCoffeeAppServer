package tw.myapp.YujinCoffeeAppServer.appdbRepository;

import tw.myapp.YujinCoffeeAppServer.Model.Member;

import java.util.List;

public interface ImemberDao {

    //呼叫 getMemberByAccount()應該回傳該帳號的會員資料
    public Member getMemberByAccount(String account);

    //呼叫 getMemberAll()應該回傳所有會員資料
    //public List<Member> getMemberAll();

}
