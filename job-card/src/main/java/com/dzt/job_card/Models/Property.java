package com.dzt.job_card.Models;

import java.sql.Time;
import java.util.List;

public class Property {

    private int propId;
    private String ownerFirstName;
    private String ownerLastName;
    private String address;
    private String town;
    private String state;
    private String zip;
    private String county;
    private List<String> deed;
    private List<String> map;
    private int perimeter;
    private int acreage;
    private Time driveTime;
    private String subdivision;
    private String pid;
    private String pin;
    private String township;
    private String lotNum;
    private String propNotes;

    public Property(){}

    public int getPropId() {
        return propId;
    }

    public void setPropId(int propId) {
        this.propId = propId;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public List<String> getDeed() {
        return deed;
    }

    public void setDeed(List<String> deed) {
        this.deed = deed;
    }

    public List<String> getMap() {
        return map;
    }

    public void setMap(List<String> map) {
        this.map = map;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public Time getDriveTime() {
        return driveTime;
    }

    public void setDriveTime(Time driveTime) {
        this.driveTime = driveTime;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getLotNum() {
        return lotNum;
    }

    public void setLotNum(String lotNum) {
        this.lotNum = lotNum;
    }

    public String getPropNotes() {
        return propNotes;
    }

    public void setPropNotes(String propNotes) {
        this.propNotes = propNotes;
    }
}
