package com.bruip.ch14;

import java.util.Scanner;
/**
 *����һ����ʦ������Ϣϵͳ����������ʦ���һЩ��������
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
		System.out.println("~~~~^_^��ӭ������ʦ������Ϣϵͳ^_^~~~~");
		System.out.println("1.  ��ѯ������ʦ����Ϣ��");
		System.out.println("2.  ¼�������ӵ���ʦ��Ϣ��");
		System.out.println("3.  ��ѯ������ʦ�������Ϣ��");
		System.out.println("4.  �޸���ص���ʦ��Ϣ��");
		System.out.println("5.  ɾ�������ʦ����Ϣ��");
		System.out.println("exit  �˳�");
		System.out.println("help  ����");
	}
	public static void main(String[] args){
		Tms tms = new Tms();
		tms.meun();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("�����빦�ܱ�ţ�");
			String O = sc.nextLine();
			switch(O){
				case "1":
				    System.out.println("����Ϊ������ʦ����Ϣ��");
			        Teacher[] tea = tms.querryAll();
					for(int i = 0;i < tea.length;i++){
						System.out.println(tea[i]);
					}
					System.out.println("�ܼ���ʦ"+tms.index+"����");
				    break;
				case "2":
					while(true){
					System.out.println("��������Ҫ¼�����ʦ��Ϣ��ʽΪ��name-age-id-sex-address����������break������һ��Ŀ¼");
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
					System.out.println("¼��ɹ�!");
				}
				    break;
				case "3":
					while(true){
						System.out.println("��������Ҫ��ѯ����ʦ�ı�ţ�");
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
					System.out.println("��������Ҫ�޸���Ϣ����ʦ�ı�ţ�");
					String idStr = sc.nextLine();
					if(idStr.equals("break")){
						break;
					}
					long id1 = Long.parseLong(idStr);
					Teacher oldTea = tms.querryById(id1);
					if(oldTea == null){
						System.out.println("����ʦ��Ϣ�Ҳ�����");
						continue;
					}
					System.out.println("�޸�ǰ����ϢΪ��"+oldTea);
					System.out.println("��������Ҫ�޸ĵ���Ϣ��ʽΪ��name*age*sex*address��");
					String newTea = sc.nextLine();
					String[] newArr = newTea.split("*");
					String name1 = newArr[0];
					int age1 = Integer.parseInt(newArr[1]);
					String sex1 = newArr[3];
					String address1 = newArr[4];
					Teacher nTea = new Teacher(name1,age1,id1,sex1,address1);
					System.out.println("�޸ĺ����ϢΪ��"+nTea);
					
				}
				    break;
				case "5":
					while(true){
					System.out.println("��������Ҫɾ����Ϣ����ʦ�ı�ţ�");
					String idStr = sc.nextLine();
					if(idStr.equals("break")){
						break;
					}
					long id2 = Long.parseLong(idStr);
					Teacher oldTea = tms.querryById(id2);
					if(oldTea == null){
						System.out.println("����ʦ��Ϣ�Ҳ�����");
						continue;
					}
					tms.deleteById(id2);
					System.out.println("ɾ���ɹ���");
				}
				    break;
				case "exit":
					System.out.println("ByeBye,��ӭ���´�ʹ�ã�ף��������죡");
				    System.exit(0);
				    break;
				case "help":
					tms.meun();
				    break;
				default:
					System.out.println("�����������������룡");
			}
		}
	}
	
}