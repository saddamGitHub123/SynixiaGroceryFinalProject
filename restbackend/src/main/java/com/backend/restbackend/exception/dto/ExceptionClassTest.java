/**
 * 
 */
package com.backend.restbackend.exception.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Sk Saddam Hosan
 */
@Entity
@Table(name = "exception_test")
public class ExceptionClassTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID; 
	//private String code;
    private String E_Name;
    private int age;
    private String address;
   // private String L_Name;
    public ExceptionClassTest(){}


	public ExceptionClassTest(int iD, String e_Name, int age, String address) {
		super();
		ID = iD;
		E_Name = e_Name;
		this.age = age;
		this.address = address;
		//L_Name = l_Name;
	}


	@Override
	public String toString() {
		return "ExceptionClassTest [ID=" + ID + ", E_Name=" + E_Name + ", age=" + age + ", address=" + address + "]";
	}
	@JsonIgnore
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getE_Name() {
		return E_Name;
	}
	public void setE_Name(String e_Name) {
		E_Name = e_Name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


//	public String getL_Name() {
//		return L_Name;
//	}
//
//
//	public void setL_Name(String l_Name) {
//		L_Name = l_Name;
//	}
    
   
    
    

}
