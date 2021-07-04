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
public class Day {
    private Calendar date; //当日日期
    private ArrayList<Event> eventList; //该日期下所有event

    public Day(Calendar date, ArrayList<Event> eventList) {
        this.date = date;
        this.eventList = eventList;
    }

    public void addToEventList(Event event){
        this.eventList.add(event);
    }
    
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }
    
    public double eventPosition(){
        return 0.0;
    }
}
