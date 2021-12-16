/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.services;

import RetosCiclo4.RevistaCatalogoCenicienta.models.CleaningProductModel;
import RetosCiclo4.RevistaCatalogoCenicienta.repositories.CleaningProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jaime López Patiño
 */
@Service
public class CleaningProductService {

    @Autowired
    private CleaningProductRepository cleaningProductRepository;

    public List<CleaningProductModel> listAll() {
        return cleaningProductRepository.listAll();
    }

    public Optional<CleaningProductModel> getCleaningProduct(String reference) {
        return cleaningProductRepository.getCleaningProduct(reference);
    }

    public CleaningProductModel create(CleaningProductModel cleaningProductModel) {
        if (cleaningProductModel.getReference() == null) {
            return cleaningProductModel;
        } else {
            return cleaningProductRepository.create(cleaningProductModel);
        }
    }

    public CleaningProductModel update(CleaningProductModel cleaningProductModel) {

        if (cleaningProductModel.getReference() != null) {
            Optional<CleaningProductModel> cleaningProductDb = cleaningProductRepository.getCleaningProduct(cleaningProductModel.getReference());
            if (!cleaningProductDb.isEmpty()) {
                if (cleaningProductModel.getBrand() != null) {
                    cleaningProductDb.get().setBrand(cleaningProductModel.getBrand());
                }
                if (cleaningProductModel.getCategory() != null) {
                    cleaningProductDb.get().setCategory(cleaningProductModel.getCategory());
                }

                if (cleaningProductModel.getDescription() != null) {
                    cleaningProductDb.get().setDescription(cleaningProductModel.getDescription());
                }
                if (cleaningProductModel.getPrice() != 0.0) {
                    cleaningProductDb.get().setPrice(cleaningProductModel.getPrice());
                }
                if (cleaningProductModel.getQuantity() != 0) {
                    cleaningProductDb.get().setQuantity(cleaningProductModel.getQuantity());
                }
                if (cleaningProductModel.getPhotography() != null) {
                    cleaningProductDb.get().setPhotography(cleaningProductModel.getPhotography());
                }
                cleaningProductDb.get().setAvailability(cleaningProductModel.isAvailability());
                cleaningProductRepository.update(cleaningProductDb.get());
                return cleaningProductDb.get();
            } else {
                return cleaningProductModel;
            }
        } else {
            return cleaningProductModel;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getCleaningProduct(reference).map(cleaningProduct -> {
            cleaningProductRepository.delete(cleaningProduct);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<CleaningProductModel> productByPrice(double price) {
        return cleaningProductRepository.productByPrice(price);
    }

}
