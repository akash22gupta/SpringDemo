package com.example.demo;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.model.Data;
import com.example.demo.repository.DataRepository;

import antlr.collections.List;

@Controller
public class GreetingController {

//	dependency injection
	@Autowired
	DataRepository dataRepository;
	
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
    	Data d = new Data();
    	d.setId(greeting.getId());
    	d.setContent(greeting.getContent());
    	Data newd = dataRepository.findById(d.getId()).orElse(null);
    	System.out.println(newd);
    	dataRepository.save(d);
        return "result";
    }

        
    // Get All greetings
    @PutMapping("/greeting")
    	   public void UpdateGreeting(@ModelAttribute Greeting greeting) {
    	    	Data d = new Data();
    	    	d.setId(greeting.getId());
    	    	d.setContent(greeting.getContent());
    	    	System.out.println(d.getId());
    	Data newd = dataRepository.findById(d.getId()).orElse(null);
    	newd.setContent(d.getContent());
    	dataRepository.save(newd);
    }


    
//    public static final String FIND_PROJECTS = "SELECT projectId, projectName FROM projects";
//
//    @Query(value = FIND_PROJECTS, nativeQuery = true)
//    public List<Object[]> findProjects();
}