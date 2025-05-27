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
    private String deed1;
    private String deed2;
    private String deed3;
    private String map1;
    private String map2;
    private String map3;
    private int perimeter;
    private double acreage;
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

    public String getDeed1() {
        return deed1;
    }

    public void setDeed1(String deed1) {
        this.deed1 = deed1;
    }

    public String getDeed2() {
        return deed2;
    }

    public void setDeed2(String deed2) {
        this.deed2 = deed2;
    }

    public String getDeed3() {
        return deed3;
    }

    public void setDeed3(String deed3) {
        this.deed3 = deed3;
    }

    public void setMap1(String map1) {
        this.map1 = map1;
    }

    public String getMap2() {
        return map2;
    }

    public void setMap2(String map2) {
        this.map2 = map2;
    }

    public String getMap3() {
        return map3;
    }

    public void setMap3(String map3) {
        this.map3 = map3;
    }

    public String getMap1() {
        return map1;
    }


    public int getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }

    public double getAcreage() {
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
