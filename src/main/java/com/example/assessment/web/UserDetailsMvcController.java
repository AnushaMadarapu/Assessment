package com.example.assessment.web;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;

import com.example.assessment.exception.RecordNotFoundException;
import com.example.assessment.model.UserDetails;
import com.example.assessment.service.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping("/")
public class UserDetailsMvcController  implements WebMvcConfigurer
{
	@Autowired
	UserDetailsService service;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
	}

	@RequestMapping
	public String getAllUsers(Model model) 
	{
		List<UserDetails> list = service.getAllUsers();

		model.addAttribute("UserDetails", list);
		return "list-userdetails";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editUserDetailsById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			UserDetails entity = service.getUserDetailsById(id.get());
			model.addAttribute("user", entity);
		} else {
			model.addAttribute("user", new UserDetails());
		}
		return "add-edit-user";
	}
	
	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String createOrUpdateUser(@Valid UserDetails user, BindingResult bindingResult) 
	{
		if(bindingResult.hasErrors()){
			return "add-edit-user";
		}else{
			service.createOrUpdateUser(user);
			return "redirect:/index";
		}
		
	}
	
}
