/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.interfaces;

import RetosCiclo4.RevistaCatalogoCenicienta.models.CleaningProductModel;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Jaime López Patiño
 */
public interface ICleaningProductCrudRepository extends MongoRepository<CleaningProductModel, String> {

    public List<CleaningProductModel> findByPriceLessThanEqual(double precio);

}
