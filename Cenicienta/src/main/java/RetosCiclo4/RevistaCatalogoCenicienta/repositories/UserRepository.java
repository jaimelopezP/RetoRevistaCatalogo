/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.repositories;

import RetosCiclo4.RevistaCatalogoCenicienta.interfaces.IUserCrudRepository;
import RetosCiclo4.RevistaCatalogoCenicienta.models.UserModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jaime López Patiño
 */
@Repository
public class UserRepository {

    @Autowired
    private IUserCrudRepository userCrudRepository;

    public List<UserModel> listAll() {
        return userCrudRepository.findAll();
    }

    public Optional<UserModel> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public UserModel create(UserModel userModel) {
        return userCrudRepository.save(userModel);
    }
    
    public void update(UserModel userModel) {
        userCrudRepository.save(userModel);
    }

    public void delete(UserModel userModel) {
        userCrudRepository.delete(userModel);
    }
    
    

    public boolean existeEmail(String email) {
        Optional<UserModel> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();

    }

    public Optional<UserModel> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

}
