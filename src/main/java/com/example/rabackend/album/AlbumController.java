package com.example.rabackend.album;

import com.example.rabackend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://ra-frontend.herokuapp.com")
public class AlbumController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AlbumRepository albumRepository;

    @PostMapping("/users/{userId}/albums")
    public ResponseEntity<Album> createAlbum(
            @PathVariable(value = "userId") Long userId,
            @RequestBody Album albumRequest
    ) {
        Album album = userRepository.findById(userId)
                .map(user -> {
                    albumRequest.setUser(user);

                    return albumRepository.save(albumRequest);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Not found!"));

        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

}
