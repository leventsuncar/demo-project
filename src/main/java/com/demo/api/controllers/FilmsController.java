package com.demo.api.controllers;

import com.demo.core.results.ErrorDataResult;
import com.demo.entities.Film;
import com.demo.entities.dtos.FilmDto;
import com.demo.service.abstracts.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/films")
public class FilmsController {


    FilmService filmService;

    @Autowired
    public FilmsController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody FilmDto filmDto) {

        return ResponseEntity.ok(filmService.add(filmDto));

    }

    @DeleteMapping("/deletebyname")
    public ResponseEntity<?> deleteByFilmName(@Valid @RequestParam String name) {

        return ResponseEntity.ok(filmService.deleteByFilmName(name));

    }

    @PutMapping("/updatebyname")
    public ResponseEntity<?> updateByFilmName(@Valid @RequestParam String name) {

        //yapılacak

        return null;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {

        return ResponseEntity.ok(filmService.getAll());

    }

    @GetMapping("/getbyname")
    public ResponseEntity<?> findByName(@Valid @RequestParam String name) {

        return ResponseEntity.ok(filmService.findByName(name));

    }

    @GetMapping("/getbyactorname")
    public ResponseEntity<?> findByActorName(@Valid @RequestParam String name) {

        return ResponseEntity.ok(filmService.findByActorName(name));

    }

    @GetMapping("/getbygenrename")
    public ResponseEntity<?> findByGenreName(@Valid @RequestParam String genreName) {

        return ResponseEntity.ok(filmService.findByGenreName(genreName));

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
        return errors;
    }

}
