package mx.edu.uacm.progweb.applogin.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.edu.uacm.progweb.applogin.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	
	
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	
	

}
