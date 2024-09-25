package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout")
public class LayoutController {

		@GetMapping({"/exLayout1" , "/exLayout2", "/exLayout3", "/fragment2", "/basic" , "/exSidebar"})
		public void ex1() {
			
		}
		
	
}
