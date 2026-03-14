package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
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

        if(newPropId == null) {
            throw new NullPointerException("newPropId returned null pointer...sorry.");
        } else {
            return getPropertyById(newPropId);
        }
    }

    @Override
    public Property getPropertyById(int propId) {
        Property property = null;
        String sql = "SELECT * FROM property WHERE prop_id = ?;";
        SqlRowSet result = template.queryForRowSet(sql, propId);
        if(result.next()) {
            property = mapRowToProperty(result);
        }
        if(property == null) {
            throw new NullPointerException("Oops! Property is null...");
        } else {
            return property;
        }
    }

    @Override
    public Property getPropertyByAddress(String address, String town) {
        Property property = null;
        String sql = "SELECT * FROM property WHERE address = ? AND town = ?;";
        SqlRowSet result = template.queryForRowSet(sql, address, town);
        if(result.next()) {
            property = mapRowToProperty(result);
            return property;
        } else {
            return null;
            //throw new NullPointerException("Oops! Property is null...");
        }
    }

    @Override
    public Property getPropertyByPidOrPin(String pin, String pid) {
        Property property;
        String sql = "SELECT * FROM property WHERE pid = ? OR pin = ?;";
        SqlRowSet result = template.queryForRowSet(sql, pid, pin);
        if(result.next()) {
            property = mapRowToProperty(result);
            return property;
        } else {
            return null;
            //throw new NullPointerException("Oops! Property is null...");
        }
    }

    @Override
    public List<Property> getPropertiesByJob(int jobId) {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT * FROM property " +
                "JOIN job_card_property ON property.prop_id = job_card_property.prop_id " +
                "WHERE job_id = ?;";
        SqlRowSet results = template.queryForRowSet(sql, jobId);
        return null;
    }

    @Override
    public Property editProperty(Property property) {
        String sql = "UPDATE property SET owner_first_name = ?, owner_last_name = ?, address = ?, town = ?, " +
                "state = ?, zip = ?, county = ?, deed_1 = ?, deed_2 = ?, deed_3 = ?, map_1 = ?, map_2 = ?, " +
                "map_3 = ? perimeter = ?, acreage = ?, drive_time = ?, subdivision = ?, pid = ?, pin = ?, " +
                "township = ?, lot_num = ?, prop_notes = ? WHERE prop_id = ?;";
        template.update(sql, property.getOwnerFirstName(), property.getOwnerLastName(), property.getAddress(),
                property.getTown(), property.getState(), property.getZip(), property.getCounty(), property.getDeed1(),
                property.getDeed2(), property.getDeed3(), property.getMap1(), property.getMap2(), property.getMap3(),
                property.getPerimeter(), property.getAcreage(), property.getDriveTime(), property.getSubdivision(),
                property.getPid(), property.getPin(), property.getTownship(), property.getLotNum(),
                property.getPropNotes());

        return getPropertyById(property.getPropId());
    }

    @Override
    public boolean deleteProperty(int propId) {
        boolean success = false;
        String sql = "DELETE FROM property WHERE prop_id = ?;";
        int linesUpdated = template.update(sql, propId);
        if(linesUpdated == 1) {
            success = true;
        }
        return success;
    }

    private Property mapRowToProperty(SqlRowSet rowSet) {
        Property property = new Property();
        property.setPropId(rowSet.getInt("prop_id"));
        property.setOwnerFirstName(rowSet.getString("owner_first_name"));
        property.setOwnerLastName(rowSet.getString("owner_last_name"));
        property.setAddress(rowSet.getString("address"));
        property.setTown(rowSet.getString("town"));
        property.setState(rowSet.getString("state"));
        property.setZip(rowSet.getString("zip"));
        property.setCounty(rowSet.getString("county"));
        property.setDeed1(rowSet.getString("deed_1"));
        property.setDeed2(rowSet.getString("deed_2"));
        property.setDeed3(rowSet.getString("deed_3"));
        property.setMap1(rowSet.getString("map_1"));
        property.setMap2(rowSet.getString("map_2"));
        property.setMap3(rowSet.getString("map_3"));
        property.setPerimeter(rowSet.getInt("perimeter"));
        property.setAcreage(rowSet.getDouble("acreage"));
        property.setDriveTime(rowSet.getTime("drive_time"));
        property.setSubdivision(rowSet.getString("subdivision"));
        property.setPid(rowSet.getString("pid"));
        property.setPin(rowSet.getString("pin"));
        property.setTownship(rowSet.getString("township"));
        property.setLotNum(rowSet.getString("lot_num"));
        property.setPropNotes(rowSet.getString("prop_notes"));
        return property;
    }
}
