package uz.pdp.lesson7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson7.payload.StudentDto;
import uz.pdp.lesson7.repository.StudentRepo;
import uz.pdp.lesson7.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("/all")
    public HttpEntity<?> getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }

    @GetMapping("/byId/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.getById(id));
    }

    @DeleteMapping("/deleteById/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.delete(id));
    }

    @PostMapping("/saveOrEdit")
    public HttpEntity<?> saveOrEdit(@RequestBody StudentDto dto){
        return ResponseEntity.status(200).body(service.saveOrEdit(dto));
    }
}
