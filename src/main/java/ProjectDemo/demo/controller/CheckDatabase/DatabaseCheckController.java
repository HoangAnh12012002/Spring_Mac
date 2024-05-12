package ProjectDemo.demo.controller.CheckDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DatabaseCheckController {

    private final DatabaseCheckService databaseCheckService;

    @Autowired
    public DatabaseCheckController(DatabaseCheckService databaseCheckService) {
        this.databaseCheckService = databaseCheckService;
    }

    @GetMapping("/check-database-connection")
    public String checkDatabaseConnection() {
        return databaseCheckService.checkDatabaseConnection();
    }
}