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
        return jdbcTemplate.queryForList("select * from products where series = 1;");
    }
}
