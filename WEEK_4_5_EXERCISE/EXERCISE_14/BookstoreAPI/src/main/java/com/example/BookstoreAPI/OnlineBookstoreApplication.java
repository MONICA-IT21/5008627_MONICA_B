package main.java.com.example.BookstoreAPI;
import com.example.bookstore.config.MetricsConfig.CustomMetrics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineBookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookstoreApplication.class, args);
    }

    @Autowired
    private CustomMetrics customMetrics;

    public void someServiceMethod() {
        customMetrics.incrementCustomCounter();
    }
}
