/*Name: Yifeng Zheng
 * The purpose of this Java project was to intake a csv file, code a program to read the file and out put a new file with the artist name, their songs if there are multiple and the number of 
 * appearances in the ranking. The csv file is based on the global weekly spotify ranking of 08-28-2020. 
 * The class Artist.java was made with the intention of storing tha data from the input file such as the name, song, hits, url, and ranking.
 * readFile.java is the main class that runs the code to perform desired outcomes.
 * A static String[][] array and a List is made with intent of storing the information read from the file
 * Lines 18-44 is made to use a scanner and read the input file. The code was custom made for the information in the file. It isn't applicable for other files. 
 * The process:
 * 1. A String variable takes in a line provided by the scanner from the file.
 * 2. An Artist object is initiated
 * 3. A String[] is used to store the information from the line and each index stores information seperated by a ","
 * 4. The variables such as name are set to the Artist object based on the index.
 * 5. Afterwards, the object is stored into the list made beforehand.
 * 6. The process loops until there isn't anymore line read from the scanner
 * 7. close scanner
 * 8. initalize the 2D array and input the information from the list with each index an artist and for the other dimension their information
 * Lines 45-61
 * The commented out lines of code are/were used to test that the information from the file was properly transfered to the list and 2D array.
 * Lines 62-74
 * These lines of code makes a new 2D array from the list and stores the desired information. In my case, I wanted to store the artist name, artist song/songs, and the number of times they've
 * appeared on the spotify ranking.
 * The following for loops are made to properly print out the 2D array
 * Line 75, a new list is made from the 2D array
 * Line 76-83
 * These lines of code was made to write the list made in line 75 into a new madde file named "Weekly_Spotify_Rankings_08282020.csv"
 * line 84, i used a method I made to read the newly made file and print out the information as desired
 * Line 87-104
 * The method countArtist takes in a List as a parameter and returns a 2D String array.
 * 1. A new list is made in the method
 * 2. If the list does not contain the name of the artist, the name of the artist is added to the list.
 * 3. A String[][] array is made to store the information from the new list as well as other
 * 4. The first index of the array is used to store the outline of the array such as Artist, songs, and number of appearances
 * 5. For the rest of the list starting from index 1, the name of the artist, their songs from a method made to concatonate their songs from the original list, and the number of appearances from a 
 * method I made called countDuplicates()
 * 6. return the array
 * Lines 106-114
 * 1. A count variable is made with initial value of 0
 * 2. A for loop is made to run through the whole list
 * 3. If the String variable is equal to the name from the object from the list, the count variable increments
 * 4. return the count
 * Lines 116-124
 * 1. A String variable is made
 * 2. A for loop is made to run through the whole list
 * 3. If the artist name is equal to the object.name from the list, the song name is concatonated with the songName variable and the song name from the object
 * 4. return variable
 * Lines 126-136
 * Purpose of these lines of code was to convert the information from the 2D array into a new List and return it
 * Lines 138-173
 * Purpose of these lines of code is use a file as a parameter and print out the information from the file
 */
