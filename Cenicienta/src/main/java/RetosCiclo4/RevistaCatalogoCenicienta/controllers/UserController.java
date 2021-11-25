/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.controllers;

import RetosCiclo4.RevistaCatalogoCenicienta.models.UserModel;
import RetosCiclo4.RevistaCatalogoCenicienta.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jaime López Patiño
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserModel> getAll() {
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel registrar(@RequestBody UserModel userModel) {
        return userService.registrar(userModel);
    }

    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public UserModel autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }

}
