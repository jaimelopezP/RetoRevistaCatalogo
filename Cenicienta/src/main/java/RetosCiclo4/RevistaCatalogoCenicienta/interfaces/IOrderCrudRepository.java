/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.interfaces;

import RetosCiclo4.RevistaCatalogoCenicienta.models.OrderModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Jaime López Patiño
 */
public interface IOrderCrudRepository extends MongoRepository<OrderModel, Integer> {

    //Ordenes de pedido que coincida con la zona recibida como parámetro
    @Query("{'salesMan.zone': ?0}")
    List<OrderModel> findByZone(final String zone);

    //Ordenes por Estado
    @Query("{status: ?0}")
    List<OrderModel> findByStatus(final String status);

    //La orden con el id máximo
    Optional<OrderModel> findTopByOrderByIdDesc();

}
