package jdbcexample;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DBIntractions db = new DBIntractions();
		System.out.println("Welcome to JDBC PROJECT ");
		String name;
		String address;
		int id;
		while (true) {
			System.out.println("1 ADD 2 Display 3 Update 4 Delete 5 Search");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				System.out.println("Enter name , address,id  ");
				name = sc.next();
				address = sc.next();
				id = sc.nextInt();
				Profile p = new Profile(name, address, id, 0);
				db.createMember(p);
				db.releaseResources();
				break;

			case 2:
				db.display();
				db.releaseResources();
				break;
			case 3:
				System.out.println("update section");
				System.out.println("Enter  new name , new address , new id , old id ");
				name = sc.next();
				address = sc.next();
				id = sc.nextInt();
				int oldid = sc.nextInt();
				Profile pp = new Profile(name, address, id, oldid);
				db.update(pp);
				db.releaseResources();
				break;
			case 4:
				System.out.println("Delete section");
				System.out.println("Enter ID to delete ");
				id = sc.nextInt();
				Profile p2 = new Profile("", "", id, 0);
				db.delete(p2);
				db.releaseResources();
				break;
			case 5:
				System.out.println("Search section");
				System.out.println("Enter ID to search ");
				id = sc.nextInt();
				Profile p3 = new Profile("", "", id, 0);
				db.search(p3);
				db.releaseResources();
				break;

			default:
				System.out.println("invalid");
				break;
			}
		}

	}

}
