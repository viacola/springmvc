package com.springapp.mvc.controller

import com.springapp.mvc.bmo.UserService
import groovy.json.*
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
class UserRest {
	
	@Autowired
	UserService userService
	
	
	
	@RequestMapping("/user")
	public @ResponseBody String getUser() {
		return """
        {
            "name":"bingo",
            "age":34,
            "address":"nanjing"
        }
        """;
	}
	
	@RequestMapping("/insertUser")
	public @ResponseBody String insertUser() {
		userService.insertUser()
	}
	
	
	@RequestMapping("/user2")
	public @ResponseBody String getUser2() {
		def user = new JsonBuilder();
		def test ="AAAA"
		user {
			name 'bingo'
			age  34
			credit  test
			address(
					city: 'nanjing',
					country: 'china',
					zip: 210012
				)  
			married true
			
			departments 'TAP','Design dept.','Project Manager dept.'
		}
		
		//user.pet name: 'dog'
		
		user.toPrettyString()
	}
	
	@RequestMapping("/user3")
	public @ResponseBody String queryUser3() {
		
		def user = new JsonBuilder();
		user.setContent(userService.queryUser())
		
		user.toPrettyString()
	}

	@RequestMapping("/queryUserForJt")
	public @ResponseBody String queryUserForJt() {
		
		def user = new JsonBuilder();
		user num :  userService.queryUser4Jt()
		
		user.toPrettyString()
	}
	
	@RequestMapping("/queryForList")
	public @ResponseBody String queryForList() {
		
		def project = new JsonBuilder();
		project projectList :  userService.queryForList()
		
		project.toPrettyString()
	}
	
}
