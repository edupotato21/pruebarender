package pe.edu.upc.easytravelapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.easytravelapi.dtos.ServiciosDTO;
import pe.edu.upc.easytravelapi.entities.Servicios;
import pe.edu.upc.easytravelapi.services.IServiciosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicios")
public class ServiciosController {

    @Autowired
    private IServiciosService sS;

    @PostMapping
    public void registrar (@RequestBody ServiciosDTO dto){
        ModelMapper m = new ModelMapper();
        Servicios s=m.map(dto, Servicios.class);
        sS.insertar(s);
    }

    @PutMapping
    public void modificar (@RequestBody ServiciosDTO dto) {
        ModelMapper m= new ModelMapper();
        Servicios s=m.map(dto,Servicios.class);
        sS.insertar(s);

    }
    @DeleteMapping
    public void  eliminar(@PathVariable("id")Integer id){sS.eliminar(id);}
    @GetMapping
    public List<ServiciosDTO> listar() {
        return sS.listar().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ServiciosDTO.class);

        }).collect(Collectors.toList());
    }

}