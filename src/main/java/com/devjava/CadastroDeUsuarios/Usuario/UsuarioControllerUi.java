package com.devjava.CadastroDeUsuarios.Usuario;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/usuarios/ui")
public class UsuarioControllerUi {

    private final UsuarioService usuarioService;

    public UsuarioControllerUi(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "listarUsuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletaUsuarioPorId(@PathVariable Long id){
       usuarioService.deletarUsuarioPorId(id);
       return "redirect:/usuarios/ui/listar";
    }
    @GetMapping("/listar/{id}")
    public String listarUsuarioPorId(@PathVariable Long id, Model model){
        UsuarioDTO usuario = usuarioService.listarUsuarioPorID(id);
        if (usuario != null){
            model.addAttribute("usuario", usuario);
            return "detalhesUsuario";
        } else {
            model.addAttribute("mensagem", "Usuário Não encontrado");
            return "listarUsuarios";
        }

    }
    @GetMapping("/adicionar")
    public String mostrarFormularioCriarUsuario( Model model){
        model.addAttribute("usuario", new UsuarioDTO());
        return "adicionarUsuario";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute UsuarioDTO usuario, RedirectAttributes redirectAttributes){
        usuarioService.criarUsuario(usuario);
        redirectAttributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso");
        return "redirect:/usuarios/ui/listar";
    }
    @GetMapping("/alterar/{id}")
    public String mostrarFormularioAlterarUsuario(@PathVariable Long id, Model model) {
        UsuarioDTO usuario = usuarioService.listarUsuarioPorID(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "alterarUsuario"; // essa será sua nova view
        } else {
            model.addAttribute("mensagem", "Usuário não encontrado");
            return "redirect:/usuarios/ui/listar";
        }
    }




}
