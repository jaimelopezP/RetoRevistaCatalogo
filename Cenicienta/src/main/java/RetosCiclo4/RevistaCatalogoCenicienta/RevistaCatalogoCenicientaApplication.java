package RetosCiclo4.RevistaCatalogoCenicienta;

import RetosCiclo4.RevistaCatalogoCenicienta.interfaces.ICleaningProductCrudRepository;
import RetosCiclo4.RevistaCatalogoCenicienta.interfaces.IUserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class RevistaCatalogoCenicientaApplication implements CommandLineRunner {

    @Autowired
    private IUserCrudRepository userCrudRepository;
    @Autowired
    private ICleaningProductCrudRepository cleaningProductCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(RevistaCatalogoCenicientaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userCrudRepository.deleteAll();
        cleaningProductCrudRepository.deleteAll();

    }

}
