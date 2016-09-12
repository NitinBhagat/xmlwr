/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernost.xmlrw;

/**
 *
 * @author Nitin
 */
public class attributes {

    String id, value;

    public attributes(String id,String value) {
        this.id=id;
        this.value=value;
    }
    
    public String toString(){
        return "Id:"+id+",Value="+value;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
