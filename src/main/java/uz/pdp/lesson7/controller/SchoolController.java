package uz.pdp.lesson7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson7.entity.School;
import uz.pdp.lesson7.payload.SchoolDto;
import uz.pdp.lesson7.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    SchoolService service;

    @GetMapping("/all")
    public HttpEntity<?> getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }

    @GetMapping("/byId/{id}")
    public HttpEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.status(200).body(service.getById(id));
    }

    @DeleteMapping("/deleteById/{id}")
    public HttpEntity<?> delete(@PathVariable("id") Integer id){
      return ResponseEntity.status(200).body(service.delete(id));
    }

    @PostMapping("/saveOrEdit")
    public HttpEntity<?> saveOrEdit(@RequestBody SchoolDto schoolDto){
      return ResponseEntity.status(200).body(service.saveOrEdit(schoolDto));
    }
}
