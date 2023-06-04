package com.example.baitapcanhan.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String maNV;
    @Column
    private String ten_NV;
    @Column
    @Length(min = 0,max = 50,message = "Tên hình ảnh không quá 50 ký tự")

    private String phai;
    @Column
    private String noiSinh;
    @ManyToOne
    @JoinColumn(name = "maphong")
    private PhongBan phongBan;
    @Column
    private Long luong;
}

