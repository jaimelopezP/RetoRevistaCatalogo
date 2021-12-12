/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.repositories;

import RetosCiclo4.RevistaCatalogoCenicienta.interfaces.ICleaningProductCrudRepository;
import RetosCiclo4.RevistaCatalogoCenicienta.models.CleaningProductModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jaime López Patiño
 */
@Repository
public class CleaningProductRepository {

    @Autowired
    private ICleaningProductCrudRepository cleaningProductCrudRepository;

    public List<CleaningProductModel> listAll() {
        return cleaningProductCrudRepository.findAll();
    }

    public Optional<CleaningProductModel> getCleaningProduct(String reference) {
        return cleaningProductCrudRepository.findById(reference);
    }

    public CleaningProductModel create(CleaningProductModel cleaningProductModel) {
        return cleaningProductCrudRepository.save(cleaningProductModel);
    }

    public void update(CleaningProductModel cleaningProductModel) {
        cleaningProductCrudRepository.save(cleaningProductModel);

    }

    public void delete(CleaningProductModel cleaningProductModel) {
        cleaningProductCrudRepository.delete(cleaningProductModel);
    }

}
