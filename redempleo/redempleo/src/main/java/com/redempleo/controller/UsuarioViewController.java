package com.redempleo.controller;

import com.redempleo.model.Usuario;
import com.redempleo.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UsuarioViewController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioViewController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Mostrar lista de usuarios
    @GetMapping("/")
    public String mostrarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "index";
    }

    // Guardar nuevo usuario desde formulario
    @PostMapping("/usuarios")
    public String guardarUsuario(@RequestParam String nombre, @RequestParam String correo) {
        Usuario nuevo = new Usuario();
        nuevo.setNombre(nombre);
        nuevo.setCorreo(correo);
        usuarioRepository.save(nuevo);
        return "redirect:/";
    }

    // Eliminar usuario
    @PostMapping("/usuarios/{id}")
    public String eliminarUsuario(@PathVariable Long id, @RequestParam(name = "_method", required = false) String method) {
        if ("delete".equalsIgnoreCase(method)) {
            usuarioRepository.deleteById(id);
        }
        return "redirect:/";
    }
}