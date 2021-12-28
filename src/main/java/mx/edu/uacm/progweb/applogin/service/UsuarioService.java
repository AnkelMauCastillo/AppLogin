package mx.edu.uacm.progweb.applogin.service;

import mx.edu.uacm.progweb.applogin.entity.Usuario;

public interface UsuarioService {

	public Iterable<Usuario> getAllUsers();
	
	public Usuario createUser(Usuario user) throws Exception;

	
}
