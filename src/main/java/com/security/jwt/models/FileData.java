package com.security.jwt.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
//@JsonIgnoreProperties({"bytes"})
@Table(name="filemeta")
public class FileData {
	@Id
	@Column(name="id_file")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_file;
	
	@Column(name="name")
	private String name;
	
	 
	@Column(name="filesize")
	private String filesize;
	
	@Column(name="filetype")
	private String filetype;
	
	@Column(name="filebyte")
	private byte[] filebyte;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	
	private User user;
	
	public Long getId_file() {
		return id_file;
	}

	public void setId_file(Long id_file) {
		this.id_file = id_file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getFletype() {
		return filetype;
	}

	public void setFletype(String fletype) {
		this.filetype = fletype;
	}

	public User getUsers() {
		return user;
	}

	public void setUsers(User user) {
		this.user = user;
	}

	
	public byte[] getFileByte() {
		return filebyte;
	}
	public void setFileBytes(byte[] filebyte) {
		this.filebyte = filebyte;
	}



}
