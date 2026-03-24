package com.generation.localpro.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int userId;
    private String name;
    private List<String> tags;
    private String description;
    private Status status;

    @OneToMany(mappedBy = "operationtype", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OperationTypeByVendor> operationsProvided;

}
