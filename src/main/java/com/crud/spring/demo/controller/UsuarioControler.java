package com.crud.spring.demo.controller;

import com.crud.spring.demo.entity.Usuario;
import com.crud.spring.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @project: demo
 * @author: rsaldanar
 * @date: 10/9/22
 * @Correo: rsaldanar@gmail.com
 * @description:
 * @history:
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioControler {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @GetMapping("getid/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario getUsuario(@PathVariable("id") Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @GetMapping("getnombre/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getUsuarioByNombre(@PathVariable("nombre") String nombre) {
        return (List<Usuario>) usuarioRepository.findByNombre(nombre);
    }

    @GetMapping("getapellido/{apellido}")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getUsuarioByApellido(@PathVariable("apellido") String apellido) {
        return (List<Usuario>) usuarioRepository.findByApellido(apellido);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        Usuario usuarioUpdate = usuarioRepository.findById(id).orElse(null);
        usuarioUpdate.setNombre(usuario.getNombre());
        usuarioUpdate.setApellido(usuario.getApellido());
        return usuarioRepository.save(usuarioUpdate);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        Usuario usuarioDelete = usuarioRepository.findById(id).orElse(null);
        usuarioDelete.setEstado(false);
        usuarioRepository.save(usuarioDelete);
    }

}