package com.simoruty.aoc2020;

public class Passport {

    private int byr; //(Birth Year)
    private int iyr; //(Issue Year)
    private int eyr; //(Expiration Year)
    private String hgt; //(Height)
    private String hcl; //(Hair Color)
    private String ecl; //(Eye Color)
    private String pid; //(Passport ID)
    private String cid; //(Country ID)

    public Passport() {
    }

    public void setByr(int byr) {
        this.byr = byr;
    }

    public void setIyr(int iyr) {
        this.iyr = iyr;
    }

    public void setEyr(int eyr) {
        this.eyr = eyr;
    }

    public void setHgt(String hgt) {
        this.hgt = hgt;
    }

    public void setHcl(String hcl) {
        this.hcl = hcl;
    }

    public void setEcl(String ecl) {
        this.ecl = ecl;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "byr=" + byr +
                ", iyr=" + iyr +
                ", eyr=" + eyr +
                ", hgt='" + hgt + '\'' +
                ", hcl='" + hcl + '\'' +
                ", ecl='" + ecl + '\'' +
                ", pid=" + pid +
                ", cid=" + cid +
                '}';
    }

    public boolean isValid() {
        if (byr == 0)
            return false;
        if (iyr == 0)
            return false;
        if (eyr == 0)
            return false;
        if (hgt == null)
            return false;
        if (hcl == null)
            return false;
        if (ecl == null)
            return false;
        return pid != null;
    }

    /*
    byr (Birth Year) - four digits; at least 1920 and at most 2002.
    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    hgt (Height) - a number followed by either cm or in:
    If cm, the number must be at least 150 and at most 193.
    If in, the number must be at least 59 and at most 76.
    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    pid (Passport ID) - a nine-digit number, including leading zeroes.
    cid (Country ID) - ignored, missing or not.
     */

    public boolean isValidPart2() {
        return (Integer.toString(byr).length() == 4 && byr >= 1920 && byr <= 2002) &&
                (Integer.toString(iyr).length() == 4 && iyr >= 2010 && iyr <= 2020) &&
                (Integer.toString(eyr).length() == 4 && eyr >= 2020 && eyr <= 2030) &&
                ((hgt.matches("\\d*cm") && Integer.parseInt(hgt.substring(0, hgt.indexOf("cm"))) >= 150 && Integer.parseInt(hgt.substring(0, hgt.indexOf("cm"))) <= 193)
                        || (hgt.matches("\\d*in") && Integer.parseInt(hgt.substring(0, hgt.indexOf("in"))) >= 59 && Integer.parseInt(hgt.substring(0, hgt.indexOf("in"))) <= 76)) &&
                hcl.matches("#[0-9a-f]{6}") &&
                ecl.matches("(amb|blu|brn|gry|grn|hzl|oth)") &&
                pid.matches("\\d{9}");
    }
}
