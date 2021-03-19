package com.stackcode.gestao.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stackcode.gestao.model.Produto;

@Controller
public class ProdutosController {

	@RequestMapping("/produtos/novo")
	public String novo() {

		return "produtos/CadastroProduto";
	}

	@RequestMapping(value = "/produtos/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Produto produto, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("mensagem","erro no formulario");
			System.out.println("tem erro");
			
			return "produtos/CadastroProduto";
		}
		System.out.println("Nome produto"+produto.getNome());
		System.out.println(produto.getSku());

		return "redirect:produtos/novo";
	}
}
