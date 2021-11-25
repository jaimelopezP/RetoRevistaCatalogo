/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.services;

import RetosCiclo4.RevistaCatalogoCenicienta.models.UserModel;
import RetosCiclo4.RevistaCatalogoCenicienta.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jaime L�pez Pati�o
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAll() {
        return userRepository.getall();
    }

    public Optional<UserModel> getUser(int id) {
        return userRepository.getUser(id);
    }

    public UserModel registrar(UserModel userModel) {

        if (userModel.getId() == null) {
            if (existeEmail(userModel.getEmail()) == false) {
                return userRepository.save(userModel);
            } else {
                return userModel;
            }
        } else {
            return userModel;
        }

    }

    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public UserModel autenticarUsuario(String email, String password) {
        Optional<UserModel> usuario = userRepository.autenticarUsuario(email, password);
        if (usuario.isEmpty()) {
            return new UserModel(email,password,"NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }

}
