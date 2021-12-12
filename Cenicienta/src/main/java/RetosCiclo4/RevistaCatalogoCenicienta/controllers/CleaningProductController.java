/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.controllers;

import RetosCiclo4.RevistaCatalogoCenicienta.models.CleaningProductModel;
import RetosCiclo4.RevistaCatalogoCenicienta.services.CleaningProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/api/cleaningproduct")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CleaningProductController {

    @Autowired
    private CleaningProductService cleaningProductService;

    @GetMapping("/all")
    public List<CleaningProductModel> listAll() {
        return cleaningProductService.listAll();
    }

    @GetMapping("/{reference}")
    public Optional<CleaningProductModel> getCleaningProduct(@PathVariable("reference") String reference) {
        return cleaningProductService.getCleaningProduct(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProductModel create(@RequestBody CleaningProductModel cleaningProductModel) {
        return cleaningProductService.create(cleaningProductModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProductModel update(@RequestBody CleaningProductModel gadget) {
        return cleaningProductService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return cleaningProductService.delete(reference);
    }

}
