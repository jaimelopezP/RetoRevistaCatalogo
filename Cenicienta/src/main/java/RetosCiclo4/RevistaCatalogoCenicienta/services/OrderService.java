/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.services;

import RetosCiclo4.RevistaCatalogoCenicienta.models.OrderModel;
import RetosCiclo4.RevistaCatalogoCenicienta.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jaime López Patiño
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderModel> getAll() {
        return orderRepository.getAll();
    }

    public Optional<OrderModel> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public OrderModel create(OrderModel orderModel) {

        //El maximo id existente en la coleccion
        Optional<OrderModel> orderIdMaxima = orderRepository.lastUserId();

        //si el id de la orden que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (orderModel.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (orderIdMaxima.isEmpty()) {
                orderModel.setId(1);
            } //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo de la orden
            else {
                orderModel.setId(orderIdMaxima.get().getId() + 1);
            }
        }

        Optional<OrderModel> e = orderRepository.getOrder(orderModel.getId());
        if (e.isEmpty()) {
            return orderRepository.create(orderModel);
        } else {
            return orderModel;
        }
    }

    public OrderModel update(OrderModel orderModel) {

        if (orderModel.getId() != null) {
            Optional<OrderModel> orderDb = orderRepository.getOrder(orderModel.getId());
            if (!orderDb.isEmpty()) {
                if (orderModel.getStatus() != null) {
                    orderDb.get().setStatus(orderModel.getStatus());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return orderModel;
            }
        } else {
            return orderModel;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<OrderModel> findByZone(String zona) {
        return orderRepository.findByZone(zona);
    }
    //Ordenes de un asesor
    public List<OrderModel> ordersSalesManByID(int id) {
        return orderRepository.ordersSalesManByID(id);
    }
    
    //Ordenes de un asesor x Fecha
    public List<OrderModel> ordersSalesManByDate(String dateStr, int id) {
        return orderRepository.ordersSalesManByDate(dateStr, id);
    }
    
    //Ordenes de un asesor x Estado
    public List<OrderModel> ordersSalesManByState(String state, Integer id) {
        return orderRepository.ordersSalesManByState(state, id);
    }

}
