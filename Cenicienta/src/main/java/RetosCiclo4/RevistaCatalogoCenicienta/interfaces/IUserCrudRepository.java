/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.interfaces;

import RetosCiclo4.RevistaCatalogoCenicienta.models.UserModel;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jaime López patiño
 */
public interface IUserCrudRepository extends CrudRepository<UserModel, Integer> {
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findByEmailAndPassword(String email,String password);

}
