/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.*;

/**
 *
 * @author Maggie
 */
public class Event {
    private String name; //event名称
    private String note; //event
    private Calendar startFrom; //event开始时间
    private Calendar endAt; //event结束时间
    private boolean alarm; //是否需要闹钟提醒
    private Group group; //event所属组别
    private Double position; //event在竖轴上的位置百分比

    public Event(String name, String note, Calendar startFrom, Calendar endAt, boolean alarm, Group group) {
        this.name = name;
        this.note = note;
        this.startFrom = startFrom;
        this.endAt = endAt;
        this.alarm = alarm;
        this.group = group;
        this.position = (this.startFrom.get(Calendar.HOUR_OF_DAY)*3600.0+this.startFrom.get(Calendar.MINUTE)*60.0)/86400;
    }

    Event(String exams, String string, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Calendar getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(Calendar startFrom) {
        this.startFrom = startFrom;
    }

    public Calendar getEndAt() {
        return endAt;
    }

    public void setEndAt(Calendar endAt) {
        this.endAt = endAt;
    }

    public boolean isAlarm() {
        return alarm;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    
    public Double getPosition() { return position; }
    
}
