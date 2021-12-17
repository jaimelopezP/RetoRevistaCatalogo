package RetosCiclo4.RevistaCatalogoCenicienta;

import RetosCiclo4.RevistaCatalogoCenicienta.interfaces.ICleaningProductCrudRepository;
import RetosCiclo4.RevistaCatalogoCenicienta.interfaces.IOrderCrudRepository;
import RetosCiclo4.RevistaCatalogoCenicienta.interfaces.IUserCrudRepository;
import RetosCiclo4.RevistaCatalogoCenicienta.repositories.OrderRepository;
import RetosCiclo4.RevistaCatalogoCenicienta.repositories.UserRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class RevistaCatalogoCenicientaApplication implements CommandLineRunner {

    @Autowired
    private IUserCrudRepository userCrudRepository;
    @Autowired
    private ICleaningProductCrudRepository cleaningProductCrudRepository;
    @Autowired
    private IOrderCrudRepository orderCrudRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RevistaCatalogoCenicientaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        userCrudRepository.deleteAll();
        cleaningProductCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();

    }

}
