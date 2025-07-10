package com.dzt.job_card.Controllers;

import com.dzt.job_card.Daos.PropertyDao;
import com.dzt.job_card.Models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PropertyController {

    @Autowired
    PropertyDao propertyDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("add-property")
    public Property addNewProperty(@RequestBody Property property) {
        return propertyDao.addNewProperty(property);
    }

    @GetMapping("property/{id}")
    public Property getPropertyById(@PathVariable int id) {
        return propertyDao.getPropertyById(id);
    }

    @GetMapping("properties/{id}")
    public List<Property> getPropertiesByJob(@PathVariable int jobId) {
        return propertyDao.getPropertiesByJob(jobId);
    }

    @PutMapping("property")
    public Property fixProperty(@RequestBody Property fixedProperty) {
        return propertyDao.editProperty(fixedProperty);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("property/{id}")
    public boolean removeProperty(@PathVariable int id) {
        return propertyDao.deleteProperty(id);
    }

}
