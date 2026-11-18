package com.ashley.veterinaria.service;

import com.ashley.veterinaria.model.Mascota;
import com.ashley.veterinaria.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    private MascotaRepository mascotaRepository;
    public MascotaService(MascotaRepository mascotaRepository1){
        this.mascotaRepository = mascotaRepository1;
    }
    //TRAER TODOS
    public List<Mascota> traerTodos(){
        return mascotaRepository.findAll();
    }

    //TRAER UNO
    public Optional<Mascota> traerUno(int id){
        return mascotaRepository.findById(id);
    }

    //GUARDAR
    public Mascota  guardar (Mascota mascota){
        return mascotaRepository.save(mascota);
    }
}
