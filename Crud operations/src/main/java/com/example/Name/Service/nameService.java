package com.example.Name.Service;

import com.example.Name.Model.name;
import com.example.Name.Repository.nameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class nameService {

    @Autowired
    public nameRepository namerepo;

    public List<name> getAllnames() {
        return namerepo.findAll();

    }

    public Optional<name> getNames(String namesid) {

        return namerepo.findById(namesid);
    }

    public name Addnames(name names) {

        return namerepo.save(names);
    }

    public String updateNames(name names, String namesid) {
        Optional<name> namesData = namerepo.findById(namesid);
        if (namesData.isPresent()) {
            name nam = namesData.get();
            nam.setNamesName(names.getNamesName());
            nam.setNamesGender(names.getNamesGender());
            nam.setLocation(names.getLocation());
            this.namerepo.save(nam);
            return "Names details are updated";
        } else {
            return "Names detail is not updated";
        }


    }

    public String deleteNames(String namesid) {
        namerepo.deleteById(namesid);
        return namesid + " was deleted successfully";
    }

    public List<name> getnames(String namesemail) {

        return namerepo.findBynamesEmail(namesemail);
    }
}
