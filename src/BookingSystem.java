
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;
import ooc.yoursolution.BookingSystemInterface;
import ooc.yoursolution.RentACarInterface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class BookingSystem implements BookingSystemInterface{

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
          //String name tells the name of company
        String input, name;     
        
        //input tells the vehicle inside from the file
        List<Car> cars = new ArrayList<>();  
        name = in.readLine();
            
        //Definer list splits the data substrings ":" and classify it as make,rate and price and quantity
            while((input = in.readLine())!=null){        
                String definer[] = input.split(":");
                
                //Use positional indexes in java to define various objects
                Make make = Make.valueOf(definer[0]);         
                double rate = Double.parseDouble(definer[1]);
                int numOfCars = Integer.parseInt(definer[2]);
                
                //a simmple for loop fills in the list with different cars and quantity
                for(int i=0;i<numOfCars;i++){       
                    Car car = new Car(i,make,rate);
                    cars.add(car);
                }
            
        }       //returns the instance of RentACar class
            RentACarInterface rentACarInterface = new RentACar(cars,name);
            
            return rentACarInterface;
    }

}
    
