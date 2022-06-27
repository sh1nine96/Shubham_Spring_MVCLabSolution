package com.gl.javafsd.studentmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {

	@RequestMapping("/")
	public String handleHomePage() {

		return "homepage";
	}

}
