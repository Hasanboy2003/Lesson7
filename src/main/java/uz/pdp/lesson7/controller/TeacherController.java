package uz.pdp.lesson7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson7.payload.TeacherDto;
import uz.pdp.lesson7.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService service;


    @GetMapping("/all")
    public HttpEntity<?> getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }

   @GetMapping("/byId/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.getById(id));
   }

   @DeleteMapping("/byId/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.delete(id));
   }

   @PostMapping("/saveOrEdit")
    public HttpEntity<?> saveOrEdit(@RequestBody TeacherDto dto){
        return ResponseEntity.status(200).body(service.saveOrEdit(dto));
   }
}
