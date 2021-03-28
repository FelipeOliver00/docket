package br.com.felipe.docket.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.felipe.docket.model.Cartorio;
import br.com.felipe.docket.repository.CartorioRepository;

@Controller
public class CartorioController {
	
	@Autowired
	private CartorioRepository repository;
	
	@GetMapping("/cartorios")
	public ModelAndView cartorios() {
	List<Cartorio> listCartorios= repository.findAll();
	ModelAndView modelAndView =	new ModelAndView("cartorios");
	modelAndView.addObject("cartoriosz", listCartorios);
	return modelAndView;
	}
	
	@PostMapping("/cartorios")
	public String save(@Valid Cartorio cartorio, BindingResult result) {
		if(result.hasErrors()) return "new_cartorio";
		repository.save(cartorio);
		return "redirect:cartorios"; 
	}
	
	@RequestMapping("/new_cartorio")
	public String form_new_cartorio(Cartorio cartorios) {
		return "new_cartorio";
	}
	
	@RequestMapping("/cartorios/delete/{id}")
	public String deleteCartorio(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/cartorios";
	}
	
	@GetMapping("cartorios/{id}")
	public ModelAndView editCartorio(@PathVariable Long id) {
		Optional<Cartorio> cartorio = repository.findById(id);
		ModelAndView modelAndView = new ModelAndView("edit_cartorio");
		modelAndView.addObject("cartoriosz", cartorio);
		return modelAndView;
	}
	
	@PostMapping("cartorios/update")
	public String updateCartorio(@Valid Cartorio cartorio, BindingResult result) {
		if(result.hasErrors()) return "edit_cartorio";
		repository.save(cartorio);
		return "redirect:/cartorios";
	}
	
}
