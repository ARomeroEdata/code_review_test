package es.edataconsulting.restapi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TM_USERS")
public class TmUsers {
	//primary key id, with autoincrement.
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id=0;
	//Name, can´t be null
	@NotNull
	@Column(name="name")
	private String name;
	//Set of roles of the user.
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "TM_USERS_TM_ROLES", joinColumns = {
			@JoinColumn(name = "id_tm_users") },
			inverseJoinColumns = { @JoinColumn(name = "id_tm_roles",
					nullable = false, updatable = false) })
	private Set<TmRoles> tmRoles;
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
	public Set<TmRoles> getTmRoles() {
		return tmRoles;
	}
	public void setTmRoles(Set<TmRoles> tmRoles) {
		this.tmRoles = tmRoles;
	}
	
}
