package com.bruip.ch14;

public class Teacher
{
	//1.�ṩ˽������
	private String name;
	private int age;
	private long id;
	private String sex;
	private String address;
	//2.�ṩ���캯��
	public Teacher(){

	}
	public Teacher(String name,int age,long id,String sex,String address){
		this.name = name;
		this.age = age;
		this.id = id;
		this.sex = sex;
		this.address = address;
	}
	//3.�ṩ������setter�Լ�getter����
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}	
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
	public void setId(long id){
		this.id = id;
	}
	public long getId(){
		return this.id;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getSex(){
		return this.sex;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return this.address;
	}
	//4.��д����toString����
	public String toString(){
		return "*Name: "+this.name+" Age��"+this.age+" Id: "+this.id+" Sex: "+this.sex+" Address: "+this.address;
	}

}