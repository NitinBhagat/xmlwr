/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernost.xmlrw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nitin
 */
public class data {
    private String value,name,Content;
    private List<attributes> attr;
    private List<data> childnodes;
    
    public String toString(){
        return "Name:"+name+",Value:"+value+",Attributes:["+attr+"],Content:"+Content+",ChildNodes:["+childnodes.toString()+"]";
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public data(){
        attr=new ArrayList<>();
        childnodes=new ArrayList<>();
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<attributes> getAttr() {
        return attr;
    }

    public void addAttr(attributes attr) {
        this.attr.add(attr);
    }
    
    public void setAttr(List<attributes> attr) {
        this.attr = attr;
    }

    public List<data> getChildnodes() {
        return childnodes;
    }
    public boolean hasChild(){
        if (childnodes.size()>0) {
            return true;
        }else{
            return false;
        }
    }
    public void addChildnodes(data childnodes) {
        this.childnodes.add(childnodes);
    }
    
    public void setChildnodes(List<data> childnodes) {
        this.childnodes = childnodes;
    }
}
