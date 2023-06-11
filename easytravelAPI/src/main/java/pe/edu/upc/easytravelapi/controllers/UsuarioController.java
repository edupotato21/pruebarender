package pe.edu.upc.easytravelapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.easytravelapi.dtos.UsuarioDTO;
import pe.edu.upc.easytravelapi.entities.Usuarios;
import pe.edu.upc.easytravelapi.services.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;
    @PostMapping
    public void insert(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuarios u = m.map(dto, Usuarios.class);
        uS.insert(u);
    }
    @GetMapping
    public List<UsuarioDTO> list(){
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        uS.delete(id);
    }
    @GetMapping("/{id}")
    public UsuarioDTO listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.listId(id), UsuarioDTO.class);
        return dto;
    }
    @PutMapping
    public void goUpdate(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuarios u = m.map(dto, Usuarios.class);
        uS.insert(u);
    }
}