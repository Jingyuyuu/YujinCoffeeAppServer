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

}
