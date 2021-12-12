/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosCiclo4.RevistaCatalogoCenicienta.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Jaime López Patiño
 */
@Document(collection = "cleaningproducts")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CleaningProductModel {
    @Id
    private String reference;
    private String brand;
    private String category;
    private String material;
    private String presentacion;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;    
}
