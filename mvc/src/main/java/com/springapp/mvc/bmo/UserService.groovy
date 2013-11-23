package com.springapp.mvc.bmo

import groovy.sql.Sql
import javax.sql.DataSource
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

class UserService {
	@Autowired
	DataSource dataSource
	
	public bingo(){
		println("enter bingo()!")
		"!bingo!"
	}
	
	public insertUser(){
		
		def sql = new Sql(dataSource)
		
		sql.execute '''
	     create table PROJECT (
	         id integer not null,
	         name varchar(50),
	         url varchar(100),
	     )
	 '''
		
		
		
	}
	
	public updateUser(){
		
	}
	
	public deleteUser(){
		
	}
}
