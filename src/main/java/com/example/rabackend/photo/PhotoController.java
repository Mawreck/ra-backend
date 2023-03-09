package com.example.rabackend.photo;

import com.example.rabackend.album.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PhotoController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    PhotoRepository photoRepository;

    @PostMapping("/albums/{albumId}/photos")
    public ResponseEntity<Photo> createPhoto(
            @PathVariable(value = "albumId") Long albumId,
            @RequestBody Photo photoRequest
    ) {
        Photo photo = albumRepository.findById(albumId)
                .map(album -> {
                    photoRequest.setAlbum(album);

                    return photoRepository.save(photoRequest);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Not found!"));

        return new ResponseEntity<>(photo, HttpStatus.CREATED);
    }

}
