package es.edataconsulting.restapi.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.edataconsulting.restapi.entity.TmRoles;
import es.edataconsulting.restapi.entity.TmUsers;
import es.edataconsulting.restapi.model.TmUsersModel;
import es.edataconsulting.restapi.service.TmRolesService;

@Component("tmUsersConverter")
public class TmUsersConverter {
	@Autowired
	@Qualifier("tmRolesServiceImpl")
	private TmRolesService tmRolesService;
	
	//Method to convert from TmUsers to TmUsersModel
	public TmUsersModel tmUsers2TmUsersModel(TmUsers tmUsers) {
		TmUsersModel tmUsersModel=new TmUsersModel();
		tmUsersModel.setId(tmUsers.getId());
		tmUsersModel.setName(tmUsers.getName());
		List<String> roles=new ArrayList<>(tmUsers.getTmRoles().size());
		for(TmRoles tmRoles:tmUsers.getTmRoles()) {
			roles.add(tmRoles.getName());
		}
		Collections.sort(roles);
		tmUsersModel.setRoles(roles);
		return tmUsersModel;
	}
	
	//Method to convert TmUsersModel into TmUsers
	public TmUsers tmUsersModel2TmUsers(TmUsersModel tmUsersModel) {
		TmUsers tmUsers=new TmUsers();
		tmUsers.setId(tmUsersModel.getId());
		tmUsers.setName(tmUsersModel.getName());
		Set<TmRoles> tmRolesSet=new HashSet<>();
		if(tmUsersModel.getRoles()==null||tmUsersModel.getRoles().isEmpty()) {
			tmRolesSet.add(tmRolesService.getDefault());
		}else {
			for(String role:tmUsersModel.getRoles()) {
				TmRoles tmRoles=tmRolesService.findByName(role);
				if(tmRoles==null) {
					tmRoles=new TmRoles();
					tmRoles.setName(role);
				}
				tmRolesSet.add(tmRoles);
			}
		
		}
		tmUsers.setTmRoles(tmRolesSet);
		return tmUsers;
	}
}
