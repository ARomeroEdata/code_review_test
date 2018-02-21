package es.edataconsulting.restapi.service;

import java.util.List;

import es.edataconsulting.restapi.entity.TmUsers;

public interface TmUsersService {
	//Returns a list with all users in DB.
	public List<TmUsers> findAll();
	//return TmUsers by id
	public TmUsers findById(int id);
	//save TmUsers, if doen´t exists create a new one else edit it.
	public TmUsers save(TmUsers tmUsers);
}
