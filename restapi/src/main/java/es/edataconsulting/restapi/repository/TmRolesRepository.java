package es.edataconsulting.restapi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.edataconsulting.restapi.entity.TmRoles;

@Repository("tmRolesRepository")
public interface TmRolesRepository extends JpaRepository<TmRoles,Serializable>{
	//returns a TmRoles by id
	public TmRoles findById(int id);
	//returns a TmRoles by name
	public TmRoles findByName(String name);
}
