package es.edataconsulting.restapi.service;

import es.edataconsulting.restapi.entity.TmRoles;

public interface TmRolesService {
	//returns the default TmRole, in our case id=1
	public TmRoles getDefault();
	//returns TmRoles by name
	public TmRoles findByName(String name);
	//save TmRoles, if doen´t exists create a new one else edit it.
	public TmRoles save(TmRoles tmRoles);
}
