package ProjectDemo.demo.controller.CheckDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseCheckService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseCheckService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String checkDatabaseConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "Connection to the database was successful!";
        } catch (Exception e) {
            return "Error connecting to the database: " + e.getMessage();
        }
    }
}