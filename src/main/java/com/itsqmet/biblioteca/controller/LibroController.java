package com.itsqmet.biblioteca.controller;

import com.itsqmet.biblioteca.entidades.Libros;
import com.itsqmet.biblioteca.repositorios.LibroRepository;
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
public class LibroController {

    @Autowired
    LibroRepository libroRepository;


    @GetMapping("/listarLibros")
    public String listaDeLibros(Model model){
        List<Libros> libros = libroRepository.findAll();
        model.addAttribute("libros", libros);
        return "infoLibros";
    }

    //CRUD-CRREATE
    @GetMapping("/form")
    public String formulario(Model model){
        model.addAttribute("libro", new Libros());
        return "formLibros";
    }

    @PostMapping("/form")
    public String nuevoLibro(@ModelAttribute("afiliado") @Valid Libros libros, BindingResult result){
        if (result.hasErrors()){
            return "formLibros";
        }
        libroRepository.save(libros);
        return "redirect:/listarLibros";
    }

    @GetMapping("/editar/{id}")
    public String editarLibros(@PathVariable int id, Model model){
        Optional<Libros> libro=libroRepository.findById(id);
        model.addAttribute("libro", libro);
        return "formLibros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable int id){
        libroRepository.deleteById(id);
        return "redirect:/listarLibros";
    }
}
