package com.example.springbootsimpleapp.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Board implements Serializable {
	@Id
	@SequenceGenerator(
			name = "board_sequence",
			sequenceName = "board_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "board_sequence"
	)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	
	public Board() {}
	
	public Board(String name) {
		this.name = name;
	}
	
	public Long getId()
	{
		return this.id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setId(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Board{id=" + id + ", name=" + name + "}";
	}
}
