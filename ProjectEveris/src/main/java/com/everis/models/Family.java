package com.everis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FAMILIES")
public class Family {

	@Id
	@Column(name = "FAMILY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long familyId;
		
	@Column(name = "FAMILY_NAME", length = 50)
	private String familyName;

	@JoinColumn(name = "HEAD_OF_FAMILY", referencedColumnName = "PARENT_ID")
	@OneToOne
	private Parent headOfFamily;
	
	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public Parent getHeadOfFamily() {
		return headOfFamily;
	}

	public void setHeadOfFamily(Parent headOfFamily) {
		this.headOfFamily = headOfFamily;
	}

	public Family() {
	}

	public Family(Long familyId, String familyName, Parent headOfFamily) {
		this.familyId = familyId;
		this.familyName = familyName;
		this.headOfFamily = headOfFamily;
	}

}
