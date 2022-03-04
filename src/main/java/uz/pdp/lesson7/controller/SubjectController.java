package uz.pdp.lesson7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson7.entity.Subject;
import uz.pdp.lesson7.payload.SubjectDto;
import uz.pdp.lesson7.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService service;

    @GetMapping("/all")
    public HttpEntity<?> getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }

    @GetMapping("/byId/{id}")
    public HttpEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.status(200).body(service.getById(id));
    }

    @PostMapping("/saveOrEdit")
    public HttpEntity<?> saveOrEdit(@RequestBody SubjectDto subjectDto){
        return ResponseEntity.status(200).body(service.saveOrEdit(subjectDto));
    }

    @DeleteMapping("/deleteById/{id}")
    public HttpEntity<?> delete(@PathVariable("id") Integer id){
        return ResponseEntity.status(200).body(service.delete(id));
    }

}
