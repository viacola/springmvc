package com.springapp.mvc.bmo

import groovy.sql.Sql
import javax.sql.DataSource
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service;

@Service

class UserService {
	@Autowired
	DataSource dataSource
	
	@Autowired
	JdbcTemplate jdbcTemplate
	
	def sql 
	
	@Autowired
	public UserService(DataSource dataSource){
		sql = new Sql(dataSource)
	}
	

	
	public bingo(){
		println("enter bingo()!")
		"!bingo!"
	}
	
	public insertUser(){
		
		def params = [20, 'Groovy', 'http://groovy.codehaus.org']
		sql.execute 'insert into PROJECT (id, name, url) values (?, ?, ?)', params
		sql.close()
		
		
	}
	
	public updateUser(){
		
	}
	
	public deleteUser(){
		
	}
	
	public  queryUser(){
		def rows = sql.rows("select * from PROJECT where name like 'Gra%'")
		 sql.eachRow('select * from PROJECT') { row ->
			 println "${row.name.padRight(10)} ($row.url)"
		 }
		 sql.close()
		 return rows
		
	}
	
	public queryProject(){
		def list =sql.rows("select * from PROJECT ")
	
	}
	
	public int  queryUser4Jt(){
		
		def num = jdbcTemplate.queryForInt("select count(*) from PROJECT " )
		
		
	}
	
	public List queryForList(){
		jdbcTemplate.queryForList("select * from PROJECT ")
	}
}
