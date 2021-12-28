package mx.edu.uacm.progweb.applogin.entity;


import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7490085035363257669L;

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column
	@NotBlank
	private String nombre;
	
	@Column
	@NotBlank
	@Size(min=5,max=8,message="No se cumple las reglas del tamano")
	private String apellidoMaterno;
	
	@Column
	@NotBlank
	private String apellidoPaterno;
	
	@Column(unique = true)
	@NotBlank
	private String correo;
	
	@Column(unique = true)
	@NotBlank
	private String nombreUsuario;
	
	
	@Column
	@NotBlank
	private String contrasenia;
	
	@Transient
	@NotBlank
	private String confirmContrasenia;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="usuario_roles", joinColumns = @JoinColumn(name="usuario_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	public Usuario() {}
	
	public Usuario(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getConfirmContrasenia() {
		return confirmContrasenia;
	}

	public void setConfirmContrasenia(String confirmContrasenia) {
		this.confirmContrasenia = confirmContrasenia;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidoMaterno, apellidoPaterno, confirmContrasenia, contrasenia, correo, id, nombre,
				nombreUsuario, roles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellidoMaterno, other.apellidoMaterno)
				&& Objects.equals(apellidoPaterno, other.apellidoPaterno)
				&& Objects.equals(confirmContrasenia, other.confirmContrasenia)
				&& Objects.equals(contrasenia, other.contrasenia) && Objects.equals(correo, other.correo)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(nombreUsuario, other.nombreUsuario) && Objects.equals(roles, other.roles);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidoMaterno=" + apellidoMaterno
				+ ", apellidoPaterno=" + apellidoPaterno + ", correo=" + correo + ", nombreUsuario=" + nombreUsuario
				+ ", contrasenia=" + contrasenia + ", confirmContrasenia=" + confirmContrasenia + ", roles=" + roles
				+ "]";
	}

	
	
	
	

}
