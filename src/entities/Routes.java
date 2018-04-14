/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author keyur_donga
 */
public class Routes {
    
    private ArrayList<City> cityList = new ArrayList<>();
    private Double fitnessScore = 0D;
    private Boolean betterPath = true;
    
    public Routes(ArrayList<City> cl){
        this.cityList.addAll(cl);
        Collections.shuffle(this.cityList);
    }
    
    public ArrayList<City> getCityList() {
        betterPath = true;
        return cityList;
    }

    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }

    public Double getFitnessScore() {
        if(betterPath == true){
            fitnessScore = (1/totalDistance()) * 8000;
            betterPath = false;
        }
        return fitnessScore;
    }

    public void setFitnessScore(Double fitnessScore) {
        this.fitnessScore = fitnessScore;
    }
        
    public Double totalDistance(){
        int citiesCount = this.cityList.size();
        double dist = 0;
        for(int i=0;i<citiesCount-1;i++){
            dist += this.cityList.get(i).CalculateDistance(this.cityList.get(i+1));
        }
        dist += this.cityList.get(citiesCount).CalculateDistance(this.cityList.get(0));
        
        return dist;
    }
    
    public String toString(){
        String citiesOrder = null;
        
        for(City c:cityList){
            citiesOrder += c + " ";
        }
        return citiesOrder;        
    }
    
}