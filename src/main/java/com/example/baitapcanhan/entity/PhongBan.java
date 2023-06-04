package com.example.baitapcanhan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "phongban")
public class PhongBan {
    public PhongBan() {
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String maPhong;
    @NotNull(message = "Name must not be empty")
    @Size(max = 50,min = 1, message = "Name must be less than 50 characters")
    @Column(name = "tenphong")
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan",cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;
}
