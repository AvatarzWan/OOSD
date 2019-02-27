package oosd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hazwa
 */
public class Player {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Player(String name){
        this.name=name;
        
    }
    
    @Override
    public String toString(){
        return this.getName();
            }
    
}
