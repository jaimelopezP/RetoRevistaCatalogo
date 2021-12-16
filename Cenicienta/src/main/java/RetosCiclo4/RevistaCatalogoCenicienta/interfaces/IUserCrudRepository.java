/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.interfaces;

import RetosCiclo4.RevistaCatalogoCenicienta.models.UserModel;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jaime López patiño
 */
public interface IUserCrudRepository extends MongoRepository<UserModel, Integer> {

    Optional<UserModel> findByEmail(String email);

    Optional<UserModel> findByEmailAndPassword(String email, String password);

    Optional<UserModel> findTopByOrderByIdDesc();

    List<UserModel> findBybirthtDay(Date date);
    
    List<UserModel> findByMonthBirthtDay(String monthBirthtDay);
}
