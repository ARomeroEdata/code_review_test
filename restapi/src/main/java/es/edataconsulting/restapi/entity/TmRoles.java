package es.edataconsulting.restapi.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TM_ROLES")
public class TmRoles {
	//Primary key id with autoincrement
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id=0;
	//role name, can´t be null
	@NotNull
	@Column(name="name")
	private String name;
	//Set of TmUsers with the role
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "tmRoles")
	private Set<TmUsers> tmUsers;
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
	public Set<TmUsers> getTmUsers() {
		return tmUsers;
	}
	public void setTmUsers(Set<TmUsers> tmUsers) {
		this.tmUsers = tmUsers;
	}
}
