package es.edataconsulting.restapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.edataconsulting.restapi.entity.TmRoles;
import es.edataconsulting.restapi.repository.TmRolesRepository;
import es.edataconsulting.restapi.service.TmRolesService;

@Service("tmRolesServiceImpl")
public class TmRolesServiceImpl implements TmRolesService{
	@Autowired
	@Qualifier("tmRolesRepository")
	TmRolesRepository tmRolesRepository;
	@Override
	public TmRoles getDefault() {
		return tmRolesRepository.findById(1);
	}

	@Override
	public TmRoles findByName(String name) {
		return tmRolesRepository.findByName(name);
	}

	@Override
	public TmRoles save(TmRoles tmRoles) {
		return tmRolesRepository.save(tmRoles);
	}
	
}
