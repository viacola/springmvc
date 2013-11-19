package com.springapp.mvc.controller


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;



@Controller
class HelloController {
	@RequestMapping("/helloGroovy")
	public @ResponseBody String getCode() {
		return "Hello World! Groovy";
	}
}
