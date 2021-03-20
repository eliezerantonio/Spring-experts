package com.stackcode.gestao.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stackcode.gestao.model.Produto;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProdutosController {

    @RequestMapping("/produtos/novo")
    public String novo(Produto produto) {
      
        return "produtos/CadastroProduto";
    }

    @RequestMapping(value = "/produtos/novo", method = RequestMethod.POST)
    public String cadastrar(@Valid Produto produto, BindingResult result, Model model, RedirectAttributes attributes) {

        if (result.hasErrors()) {
          //casjo haja erro retornar pagina novo
            return novo(produto);
        }

        //TODO: salvar no banco de dados
        //  addFlashAttribute fara ele permanecer mesmo apos o redirect, cria uma sessao curta
        attributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso");
        System.out.println("Nome produto" + produto.getNome());
        System.out.println(produto.getSku());

        return "redirect:/produtos/novo";
    }
    @RequestMapping("produtos/cadastro")
    public String  cadastro(){
           return "produtos/cadastro-produto";
    }
}
