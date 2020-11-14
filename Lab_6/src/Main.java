import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<Grades> gradesList = new ArrayList<>(); // an arraylist to store the grade objects and accessing using functions later on
	// the percentages should add up to 100%
	public static double finalExamPercentage; // stores the percentage final exam counts towards final grade
	public static double midtermPercentage; // stores the percentage midterms count towards final grade
	public static double quizPercentage; // stores the percentage quizzes count towards final grade
	public static double assignmentPercentage; // stores the percentage assignments count towards final grade
	public static double participationPercentage; // stores percentage participation counts towards final grade
	public static ArrayList<Double> percentage = new ArrayList<>(); // stores the percentage variables in a double array for accessing later on
	// the averages of each grade are calculated from the percentages. For every grade with similar name, it finds the average of the grades, divide by 100, then multiply towards the percentage
	// which will give the number of points for each grade. Ex. midterms have an average of 95 and the percentage is 30%. Therefore midtermAverage will store 30 x .95
	public static double finalExam = 0; // stores the grade of final exam towards final grade
	public static double midtermAverage = 0; // stores the average of midterms towards final grade
	public static double quizAverage = 0; // stores the average of quizzes towards final grade
	public static double assignmentAverage = 0; // stores the average of assignments towards final grade
	public static double participation = 0; // stores grade of participation towards final grade
	public static ArrayList<Double> average = new ArrayList<>(); // stores the percentage variables in a double array for accessing later on
	public static String letterGrade; // stores letter grade. Ex. A-
	public static double percentGrade; // stores percent grade. Ex. 91
	public static DecimalFormat df2 = new DecimalFormat("#.##"); // used to print doubles with two decimal places
	// main function
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// using the scanner users will input the percentages each category counts towards the grade
		// while the percentages does not add up to 100, it will continue prompt user to reenter the percentages
		while ((finalExamPercentage + midtermPercentage + quizPercentage + assignmentPercentage +  participationPercentage) != 100) {
			System.out.println("Please enter the percentage the final exam count towards your grade");
			finalExamPercentage = sc.nextDouble();
			percentage.add(finalExamPercentage);
			System.out.println("Please enter the percentage midterms count towards your grade");
			midtermPercentage = sc.nextDouble();
			percentage.add(midtermPercentage);
			System.out.println("Please enter the percentage quizzes count towards your grade");
			quizPercentage = sc.nextDouble();
			percentage.add(quizPercentage);
			System.out.println("Please enter the percentage assignments count towards your grade");
			assignmentPercentage = sc.nextDouble();
			percentage.add(assignmentPercentage);
			System.out.println("Please enter the percentage participation count towards your grade");
			participationPercentage = sc.nextDouble();
			percentage.add(participationPercentage);
			if ((finalExamPercentage + midtermPercentage + quizPercentage + assignmentPercentage +  participationPercentage) != 100) {
				System.out.println("Entered percentages does not add up to 100%");
				System.out.println("");
			}
		}
		// lines 44-54, while the input is not exit, it will prompt the user to enter the category from the chocies as well as the grade. Then a grade object is made using the two entries and 
		// added into the gradesList ArrayList
		while(true) {
			System.out.println("Please enter the category of your grade: f = (final exam), m = (midterm), q = (quiz), a = (assignment), p = (participation). Enter exit to stop entering grades");
			String category = sc.next();
			if (category.equals("exit")) {
				break;
			}
			System.out.println("Please enter the percent grade for this category");
			double grade = sc.nextDouble();
			Grades obj = new Grades(category, grade);
			gradesList.add(obj);
		}
		/*Grades obj = new Grades("m", 100);
		Grades obj2 = new Grades("q", 90);
		Grades obj3 = new Grades("q", 70);
		Grades obj4 = new Grades("a", 90);
		Grades obj5 = new Grades("a", 80);
		gradesList.add(obj);
		gradesList.add(obj2);
		gradesList.add(obj3);
		gradesList.add(obj4);
		gradesList.add(obj5);*/
		
		calculateAverages(); // calculates the averages of each category
		getGrade(); // prints out the total average of the grades and the letter grade associated with the percent grade
		System.out.println("Please enter the percent grade you desire to get. Example, 91"); // prompt user to enter the grade they want based on their current grades
		desiredGrade(sc.nextDouble()); // prints out the grades needed for each category in order to achieve the desired grade
	}
	// function to set the average variables from lines 15-19. 
	public static void calculateAverages() {
		// runs through entire ArrayList
		for (int i = 0; i < gradesList.size(); i++) {
			// if the name of the object equals f
			if (gradesList.get(i).name.contains("f")) {
				// finalExam stores the grade of the (object / 100) and multiply it with the finalExamPercentage stored above. As there is on;y, it doesn't require any more processes as other categories do 
				finalExam = (gradesList.get(i).grade/100) * finalExamPercentage;
			}
			// if the name of the category is m
			else if (gradesList.get(i).name.contains("m")) {
				// checks if the average if 0, if it is then it grade of the (object / 100) and multiply it with the midtermPercentage stored above
				if (midtermAverage == 0) {
					midtermAverage = (gradesList.get(i).grade/100) * midtermPercentage;
				}
				// if midtermAverage is not 0, it adds the number from line 59 to midtermAverage and divides by 2
				else {
					midtermAverage = (midtermAverage + ((gradesList.get(i).grade/100) * midtermPercentage)) / 2;
				}
			}
			// if the name of the category is q
			else if (gradesList.get(i).name.contains("q")) {
				// checks if the average if 0, if it is then it grade of the (object / 100) and multiply it with the quizPercentage stored above
				if (quizAverage == 0) {
					quizAverage = (gradesList.get(i).grade/100) * quizPercentage;
				}
				// if quizAverage is not 0, it adds the number from line 70 to quizAverage and divides by 2
				else {
					quizAverage = (quizAverage + ((gradesList.get(i).grade/100) * quizPercentage)) / 2;
				}
			}
			//if the name of the category is a
			else if (gradesList.get(i).name.contains("a")) {
				// checks if the average if 0, if it is then it grade of the (object / 100) and multiply it with the assignmentPercentage stored above
				if (assignmentAverage == 0) {
					assignmentAverage = (gradesList.get(i).grade/100) * assignmentPercentage;
				}
				// if assignmentAverage is not 0, it adds the number from line 81 to quizAverage and divides by 2
				else {
					assignmentAverage = (assignmentAverage + ((gradesList.get(i).grade/100) * assignmentPercentage)) / 2;
				}
			}
			//if the name of the category is a
			else if (gradesList.get(i).name.contains("p")) {
				// checks if the average if 0, if it is then it grade of the (object / 100) and multiply it with the assignmentPercentage stored above
				if (participation == 0) {
					participation = (gradesList.get(i).grade/100) * participationPercentage;
				}
				// if assignmentAverage is not 0, it adds the number from line 92 to quizAverage and divides by 2
				else {
					participation = (participation + ((gradesList.get(i).grade/100) * participationPercentage)) / 2;
				}
			}
		}
		// adds all five average variables to the array list in the same order as the participation average
		average.add(finalExam);
		average.add(midtermAverage);
		average.add(quizAverage);
		average.add(assignmentAverage);
		average.add(participation);
	}
	// this function prints the number of points total from all averages
	public static void getGrade() {
		double num = 0; // double variable to store values
		double points = 0;
		for (int i = 0; i < average.size(); i++) { // for each double in the array
			if (average.get(i) != 0) { // if the average of this category is not 0
				num += average.get(i); // adds the points to the variable
				points += percentage.get(i); // adds the total possible points for this category into the variable
			}
		}
		// lines 146 - 182 checks the percetn grade and converts it to a letter grade.
		percentGrade = (num / points) * 100;
		if (percentGrade >= 97) {
			letterGrade = "A+";
		}
		if ((percentGrade >= 93) && (percentGrade < 97)) {
			letterGrade = "A";
		}
		if ((percentGrade >= 90) && (percentGrade < 93)) {
			letterGrade = "A-";
		}
		if ((percentGrade >= 87) && (percentGrade < 90)) {
			letterGrade = "B+";
		}
		if ((percentGrade >= 83) && (percentGrade < 87)) {
			letterGrade = "B";
		}
		if ((percentGrade >= 80) && (percentGrade < 83)) {
			letterGrade = "B-";
		}
		if ((percentGrade >= 77) && (percentGrade < 80)) {
			letterGrade = "C+";
		}
		if ((percentGrade >= 73) && (percentGrade < 77)) {
			letterGrade = "C";
		}
		if ((percentGrade >= 70) && (percentGrade < 73)) {
			letterGrade = "C-";
		}
		if ((percentGrade >= 67) && (percentGrade < 70)) {
			letterGrade = "D+";
		}
		if ((percentGrade >= 65) && (percentGrade < 67)) {
			letterGrade = "D";
		}
		if (percentGrade < 65) {
			letterGrade = "F";
		}
		System.out.println("The letter grade is " + df2.format(percentGrade) + " and the letter grade is " + letterGrade); // prints out the grades
	}
	
	// based on current letter grade, it will print out the averages of each category that users need at minimum to get the grade. The allocation of points is from my preference
	// there are multiple combinations to allocate points to grade. 
	public static void desiredGrade(double grade) {
		double number = 0; // this variable will store the number of points that user can lose at most. 
		if (percentGrade > grade) { // checks if the current 
			System.out.println("Your current grade is higher than your desired grade");
		}
		else if (percentGrade == grade) { // if the current grade equals the desired grade
			System.out.println("You have aquired your desired grade");
		}
		else { // this is the scenario where the grade you desire is higher than the grade you have
			number = 100 - grade; // stores the amount of points you can lose at minimumn
			double factor = number / 10;
			// operation to be done is the ratio of finalExam:midterm:quiz:assignment:particiaption = number
			double finalExamRatio = (finalExamPercentage / 10) * factor; // the minimum number of points this category can lose
			double midtermRatio = (midtermPercentage / 10) * factor; // the minimum number of points this category can lose
			double quizRatio = (quizPercentage / 10) * factor; // the minimum number of points this category can lose
			double assignmentRatio = (assignmentPercentage / 10) * factor; // the minimum number of points this category can lose
			double participationRatio = (participationPercentage / 10) * factor; // the minimum number of points this category can lose
			double requiredFinal = 0; // necessary final exam grade
			double requiredMidterm = 0; // necessary midterm average
			double requiredQuiz = 0; // necessary quiz grade
			double requiredAssignment = 0; // necessary assignment grade
			double requiredParticipation = 0; // necessary particiapation
			if (finalExam == 0) {
				requiredFinal = ((finalExamPercentage - finalExamRatio) / finalExamPercentage) * 100; // if there is no final exam, stores the grade that the final exam would at least need for the desired grade
			}
			if ((midtermPercentage - midtermRatio) < midtermAverage) { // if the percentage - the ratio is less than the grade already had, stores into requiredMidterm as user needs to keep this average
				requiredMidterm = midtermAverage;
			}
			if ((midtermPercentage - midtermRatio) > midtermAverage) { // if the percentage - ratio is greater than the midterm average, stores the percentage - ratio as this is grade needed to keep
				requiredMidterm = midtermPercentage - midtermRatio;
			}
			if ((quizPercentage - midtermRatio) < quizAverage) { // if the percentage - the ratio is less than the grade already had, stores into requiredQuiz as user needs to keep this average
				requiredQuiz = quizAverage;
			}
			if ((quizPercentage - quizRatio) > quizAverage) { // if the percentage - ratio is greater than the quiz average, stores the percentage - ratio as this is grade needed to keep
				requiredQuiz = quizPercentage - quizRatio;
			}
			if ((assignmentPercentage - assignmentRatio) < assignmentAverage) { // if the percentage - the ratio is less than the grade already had, stores into requiredMidterm as user needs to keep this average
				requiredAssignment = assignmentAverage;
			}
			if ((assignmentPercentage - assignmentRatio) > assignmentAverage) { // if the percentage - ratio is greater than the midterm average, stores the percentage - ratio as this is grade needed to keep
				requiredAssignment = assignmentPercentage - assignmentRatio;
			}
			if ((participationPercentage - participationRatio) < participation) { // if the percentage - the ratio is less than the grade already had, stores into requiredMidterm as user needs to keep this average
				requiredParticipation = participation;
			}
			if ((participationPercentage - participationRatio) > participation) { // if the percentage - ratio is greater than the midterm average, stores the percentage - ratio as this is grade needed to keep
				requiredParticipation = participationPercentage - participationRatio;
			}
			
			if (finalExam != 0) { // if there is a grade for a final exam, it indicates that the semester is over an no further grades can be inputted
				System.out.println("There is a grade for final exam, no further changes can be done");
			}
			else {
				System.out.println("Current grades of each category: Final Exam : " + df2.format(finalExam) + "% | Midterm " + df2.format((midtermAverage/midtermPercentage) * 100) + "% | Quiz : "
						+ df2.format((quizAverage/quizPercentage) * 100) + "% | Assignment : " + df2.format((assignmentAverage/assignmentPercentage) * 100) + "% | Participation : " + df2.format((participation/participationPercentage) * 100) + "%");
				System.out.println(" ");
				System.out.println("Based on current grades, for a final grade of " + grade + ", the required minimum averages for each category are: Final Exam : " + df2.format(requiredFinal) + "% | Midterm " + df2.format((requiredMidterm/midtermPercentage) * 100) + "% | Quiz : "
						+ df2.format((requiredQuiz/quizPercentage) * 100) + "% | Assignment : " + df2.format((requiredAssignment/assignmentPercentage) * 100) + "% | Participation : " + df2.format((requiredParticipation/participationPercentage) * 100) + "%");
			}
		}
	}
	
}

