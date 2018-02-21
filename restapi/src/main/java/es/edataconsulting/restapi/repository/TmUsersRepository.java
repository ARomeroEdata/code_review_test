package es.edataconsulting.restapi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.edataconsulting.restapi.entity.TmUsers;

@Repository("tmUsersRepository")
public interface TmUsersRepository extends JpaRepository<TmUsers,Serializable>{
	//returns a TmUsers by id
	public abstract TmUsers findById(int id);
}
