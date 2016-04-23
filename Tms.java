package com.bruip.ch14;

import java.util.Scanner;
/**
 *这是一个老师管理信息系统，用来对老师完成一些基本操作
 */
public class Tms
{
	private Teacher[] teas = new Teacher[5];
	private int index = 0;
	public void save(Teacher tea){
		if(index > teas.length){
			Teacher[] demo = new Teacher[teas.length+5];
			System.arraycopy(teas,0,demo,0,index);
			teas = demo;
		}
		teas[index++] = tea;
	}
	public Teacher[] querryAll(){
		Teacher[] demo = new Teacher[index];
		System.arraycopy(teas,0,demo,0,index);
		return demo;
	}
	public Teacher querryById(long id){
		int num = querryIndexById(id);
		return num == -1?null:teas[num];
	}
	public int querryIndexById(long id){
		int num = -1;
		for(int i = 0;i < index;i++){
			if(teas[i].getId()==id){
				num = i; 
				break;
			}
		}
		return num;
	}
	public void update(Teacher newTea){
		for(int i = 0;i <= index;i++){
			if(newTea.getId() == teas[i].getId())
			{
				teas[i].setName(newTea.getName());
				teas[i].setAge(newTea.getAge());				
				teas[i].setAddress(newTea.getAddress());
				teas[i].setSex(newTea.getSex());

			}
		}
	}
	public void deleteById(long id){
		int num = querryIndexById(id);
		for(int i = num;i < index-1;i++){
			teas[i]=teas[i+1];
		}
		teas[--index] = null;
	}
	public void meun(){
		System.out.println("~~~~^_^欢迎进入老师管理信息系统^_^~~~~");
		System.out.println("1.  查询所有老师的信息。");
		System.out.println("2.  录入新增加的老师信息。");
		System.out.println("3.  查询单个老师的相关信息。");
		System.out.println("4.  修改相关的老师信息。");
		System.out.println("5.  删除相关老师的信息。");
		System.out.println("exit  退出");
		System.out.println("help  帮助");
	}
	public static void main(String[] args){
		Tms tms = new Tms();
		tms.meun();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("请输入功能编号！");
			String O = sc.nextLine();
			switch(O){
				case "1":
				    System.out.println("以下为所有老师的信息：");
			        Teacher[] tea = tms.querryAll();
					for(int i = 0;i < tea.length;i++){
						System.out.println(tea[i]);
					}
					System.out.println("总计老师"+tms.index+"个。");
				    break;
				case "2":
					while(true){
					System.out.println("请输入你要录入的老师信息格式为【name-age-id-sex-address】或者输入break返回上一层目录");
				    String str = sc.nextLine();
					if(str.equals("break")){
						break;
					}
					String[] arr = str.split("-");
					String name = arr[0];
					int age = Integer.parseInt(arr[1]);
					long id = Long.parseLong(arr[2]);
					String sex = arr[3];
					String address = arr[4];
					Teacher tea1 = new Teacher(name,age,id,sex,address);
					tms.save(tea1);
					System.out.println("录入成功!");
				}
				    break;
				case "3":
					while(true){
						System.out.println("请输入你要查询的老师的编号：");
						String str1 = sc.nextLine();
						if(str1.equals("break")){
						    break;
					    }
						long id0 = Long.parseLong(str1);
						Teacher tea2 = tms.querryById(id0);
						System.out.println(tea2 == null?"sorry,Notfound":tea2);
				}
				    break;
				case "4":
					while(true){
					System.out.println("请输入需要修改信息的老师的编号：");
					String idStr = sc.nextLine();
					if(idStr.equals("break")){
						break;
					}
					long id1 = Long.parseLong(idStr);
					Teacher oldTea = tms.querryById(id1);
					if(oldTea == null){
						System.out.println("该老师信息找不到！");
						continue;
					}
					System.out.println("修改前的信息为："+oldTea);
					System.out.println("请输入需要修改的信息格式为【name*age*sex*address】");
					String newTea = sc.nextLine();
					String[] newArr = newTea.split("*");
					String name1 = newArr[0];
					int age1 = Integer.parseInt(newArr[1]);
					String sex1 = newArr[3];
					String address1 = newArr[4];
					Teacher nTea = new Teacher(name1,age1,id1,sex1,address1);
					System.out.println("修改后的信息为："+nTea);
					
				}
				    break;
				case "5":
					while(true){
					System.out.println("请输入需要删除信息的老师的编号：");
					String idStr = sc.nextLine();
					if(idStr.equals("break")){
						break;
					}
					long id2 = Long.parseLong(idStr);
					Teacher oldTea = tms.querryById(id2);
					if(oldTea == null){
						System.out.println("该老师信息找不到！");
						continue;
					}
					tms.deleteById(id2);
					System.out.println("删除成功！");
				}
				    break;
				case "exit":
					System.out.println("ByeBye,欢迎您下次使用，祝你心情愉快！");
				    System.exit(0);
				    break;
				case "help":
					tms.meun();
				    break;
				default:
					System.out.println("输入有误请重新输入！");
			}
		}
	}
	
}