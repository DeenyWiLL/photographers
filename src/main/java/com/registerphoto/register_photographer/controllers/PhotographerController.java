package com.registerphoto.register_photographer.controllers;

import com.registerphoto.register_photographer.models.Photographer;
import com.registerphoto.register_photographer.repositories.PhotographerRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/photographers")
public class PhotographerController {

    private final PhotographerRepository photographerRepository;

    public PhotographerController(PhotographerRepository photographerRepository) {
        this.photographerRepository = photographerRepository;
    }

    @PostMapping
    public ResponseEntity<Photographer> createPhotographer(@Valid @RequestBody Photographer photographer) {
        Photographer savedPhotographer = photographerRepository.save(photographer);
        return ResponseEntity.ok(savedPhotographer);
    }

    @GetMapping
    public ResponseEntity<List<Photographer>> getAllPhotographer() {
        List<Photographer> photographers = photographerRepository.findAll();
        return ResponseEntity.ok(photographers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Photographer> getPhotographerById(@PathVariable Long id) {
        Optional<Photographer> photographer = photographerRepository.findById(id);
        return photographer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Photographer> updatePhotographer(@PathVariable Long id, @Valid @RequestBody Photographer updatePhotographer) {
        return photographerRepository.findById(id).map(photographer -> {
            photographer.setFullName(updatePhotographer.getFullName());
            photographer.setCity(updatePhotographer.getCity());
            photographer.setPostalCode(updatePhotographer.getPostalCode());
            photographer.setContact(updatePhotographer.getContact());
            photographer.setEmail(updatePhotographer.getEmail());
            photographer.setSpecializations(updatePhotographer.getSpecializations());
            Photographer saved = photographerRepository.save(photographer);
            return ResponseEntity.ok(saved);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhotographer(@PathVariable Long id) {
        if (photographerRepository.existsById(id)) {
            photographerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
