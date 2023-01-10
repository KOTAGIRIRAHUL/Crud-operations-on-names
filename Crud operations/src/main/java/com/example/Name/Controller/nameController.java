package com.example.Name.Controller;

import com.example.Name.Model.name;
import com.example.Name.Service.nameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/name")
@RestController
public class nameController {

    @Autowired
    public nameService nameService;

    @GetMapping("/list")
    public ResponseEntity<List<name>> getAllnames()
    {
        try {
            return new ResponseEntity<>(nameService.getAllnames(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<name>> getnames(@PathVariable("id") String namesid)
    {
        try {
            return new ResponseEntity<>(nameService.getNames(namesid),HttpStatus.FOUND);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/names/{nemail}")
    public ResponseEntity<List<name>> getNames(@PathVariable("nemail") String namesemail)
    {
        try
        {
            return new ResponseEntity<>(nameService.getnames(namesemail),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/list/add")
    public ResponseEntity<name> Addnames(@RequestBody name name)
    {
        try
        {
            return new ResponseEntity<>(nameService.Addnames(name),HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/list/{id}")
    public ResponseEntity<String> updateNames(@RequestBody name name, @PathVariable("id") String namesid)
    {
        try
        {
            return new ResponseEntity<>(nameService.updateNames(name,namesid),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<String> deleteNames(@PathVariable("id") String namesid)
    {
        try
        {
            nameService.deleteNames(namesid);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(namesid+" was deleted",HttpStatus.OK);
    }
}
