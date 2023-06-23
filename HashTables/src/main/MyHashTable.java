package main;
import java.util.*;

public class MyHashTable {
	// ATTRIBUTES

	// buckets is an array of ArrayList.  Each item in an ArrayList is an StudentInfo
	// object holding a reference value pointing to a student.

	public ArrayList<StudentInfo>[] buckets;

	
	// CONSTRUCTOR

	public MyHashTable(int howManyBuckets) {
		// Construct the hash table (open hashing/closed addressing) as an array of howManyBuckets ArrayLists.

		// Instantiate buckets as an array to have an ArrayList as each element of the array.
		buckets = new ArrayList[howManyBuckets];

		// For each element in the array, instantiate its ArrayList.3
		for (int i = 0; i < howManyBuckets; i++) {
			buckets[i] = new ArrayList();  // Instantiate the ArrayList for bucket i.
		}
	}

	// METHODS

	public int calcBucket(int studentNumber) {
		return(studentNumber % buckets.length);  // student number modulo number of buckets
	}

	public void addToTable(StudentInfo theStudent) {
		// Add the student referenced by theStudent to the hash table.
		
		if (theStudent == null) {
			return; // Nothing to do!
		}
		// CODE GOES HERE
		else {
			int targetBucket = calcBucket(theStudent.studentNumber); // targetBucket stores what bucket info needs to go in
			buckets[targetBucket].add(theStudent); // adds the student to the respective array list
			
		}
		
	}

	public StudentInfo removeFromTable(int studentNum) {
		// Remove that student from the hash table and return the reference value for that student.
		// Return null if that student isn't in the table.

		int correctBucket = calcBucket(studentNum); // finds the correct bucket
		StudentInfo theStudent; // variable theStudent with type StudentInfo
		
		for (int i = 0; i < buckets[correctBucket].size();i++) {
			theStudent = buckets[correctBucket].get(i); // gets one of the values in the arrayList
			if (studentNum == theStudent.studentNumber) {
				theStudent = buckets[correctBucket].remove(i); // if the numbers match the student number is removed
				return theStudent; // returns the student
			}
		}
		return null;
	}
	
	public StudentInfo getFromTable(int studentNum) {
		// Return the reference value for that student, return null if student isn't in the table.

		// CODE GOES HERE
		int target = calcBucket(studentNum); // finds the target bucket
		StudentInfo theStudent; // variable theStudent with type StudentInfo
		
		for (int i = 0; i < buckets[target].size(); i++) {
			theStudent = buckets[target].get(i); // gets one of the values in the arrayList
			if (studentNum == theStudent.studentNumber) {
				return(theStudent); // returns the student if the numbers match
			}
		}
		return null;
}

	public void displayTable() {
		// Walk through the buckets and display the items in each bucket's ArrayList.
		
		System.out.println("\n\nHERE ARE THE CONTENTS OF THE TABLE:");
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i].isEmpty()) {
				System.out.println("Bucket " + i + " has an empty ArrayList!");
			}
			else {
				for (int j = 0; j < buckets[i].size(); j++) {
					System.out.println(buckets[i].get(j)); // loops through and prints all elements in the arrayList
				}
			}
			
		}
		
	}





}
