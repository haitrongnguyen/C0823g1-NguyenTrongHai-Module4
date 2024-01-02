package com.codegym.customer_province_management.repository;

import com.codegym.customer_province_management.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface IProvinceRepository extends CrudRepository<Province,Long> {
}
