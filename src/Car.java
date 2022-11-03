/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.HashMap;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author shyde
 */
public class Car implements CarInterface{
    
    //create private elements which described the car.
    private int id;
    private Make make;
    private double rate;
    private Map<Month, Boolean[]>map;

    /*
    method creates the availability of the car for the whole year and also defines the car attributes
    */
    public Car(int id,Make make,double rate){
        this.id = id;
        this.make = make;
        this.rate = rate;
        createAvailability();
        
    }
    
    @Override
    //create a map to input the enums all at once for defined and return the map for availability
    public Map createAvailability() { 
     map = new HashMap<>();             

    map.put(Month.JANUARY, new Boolean[31]);
    map.put(Month.FEBRUARY, new Boolean[28]);
    map.put(Month.MARCH, new Boolean[31]);
    map.put(Month.APRIL, new Boolean[30]);
    map.put(Month.MAY, new Boolean[31]);
    map.put(Month.JUNE, new Boolean[30]);
    map.put(Month.JULY, new Boolean[31]);
    map.put(Month.AUGUST, new Boolean[31]);
    map.put(Month.SEPTEMBER, new Boolean[30]);
    map.put(Month.OCTOBER, new Boolean[31]);
    map.put(Month.NOVEMBER, new Boolean[30]);
    map.put(Month.DECEMBER, new Boolean[31]);

        return map;
    }

    @Override
    //returning the make of the cars
    public Make getMake() { 
        return make;
    }

    @Override
    //setter method for the make of the cars
    public void setMake(Make make) { 
        this.make = make;
    }

    @Override
    //return the rate of the cars
    public double getRate() { 
        return rate;
    }

    @Override
     //setter for rate
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    //returns the map
    public Map getAvailability() { 
        return map;
    }

    @Override
     //setting availability for the calender
    public void setAvailability(Map availability) {
    this.map = map;
    }

    @Override
    public int getId() { //returns the id
        return id;
    }

    @Override
    //this boolean function defines if a particular day is availiable or not and returns
    public boolean isAvailable(Month month, int day) {
        
        // **we use(-1) in the function because the index in java functions start at 0  
       Boolean[] available = map.get(month);          
       if (available[day-1]==null){
           available[day-1] = true;
       }
       return true;
    }

    @Override
    //this boolean function checks if a day is booked or not and returns 
    public boolean book(Month month, int day) {
        Boolean[] book = map.get(month);
        if (book[day-1]== null){
            book [day-1] = false;
            return true;
            } 
            return false;
        }
    }
    

