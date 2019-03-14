package top.yzlin.homework.entity;

import java.util.Date;

public class Ticket {
    private String name;
    private String sex;
    private String originating;
    private String destination;
    private Date date;
    private String idCardNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if ("man".equals(sex.toLowerCase())) {
            this.sex = "男";
        } else if ("woman".equals(sex.toLowerCase())) {
            this.sex = "女";
        } else {
            this.sex = sex;
        }
    }

    public String getOriginating() {
        return originating;
    }

    public void setOriginating(String originating) {
        this.originating = originating;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", originating='" + originating + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                '}';
    }
}
