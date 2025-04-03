package com.HelloHuman1.RestController;





import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController 
public class HumanController {
	//@RequestMapping("/")
	//public String greeting () {
		//return "Hello Human ";
	//} 
	
	@RequestMapping("/")
	public String personalgreeting (@RequestParam(value="name", required=false)  String name ,
									//@RequestParam(value="times", required=false) int times,
									@RequestParam(value="lastname", required=false) String lastName ) {
		if(name!=null && lastName!=null) {
			return "Hello "+ name + " "+lastName;
		}else {
			return "Hello Humain";
		}
	} 
	
	
	
  
}
