package tw.myapp.YujinCoffeeAppServer.appdbRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StoreRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> getStore() {
        return jdbcTemplate.queryForList("select * from 分店資料;");
    }


}
