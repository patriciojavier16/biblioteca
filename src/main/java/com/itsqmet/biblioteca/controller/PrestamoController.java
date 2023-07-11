package com.itsqmet.biblioteca.controller;

import com.itsqmet.biblioteca.entidades.Prestamo;
import com.itsqmet.biblioteca.repositorios.PrestamoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PrestamoController {

    @Autowired
    PrestamoRepository prestamoRepository;


    @GetMapping("/listarPrestamo")
    public String listaDePrestamos(Model model){
        List<Prestamo> prestamos = prestamoRepository.findAll();
        model.addAttribute("prestamos", prestamos);
        return "infoPrestamo";
    }

    //CRUD-CRREATE
    @GetMapping("/formPres")
    public String formulario(Model model){
        model.addAttribute("prestamo", new Prestamo());
        return "formPrestamo";
    }

    @PostMapping("/formPres")
    public String nuevoPrestamo(@ModelAttribute("prestamo")@Valid Prestamo prestamo, BindingResult result) {
        if (result.hasErrors()) {
            return "formPrestamo";

        }
        if (prestamo.getFechaRetorno().isAfter(prestamo.getFechaPrestamo())) {
            prestamoRepository.save(prestamo);
            return "redirect:/listarPrestamo";
        } else {
            return "formPrestamo";
        }
    }

    @GetMapping("/editarPrestamo/{id}")
    public String editarPrestamos(@PathVariable int id, Model model){
        Optional<Prestamo> prestamo=prestamoRepository.findById(id);
        model.addAttribute("prestamo", prestamo);
        return "formPrestamo";
    }

    @GetMapping("/eliminarPrestamo/{id}")
    public String eliminarPrestamo(@PathVariable int id){
        prestamoRepository.deleteById(id);
        return "redirect:/listarPrestamo";
    }
}
