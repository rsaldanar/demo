package com.crud.spring.demo.repository;

import com.crud.spring.demo.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {

    Iterable<Usuario> findByNombre(String nombre);

    Iterable<Usuario> findByApellido(String apellido);

}
