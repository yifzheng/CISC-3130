
public class Documentation {
	/*	Grade Calculator
	 * 	
	 * 	This java project is a grade calculator that prompts users to enter the percentages each category counts towards their final grade. These percentages are then used as points during 
	 * 	the processing of the averages of each category. For example, if the final exam is worth 40% of the final grade, it will be worth 40 points. Any grade lower than 100 would yield lowers points. 
	 * 	These percentage variables are then added into an ArrayList named percentage in the same order as the categories were prompted
	 * 
	 * 	After, the users would be prompted to enter the category and percent grade. These string and double values are stored in their individual variables and in the end, they are used as arguments to make
	 * 	a Grades object. This object is then added into the universal ArrayList in the Main class. Characters are used for input to make it more user friendly in the console. Once users are done entering 
	 * 	their grades, they enter exit to exit out of the loop.
	 * 	  
	 *	Once the loop is broke, a calculateAvergaes() function is called which reads through the ArrayList one by one. It checks if the name of each object contains the values set. As we are using characters
	 *	which is 1 letter, the contains() method is a fail safe for a situation in which users press more than one key around the key they pressed. It then checks if the corresponding variable which stores
	 *	the double value is 0. If it is, it takes the grade from the object, divide by 100 to get a decimal and multiply it its corresponding percentage variable. This then will store the number of points
	 *	that category will get. To get the percentage of the category, you just need to divide the corresponding average variable by the corresponding percentage variable. If the variable is not 0, then it
	 *	goes through the same process as the previous step except this time we add that value to the original value stored in the variable and divide by 2 to find the average of both values. This new value 
	 *	is then stored in the variable. At the end of the function, all corresponding average variables are added into an ArrayList called average in the very specific order the percentages were added into
	 *	the percentage ArrayList
	 * 
	 * 	After, getGrade() is called to print out the percent and letter grade based on the inputed values. There are two double variables, one to store the number of points from the average variables and the 
	 * 	other to store the maximum number of points for each added category. A for loop is made to loop through the average ArrayList. If the value at each index is not 0, it adds the value to the num variable.
	 * 	Then it adds the corresponding value of the percentage variable with the same index in the percentage ArrayList. Afterwards, the num is divided by points and multiplied by 100 and stored in the 
	 * 	percentGrade variable. There are then if statements to convert the value in percentGrade to its corresponding letter grade. The letter is then stored in the letterGrade variable. At the end of the 
	 * 	function, the percent and letter grades are printed. 
	 * 
	 * 	Then, the user is prompted to enter the percent grade which they want for their final grade
	 * 
	 * 	desiredGrade() is called using the double value inputed by the user as the argument. First, it checks if the grade you want is lower than the grade you already have. Then it checks if the grade you have 
	 * 	equals the grade you have. Else, using the value, a number which is the difference between 100 and the argument is stored. This number is the minimum number of points that the user can lose. Then a 
	 * 	factor which is the number / 10 is made. Because each category has a different percentage, I wanted to have a ratio in which each category can lose points. Because the percentage adds up to 100, I set
	 * 	the dividend to 10 which the number is divided by. Then each category has their own ratio variable in which the their corresponding percentage is divided by 10 and multiplied to the factor. Then
	 * 	required variables are made to store the value each category needs to have at minimum. Then if statements are made to check if the average variables are greater than the value derived from the 
	 * 	difference between their percentage variables and their ratio variables. If they are, their required variables store the average variables values, else it stores the difference between the percentage 
	 * 	and ratio variables. For final exam, as there is only 1 final exam, if there is a value, then we don't do anything because they can't change the grade anymore. If there is no final exam, we find the 
	 * 	difference between the finalExamPercentage and finalExamRatio. Once all the variables are checked and stored, it checks if final exam has a value. If it does it prints out a String letting users know
	 * 	that their grade changed be changed further. Else it will print out the grade they currently have as well as the averages/grades for each category. Then a string containing their desired grade along
	 * 	with the values or percentages of each category that the user needs to have at minimum it printed. 
	 * 
	 * 	Grades.java
	 * 	Class used to store objects containing the category of the grade and the value of the grade. 
	 * 
	 * 	**To run the code, all that is required is to compile and run. This project is a console based interface.**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
