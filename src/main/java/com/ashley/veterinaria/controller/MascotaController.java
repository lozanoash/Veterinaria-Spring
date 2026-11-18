package com.ashley.veterinaria.controller;

import com.ashley.veterinaria.model.Mascota;
import com.ashley.veterinaria.repository.MascotaRepository;
import com.ashley.veterinaria.service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Mascota")
public class MascotaController {
    private final MascotaRepository mascotaRepository;


    private MascotaService mascotaService;
    public MascotaController(MascotaService mascotaService1, MascotaRepository mascotaRepository){
        this.mascotaService = mascotaService1;
        this.mascotaRepository = mascotaRepository;
    }
    @GetMapping
    public List<Mascota> verTodos(){
        return  mascotaService.traerTodos();
    }

    //TRAER UNO
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> traerUno(@PathVariable int id){
        return mascotaService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Mascota> guardar(@RequestBody  Mascota mascota){
        Mascota nuevoMascota = mascotaService.guardar(mascota);
        return new ResponseEntity<>(nuevoMascota, HttpStatus.CREATED);
    }

}
