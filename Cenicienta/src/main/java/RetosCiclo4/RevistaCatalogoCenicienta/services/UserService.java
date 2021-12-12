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
 * @author Jaime López Patiño
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserModel> getUser(int id) {
        return userRepository.getUser(id);
    }

    public UserModel create(UserModel userModel) {

        if (userModel.getId() == null) {
            return userModel;
        } else {
            Optional<UserModel> e = userRepository.getUser(userModel.getId());
            if (e.isEmpty()) {
                if (existeEmail(userModel.getEmail()) == false) {
                    return userRepository.create(userModel);
                } else {
                    return userModel;
                }
            } else {
                return userModel;
            }
        }

    }

    public UserModel update(UserModel userModel) {

        if (userModel.getId() != null) {
            Optional<UserModel> userDb = userRepository.getUser(userModel.getId());
            if (!userDb.isEmpty()) {
                if (userModel.getIdentification() != null) {
                    userDb.get().setIdentification(userModel.getIdentification());
                }
                if (userModel.getName() != null) {
                    userDb.get().setName(userModel.getName());
                }
                if (userModel.getAddress() != null) {
                    userDb.get().setAddress(userModel.getAddress());
                }
                if (userModel.getCellPhone() != null) {
                    userDb.get().setCellPhone(userModel.getCellPhone());
                }
                if (userModel.getEmail() != null) {
                    userDb.get().setEmail(userModel.getEmail());
                }
                if (userModel.getPassword() != null) {
                    userDb.get().setPassword(userModel.getPassword());
                }
                if (userModel.getZone() != null) {
                    userDb.get().setZone(userModel.getZone());
                }

                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return userModel;
            }
        } else {
            return userModel;
        }
    }

    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<UserModel> listAll() {
        return userRepository.listAll();
    }

    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public UserModel autenticarUsuario(String email, String password) {
        Optional<UserModel> usuario = userRepository.autenticarUsuario(email, password);
        if (usuario.isEmpty()) {
            return new UserModel();
        } else {
            return usuario.get();
        }
    }

}
