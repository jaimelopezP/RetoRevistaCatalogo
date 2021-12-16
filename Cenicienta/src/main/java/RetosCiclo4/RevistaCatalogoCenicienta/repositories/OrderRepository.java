/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.repositories;

import RetosCiclo4.RevistaCatalogoCenicienta.interfaces.IOrderCrudRepository;
import RetosCiclo4.RevistaCatalogoCenicienta.models.OrderModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jaime López Patiño
 */
@Repository
public class OrderRepository {

    @Autowired
    private IOrderCrudRepository orderCrudRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

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
    //Ordenes de un asesor
    public List<OrderModel> ordersSalesManByID(Integer id) {

        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id);

        query.addCriteria(criterio);
        List<OrderModel> orders = mongoTemplate.find(query, OrderModel.class);

        return orders;
    }

    //Ordenes de un asesor por Fecha
    public List<OrderModel> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(2).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);
        List<OrderModel> orders = mongoTemplate.find(query, OrderModel.class);

        return orders;
    }

    //Ordenes de un asesor x Estado
    public List<OrderModel> ordersSalesManByState(String state, Integer id) {

        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);

        query.addCriteria(criterio);
        List<OrderModel> orders = mongoTemplate.find(query, OrderModel.class);

        return orders;
    }
    
}
