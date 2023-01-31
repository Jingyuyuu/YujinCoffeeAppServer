package tw.myapp.YujinCoffeeAppServer.appdbRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tw.myapp.YujinCoffeeAppServer.Model.Member;

import java.util.List;
import java.util.Map;

@Repository
public class memberRepository implements ImemberDao{
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public Member getMemberByAccount(String account) {
        return null;
    }

    public List<Map<String,Object>> getMemberData() {
        return jdbcTemplate.queryForList("select * from member;");
    }

    public Map<String,Object> getMemberByAcc(String email) {
        return jdbcTemplate.queryForMap("select * from member where email=?;",email);
    }

    public long memberCheck(String acc,String pwd){
        String query=
                "select count(*) from member where email=? and passwd=?";
        long count = jdbcTemplate.queryForObject(query,new Object[]{acc,pwd}, Long.class);
        return  count;
    }

    public long emailCheck(String email){
        String query=
                "select count(*) from member where email=?";
        long count = jdbcTemplate.queryForObject(query,new Object[]{email}, Long.class);
        return  count;
    }


    public String registerMember(String name,String email,String pwd,String phone){
        String sql=
                "insert into member (name,email,passwd,phone) values (?,?,?,?) ;";

        jdbcTemplate.update(sql,name,email,pwd,phone);
        return "register is sussed";
    }

    public String reNewMember(String name,String pwd,String phone,String email){
        String sql=
        "UPDATE member SET name=?,passwd=?,phone=? WHERE email=? ;";
        jdbcTemplate.update(sql,name,pwd,phone,email);
        return "register is sussed";
    }

    public Map<String,Object> getMemberDataFromDB(String email){
        String sql=
                "SELECT name,email,phone,points FROM member WHERE email=?;";

        return jdbcTemplate.queryForMap(sql,email);
    }

    //寫入訂單主檔資料
    //INSERT into [dbo].[ordermster] ([o_member_id],[o_date],[o_total]) values(22,'2022-12-17',325);







}
