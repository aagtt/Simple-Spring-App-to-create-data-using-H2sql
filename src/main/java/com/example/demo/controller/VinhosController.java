package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.TipoVinho;
import com.example.demo.model.Vinho;
import com.example.demo.repository.Vinhos;

@Controller
public class VinhosController {
	@Autowired
	private Vinhos vinhos;
	
	@GetMapping("/vinhos/novo")
		public ModelAndView novo(Vinho vinho) {
			ModelAndView mv = new ModelAndView("vinho/cadastro-vinho");
			mv.addObject("tipos", TipoVinho.values()); // coloca esse array de tipovinhos disponivek para "tipos" para acessar no html
			return mv;
		}
		
		@PostMapping("/vinhos/novo")
		public ModelAndView salvar(@Valid Vinho vinho, BindingResult result){
			
			if(result.hasErrors()){
				return novo(vinho);
			}else{
				vinhos.save(vinho);
					return new ModelAndView("redirect:/vinhos/novo");
		}}
}
