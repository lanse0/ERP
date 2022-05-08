package com.qf.sys.po;

/**
 * FileName: Province
 * Author: HWang
 * Date:2022/5/5 10:12
 */
public class Region {
    private int id;
    private String regionName;  //地区名
    private String regionShortName;//地区缩写
    private String regionCode;//地区编码
    private Region parentReg;//父级地区
    private int regionLevel;//地区级别
    private int parentId;//父id

    public Region() { }
    public Region(int id) {this.id=id; }
    public Region(String regionName, String regionShortName, String regionCode, Region parentReg, int regionLevel) {
        this.regionName = regionName;
        this.regionShortName = regionShortName;
        this.regionCode = regionCode;
        this.parentReg = parentReg;
        this.regionLevel = regionLevel;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                ", regionShortName='" + regionShortName + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", parentReg=" + parentReg +
                ", regionLevel=" + regionLevel +
                '}';
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionShortName() {
        return regionShortName;
    }

    public void setRegionShortName(String regionShortName) {
        this.regionShortName = regionShortName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Region getParentReg() {
        return parentReg;
    }

    public void setParentReg(Region parentReg) {
        this.parentReg = parentReg;
    }

    public int getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(int regionLevel) {
        this.regionLevel = regionLevel;
    }
}
