package com.registerphoto.register_photographer.repositories;

import com.registerphoto.register_photographer.models.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Long> {
}


