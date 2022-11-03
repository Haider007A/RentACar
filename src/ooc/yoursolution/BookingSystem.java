/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;

/**
 *
 * @author PC
 */
public class BookingSystem implements BookingSystemInterface{

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        
        // string name  tells the company name
        String input, name;   
        
        //input tells the vehicle inside from the file
        List<Car> cars = new ArrayList<>();   
        name = in.readLine();
            
         //define list splits the data of substrings ":" and set it as make,rate,price and quantity
            while((input = in.readLine())!=null){       
                String definer[] = input.split(":");
                
                 //use of positional indexes to define various objects
                Make make = Make.valueOf(definer[0]);        
                double rate = Double.parseDouble(definer[1]);
                int numOfCars = Integer.parseInt(definer[2]);
                
                //this simmple method for loop fills in the list with different cars and quantity
                for(int i=0;i<numOfCars;i++){       
                    Car car = new Car(i,make,rate);
                    cars.add(car);
                }
            
        }       //this will return the instance of RentACar class
            RentACarInterface rentACarInterface = new RentACar(cars,name);
            
            return rentACarInterface;
    }

}
    

