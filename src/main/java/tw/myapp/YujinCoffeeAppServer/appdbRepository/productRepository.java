package tw.myapp.YujinCoffeeAppServer.appdbRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class productRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> getProsuct() {
        return jdbcTemplate.queryForList("select * from newproducts where series = 1;");
    }
    public List<Map<String,Object>> getAllPrdouctData(){
        return  jdbcTemplate.queryForList("Select * from newproduct;");
    }


    //將訂單主檔寫入雲端資料庫
    public String insertInToOderMster(String email,String date,int total){
        String sql=
                "insert into ordermster (o_member_email,o_date,o_total) values (?,?,?) ;";
        //INSERT into [dbo].[ordermster] ([o_member_email],[o_date],[o_total]) values('qqqq@gmail.com','2022-12-11',450);
        jdbcTemplate.update(sql,email,date,total);
        return "insert into ordermster sussed";
    }

    //抓取訂單編號
    public int getOderid(String email,String date){
        //SELECT [o_id]  FROM [dbo].[ordermster] WHERE [o_member_email]='jjj@gmail.com' and [o_date]='2022-12-17';
        String query=
                "select o_id  FROM ordermster WHERE o_member_email=? and o_date=?";
        int count = jdbcTemplate.queryForObject(query,new Object[]{email,date}, Integer.class);
        return  count;
    }
    //抓取會員編號
    public int getMemberderid(String email){
        //SELECT [m_id]  FROM [dbo].[member] WHERE [email]='li@gmail.com';
        String query=
                "select m_id  FROM member WHERE email=?";
        int count = jdbcTemplate.queryForObject(query,new Object[]{email}, Integer.class);
        return  count;
    }



    //將訂單明細寫入雲端資料庫
    public String insertInToOderDetail(int oid,int mid,String name,String ice,String sugar,int amount,int dollar){
        String sql=
                "insert into orderdetail (o_id,m_id,name,ice,sugar,amount,dollar) values (?,?,?,?,?,?,?) ;";

        jdbcTemplate.update(sql,oid,mid,name,ice,sugar,amount,dollar);
        return "insert into ordetail sussed";
    }


    public List<Map<String,Object>> getHistoryOrderFromDB(int mid){
        //SELECT [name],[ice],[sugar],[amount],[dollar] FROM [dbo].[orderdetail] WHERE [m_id]=3;
        String sql=
                "SELECT name,ice,sugar,amount,dollar FROM orderdetail WHERE m_id=?;";

        return jdbcTemplate.queryForList(sql,mid);
    }


}
