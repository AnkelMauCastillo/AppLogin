package mx.edu.uacm.progweb.applogin.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uacm.progweb.applogin.entity.Usuario;
import mx.edu.uacm.progweb.applogin.repository.UsuarioRepository;
import mx.edu.uacm.progweb.applogin.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository repository;
	
	@Override
	public Iterable<Usuario> getAllUsers() {
		return repository.findAll();
	}
	
	private boolean checkUsernameAvailable(Usuario user) throws Exception {
		Optional<Usuario> userFound = repository.findByNombreUsuario(user.getNombreUsuario());
		if (userFound.isPresent()) {
			throw new Exception("nombre de usuario no disponible");
		}
		return true;
	}

	private boolean checkPasswordValid(Usuario user) throws Exception {
		if ( !user.getContrasenia().equals(user.getConfirmContrasenia())) {
			throw new Exception("Password y Confirm Password no son iguales");
		}
		return true;
	}


	@Override
	public Usuario createUser(Usuario user) throws Exception {
		if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
			user = repository.save(user);
		}
		return user;
	}
}
