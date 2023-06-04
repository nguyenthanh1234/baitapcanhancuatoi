package com.example.baitapcanhan.controller;

import com.example.baitapcanhan.entity.NhanVien;
import com.example.baitapcanhan.service.NhanVienService;
import com.example.baitapcanhan.service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showAllNhanVien(Model model) {
        List<NhanVien> nhanViens = nhanVienService.GetAll();
        model.addAttribute("nhanViens", nhanViens);
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addNhanVienForm(Model model){
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBans",phongBanService.GetAll());
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanVien")NhanVien nhanVien, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){

            model.addAttribute("phongBans",phongBanService.GetAll());
            return "nhanvien/add";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhanviens";
    }


    @GetMapping("/edit/{maNV}")
    public String editNhanVienForm(@PathVariable("maNV") String maNV, Model model){
        NhanVien editNhanVien = null;
        model.addAttribute("phongBans",phongBanService.GetAll());
        for(NhanVien nhanVien : nhanVienService.GetAll()){
            if(nhanVien.getMaNV().equals(maNV)){
                editNhanVien = nhanVien;
            }
        }
        if(editNhanVien != null){
            model.addAttribute("nhanVien",editNhanVien);
            return "nhanviens/edit";
        }else{
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editNhanVien(@Valid @ModelAttribute("nhanVien") NhanVien updatedNhanVien, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){

            model.addAttribute("phongBans",phongBanService.GetAll());
            return "nhanvien/edit";
        }
        for(int i = 0; i<nhanVienService.GetAll().size();i++){
            NhanVien nhanVien = nhanVienService.GetAll().get(i);
            if(nhanVien.getMaNV() == updatedNhanVien.getMaNV()){
                nhanVienService.GetAll().set(i,updatedNhanVien);
                nhanVienService.update(updatedNhanVien);
                break;
            }
        }
        return "redirect:/nhanviens";
    }
    @GetMapping("/delete/{maNV}")
    public String deleteNhanVien(@PathVariable("maNV") String maNV){
        Iterator<NhanVien> iterator = nhanVienService.GetAll().iterator();
        while (iterator.hasNext()){
            NhanVien nhanVien = iterator.next();
            if(nhanVien.getMaNV() == maNV){
//                iterator.remove();
                nhanVienService.delete(maNV);
                break;
            }
        }
        return "redirect:/nhanviens";
    }
}