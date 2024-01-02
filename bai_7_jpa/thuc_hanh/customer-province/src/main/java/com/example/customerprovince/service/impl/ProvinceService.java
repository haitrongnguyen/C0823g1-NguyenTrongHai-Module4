package com.example.customerprovince.service.impl;

import com.example.customerprovince.model.Province;
import com.example.customerprovince.repository.IProvinceRepository;
import com.example.customerprovince.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository provinceRepository;
    @Override
    public List<Province> findAll() {
        return (List<Province>) provinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        provinceRepository.delete(findById(id));
    }
}
