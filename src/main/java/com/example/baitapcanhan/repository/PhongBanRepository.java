package com.example.baitapcanhan.repository;

import com.example.baitapcanhan.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan,Long> {
}

