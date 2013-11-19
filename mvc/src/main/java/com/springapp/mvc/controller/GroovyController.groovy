package com.springapp.mvc.controller
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.springapp.mvc.bmo.UserService



@Controller
class GroovyController {
	
	
	public UserService  uservice;
	
	@Autowired
	public GroovyController(UserService us2){
	
		this.uservice = us2 ;
	}
	
	@RequestMapping("/hello")
	public @ResponseBody String getStatus() {
		return "Hello World! " 
		
	}
	
	@RequestMapping("/bingo")
	public @ResponseBody String echoBingo(){
		return " hello " + uservice.bingo()
	}
}
