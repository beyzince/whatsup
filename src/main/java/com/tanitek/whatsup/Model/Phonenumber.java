package com.tanitek.whatsup.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
public class Phonenumber {

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getWpphoto() {
        return wpphoto;
    }

    public void setWpphoto(String wpphoto) {
        this.wpphoto = wpphoto;
    }

    public String getWpstatus() {
        return wpstatus;
    }

    public void setWpstatus(String wpstatus) {
        this.wpstatus = wpstatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    String phonenumber;
    String wpphoto;
    String wpstatus;
    String name;

}
