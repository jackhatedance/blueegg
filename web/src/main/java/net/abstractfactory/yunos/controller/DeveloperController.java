package net.abstractfactory.yunos.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/developer")
@Secured("ROLE_DEVELOPER")
public class DeveloperController extends BaseController{
	@RequestMapping("/")
	public String index(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		
		setHeaderModel(model);
		
		return "developer/index";
	}
}
