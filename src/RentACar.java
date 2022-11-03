/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.List;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author shyde
 */
public class RentACar implements RentACarInterface{

    private List <Car>cars; //create an arraylist which is cars
    private String name;
    
    public RentACar (List<Car> cars, String name){
        this.cars = cars;
        this.name = name;
    }
    @Override
    //returns List of cars
    public List getCars() {
        return cars;
    }

    @Override 
// sets car in a list
    public void setCars(List cars) {
        this.cars = cars;
    }

    @Override
     //returns the name 
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) { //sets the name
        this.name = name;
    }

    @Override 
//this method chcek availability of car based on month,day,type of car,and for how long and returns the value true if works
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        int currentDay,flagDay;
        for(Car car:cars){
            if(car.getMake().equals(make)){
                flagDay = 0;
                currentDay = day;
                for(int i=0; i<lengthOfRent; i++){
                
                    if(!car.isAvailable(month, day++)){
                    flagDay = 1;
                    break;
                }
            }
                if(flagDay == 0){
                    return true;
                }
            }
        }
        return false;
    }

    @Override 
//the id of a car that fits that availability; returns the Id of a room that fits the bill
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
                int currentDay,flagDay;
        for(Car car:cars){
            if(car.getMake().equals(make)){
                flagDay = 0;
                currentDay = day;
                for(int i=0; i<lengthOfRent; i++){
                
                    if(!car.isAvailable(month, day++)){
                    flagDay = 1;
                    break;
                }
            }
                if(flagDay == 0){
                    return car.getId();
                }
            }
        }
        return -1;
    }

    @Override 
//method uses attributes of  booking  to check if booking is working or not and returns true if booking is confirmed
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        if(!checkAvailability(month,day,make,lengthOfRent)){
            return false;
        }
        int carId = getCarAvailable(month,day,make,lengthOfRent);
        
        for(Car car:cars){
            if(car.getId()==carId&&car.getMake()==make){
                int currentDay = day;
                for(int i=0; i<lengthOfRent;i++){
                    car.book(month, day++);
                    
                    }
                }
            }
            return true;
        }
        

    @Override
    //return total number of cars from the list
    public int getNumberOfCars() {

        return cars.size();
        
    }
    
}
