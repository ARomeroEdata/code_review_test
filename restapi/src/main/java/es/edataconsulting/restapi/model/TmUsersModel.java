package es.edataconsulting.restapi.model;

import java.util.List;

public class TmUsersModel {
	//Id
	private int id;
	//Username
	private String name;
	//List of string with roles name.
	private List<String> roles;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
