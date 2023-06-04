package com.example.baitapcanhan.service;

import com.example.baitapcanhan.entity.PhongBan;
import com.example.baitapcanhan.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBan> GetAll(){
        return phongBanRepository.findAll();
    }
//    public Category getCategoryById(Long id){
//        Optional<Category> optionalCategory = categoryRepository.findById(id);
//        if(optionalCategory.isPresent()){
//            return optionalCategory.get();
//        }else {
//            throw new RuntimeException("Category not found");
//        }
//    }
}
