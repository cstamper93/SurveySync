package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcPropertyDao implements PropertyDao {

    private final JdbcTemplate template;

    JdbcPropertyDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Property addNewProperty(Property property) {
        String sql = "INSERT INTO property (owner_first_name, owner_last_name, address, town, state, zip, " +
                "county, deed_1, deed_2, deed_3, map_1, map_2, map_3, perimeter, acreage, drive_time, subdivision, " +
                "pid, pin, township, lot_num, prop_notes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?) RETURNING prop_id;";
        Integer newPropId = template.queryForObject(sql, Integer.class, property.getOwnerFirstName(),
                property.getOwnerLastName(), property.getAddress(), property.getTown(), property.getState(),
                property.getZip(), property.getCounty(), property.getDeed1(), property.getDeed2(), property.getDeed3(),
                property.getMap1(), property.getMap2(), property.getMap3(), property.getPerimeter(),
                property.getAcreage(), property.getDriveTime(), property.getSubdivision(), property.getPid(),
                property.getPin(), property.getTownship(), property.getLotNum(), property.getPropNotes());

        return null;
    }

    @Override
    public Property getPropertyById(int propId) {
        Property property = null;
        String sql = "SELECT * FROM property WHERE prop_id = ?;";
        SqlRowSet result = template.queryForRowSet(sql, propId);
        if(result.next()) {
            //property = mapRowToProperty(result);
        }
        return null;
    }

    @Override
    public List<Property> getPropertiesByJob(int jobId) {
        return null;
    }

    @Override
    public Property editProperty(Property property) {
        return null;
    }

    @Override
    public boolean deleteProperty(int propId) {
        return false;
    }

    private Property mapRowToProperty(SqlRowSet rowSet) {
        return null;
    }
}
