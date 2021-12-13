/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.repositories;

import RetosCiclo4.RevistaCatalogoCenicienta.interfaces.IOrderCrudRepository;
import RetosCiclo4.RevistaCatalogoCenicienta.models.OrderModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jaime López Patiño
 */
@Repository
public class OrderRepository {

    @Autowired
    private IOrderCrudRepository orderCrudRepository;

    public List<OrderModel> getAll() {
        return (List<OrderModel>) orderCrudRepository.findAll();
    }

    public Optional<OrderModel> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public OrderModel create(OrderModel orderModel) {
        return orderCrudRepository.save(orderModel);
    }

    public void update(OrderModel orderModel) {
        orderCrudRepository.save(orderModel);
    }

    public void delete(OrderModel orderModel) {
        orderCrudRepository.delete(orderModel);
    }

    public Optional<OrderModel> lastUserId() {
        return orderCrudRepository.findTopByOrderByIdDesc();
    }

    public List<OrderModel> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }
}
