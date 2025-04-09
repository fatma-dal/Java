package com.NinjaGoldGame.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaController {
	@GetMapping("/")
	public String index (HttpSession session) {
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold", 0);
		}
		return "index.jsp";
	}
	
	@PostMapping("/form")
	public String form(@RequestParam(value="name") String name,HttpSession session,RedirectAttributes flash) {
		Random random =new Random();
		ArrayList<String> earns =(ArrayList<String>)session.getAttribute("earns");
		ArrayList<String> lose =(ArrayList<String>)session.getAttribute("lose");
		String msg="";
		String msgF="";
		Date date=new Date();
		
		if(earns==null) {
			earns=new ArrayList<String>();
		}
		
		if(lose==null) {
			lose=new ArrayList<String>();
		}
		
		if(name.equals("farm")) {
			int numb=random.nextInt(11)+10;
			session.setAttribute("gold",(int)session.getAttribute("gold")+numb);
			msg="You entered a farm and earned "+numb+" gold.("+date.toString()+")";
			earns.add(msg);
		}
		if(name.equals("cave")) {
			int numb=random.nextInt(6)+5;
			session.setAttribute("gold",(int)session.getAttribute("gold")+numb);
			msg="You entered a cave and earned "+numb+" gold.("+date.toString()+")";
			earns.add(msg);
		}
		if(name.equals("house")) {
			int numb=random.nextInt(4)+2;
			session.setAttribute("gold",(int)session.getAttribute("gold")+numb);
			msg="You entered a house and earned "+numb+" gold.("+date.toString()+")";
			earns.add(msg);
		}
		if(name.equals("quest")) {
			int numb=random.nextInt(-50,50);
			session.setAttribute("gold",(int)session.getAttribute("gold")+numb);
			if(numb>=0) {
			msg="You entered a quest and earned "+numb+" gold.("+date.toString()+")";
			earns.add(msg);
		}else {
			msgF=("You failed a quest and lost "+numb+" gold.Ouch.("+date.toString()+")");
			lose.add(msgF);
		}
		}
		
		if(name.equals("spa")) {
			int numb=random.nextInt(-20,-5);
			session.setAttribute("gold",(int)session.getAttribute("gold")+numb);
			msgF=("You failed a spa and lost "+numb+" gold.Ouch.("+date.toString()+")");
			lose.add(msgF);
		}
		
		session.setAttribute("earns", earns);
		session.setAttribute("lose", lose);
		
		if(name.equals("reset")) {
			session.invalidate();
		}

		
		
		return "redirect:/";
	}
}
