package mx.edu.uacm.progweb.applogin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.edu.uacm.progweb.applogin.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
