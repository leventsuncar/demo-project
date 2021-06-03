package com.demo.api.controllers;

import com.demo.core.results.ErrorDataResult;
import com.demo.entities.dtos.FilmDto;
import com.demo.service.abstracts.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
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

    @GetMapping("/films")
    public String getAll(Model model) {
        List<FilmDto> films = filmService.getAll().getData();
        model.addAttribute("films",films);
        return "films";

    }

    @GetMapping("/getbyname")
    public String findByName(@Valid @RequestParam(value = "name",required = false) String name, Model model) {
        try {
            FilmDto film = filmService.findByName(name).getData();
            model.addAttribute("film",film);
            return "getbyname";
        }
        catch (IllegalArgumentException e){
            throw e;
        }

    }

    @GetMapping("/getbyactorname")
    public String findByActorName(@Valid @RequestParam(value = "name",required = false) String name, Model model) {

        try {
            List<FilmDto> films = filmService.findByActorName(name).getData();
            //servisteki metodlarım DataResult dönüyor. Bana sadece data lazım.
            model.addAttribute("films",films);
            return "getbyactorname";
        }
        catch (IllegalArgumentException e){
            throw e;
        }

    }

    @GetMapping("/getbygenrename")
    public String findByGenreName(@Valid @RequestParam(value = "name") String name, Model model) {

        try {
            List<FilmDto> films = filmService.findByGenreName(name).getData();
            //servisteki metodlarım DataResult dönüyor. Bana sadece data lazım.
            model.addAttribute("films",films);
            return "getbygenrename";
        }
        catch (IllegalArgumentException e){
            throw e;
        }
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
