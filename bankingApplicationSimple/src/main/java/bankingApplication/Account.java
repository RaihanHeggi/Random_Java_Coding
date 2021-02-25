/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingApplication;

/**
 *
 * @author user
 */
public class Account {
    private String name;
    private String pin;
    private float deposit;

    public Account(String name, String pin, float deposit) {
        setName(name);
        setPin(pin);
        setDeposit(deposit);
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPin(String pin){
        if(pin.length() < 7){
            this.pin = pin;
        }else{
            System.out.println("Maximum PIN Length is 6 Character");
        }
    }
    
    public void setDeposit(float deposit){
        this.deposit = deposit;
    }
    
    
    
    
}
