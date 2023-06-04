package com.example.baitapcanhan.service;

import com.example.baitapcanhan.entity.NhanVien;
import com.example.baitapcanhan.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository repo;
    public List<NhanVien> GetAll(){
        return (List<NhanVien>) repo.findAll();
    }

    public void add(NhanVien newNhanVien){
        repo.save(newNhanVien);
    }

    public void update(NhanVien nhanVien){
        repo.save(nhanVien);
    }

    public void delete(String maNV){

        repo.deleteById(maNV);
    }
}
