package com.example.baitapcanhan.repository;

import com.example.baitapcanhan.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien,String> {
}
