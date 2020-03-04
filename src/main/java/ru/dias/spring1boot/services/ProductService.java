package ru.dias.spring1boot.services;


import ru.dias.spring1boot.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    List<Product> findAllFilter(Double min, Double max);

}
