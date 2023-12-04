/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

/**
 *
 * @author hanqi
 */
public class Customer {
    String Name;
    String Email ;
    String Phone ;
    String Address ;
    String City;
    String State;
    String ZipCode;
    String Country;
    public Customer( String Name, String Phone, String Address) {
    this.Name = Name;
    this.Phone = Phone;
    this.Address = Address;
}
    public Customer( String City, String State, String ZipCode, String Country) {
//    this.id = id;
    this.City = City;
    this.State = State;
    this.ZipCode = ZipCode;
    this.Country = Country;
   
}
    
    public String getName(){
        return Name;
    }
    
    public void setName(String Name){
    this.Name = Name;
    }
    
    public String getPhone(){
        return Phone;
    }
    
    public void setPhone(String Phone){
    this.Phone = Phone;
    }
    
    public String getAddress(){
        return Address;
    }
    
    public void setAddress(String Address){
    this.Address = Address;
    }
    
    public String getCity(){
        return City;
    }
    
    public void setCity(String City){
    this.City = City;
    }
    
    public String getState(){
        return State;
    }
    
    public void setState(String State){
    this.State = State;
    }
        
    public String getZipCode(){
        return ZipCode;
    }
    
    public void setZipCode(String ZipCode){
    this.ZipCode = ZipCode;
    }
    
    public String getCountry(){
        return Country;
    }
    
    public void setCountry(String Country){
    this.Country = Country;
    }
    
    }
    public Customer() {
}
}
