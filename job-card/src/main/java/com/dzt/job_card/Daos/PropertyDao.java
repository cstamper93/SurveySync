package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.Property;

import java.util.List;

public interface PropertyDao {

    // CREATE, READ, UPDATE, DELETE

    Property addNewProperty(Property property);

    Property getPropertyById(int propId);

    List<Property> getPropertiesByJob(int jobId);

    Property editProperty(Property property);

    boolean deleteProperty(int propId);
}
