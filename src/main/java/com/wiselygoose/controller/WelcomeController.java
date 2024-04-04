package com.wiselygoose.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	@GetMapping("/")
	public String welcome(@RequestParam(name = "name", defaultValue = "홍길동") String name, Model model) {
		model.addAttribute("name", name);

		return "welcome";
	}

}
