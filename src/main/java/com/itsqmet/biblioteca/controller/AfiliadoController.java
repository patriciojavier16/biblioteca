package com.itsqmet.biblioteca.controller;

import com.itsqmet.biblioteca.entidades.Afiliado;
import com.itsqmet.biblioteca.entidades.Prestamo;
import com.itsqmet.biblioteca.repositorios.AfiliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
public class AfiliadoController {

    @Autowired
    AfiliadoRepository afiliadoRepository;

    @GetMapping("/listarAfiliado")
    public String listaDeAfiliados(Model model){
        List<Afiliado> afiliados = afiliadoRepository.findAll();
        model.addAttribute("afiliados", afiliados);
        return "infoAfiliado";
    }

    //CRUD-CRREATE
    @GetMapping("/formAfi")
    public String formulario(Model model){
        model.addAttribute("afiliado", new Afiliado());
        return "formAfiliado";
    }

    @PostMapping("/formAfi")
    public String nuevoAfiliado(Afiliado afiliado){
        if (afiliado.getId()!=null){

        }
        if (afiliado!=null){
            afiliadoRepository.save(afiliado);

        }else{
            JOptionPane.showMessageDialog(null, "Ingrese los datos");
        }
        return "redirect:/listarAfiliado";
    }

    @GetMapping("/editarAfiliado/{id}")
    public String editarAfiliados(@PathVariable int id, Model model){
        Optional<Afiliado> afiliado=afiliadoRepository.findById(id);
        model.addAttribute("afiliado", afiliado);
        return "formAfiliado";
    }

    @GetMapping("/eliminarAfiliado/{id}")
    public String eliminarAfiliado(@PathVariable int id){
        afiliadoRepository.deleteById(id);
        return "redirect:/listarAfiliado";
    }
}
