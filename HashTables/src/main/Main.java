package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentInfo someStudent;
		StudentInfo removedStudent;
		
		MyHashTable theHT = new MyHashTable(10);  // Open hash table with 10 buckets
		
		theHT.displayTable();
		
		someStudent = new StudentInfo(123456, "Bugs", "Bunny");
		theHT.addToTable(someStudent);
		
		someStudent = new StudentInfo(987654, "Lola", "Bunny");
		theHT.addToTable(someStudent);
		
		someStudent = new StudentInfo(464646, "Daffy", "Duck");
		theHT.addToTable(someStudent);

		theHT.displayTable();
		
		removedStudent = theHT.removeFromTable(777777);
		if (removedStudent == null) {
			System.out.println("\nRemove failed!  No student with that student number in the table!");
		}
		else {
			System.out.println("\nRemoved " + removedStudent.firstName);
		}
		
		theHT.displayTable();
		
		removedStudent = theHT.removeFromTable(123456);
		if (removedStudent == null) {
			System.out.println("\nRemove failed!  No student with that student number in the table!");
		}
		else {
			System.out.println("\nRemoved " + removedStudent.firstName);
		}
		
		theHT.displayTable();

	}

}
