/* 
Trivia_Game - Geography
By Andre Nonaka
2018/11/01
*/

import java.util.*; // import java.util package. * means everything. 
import java.io.*; // import java.io package. * means everything. 
public class TheGEOGRAPHY_GAME_Good // Declares the java file name as TheLOTRO_GAME_Good
{
  public static void main( String[] args ) throws Exception // Declares main and throws in an exception when reading the data file. 
  {
    Scanner input = new Scanner (System.in); // Declare and initializea scanner named input. 
    Scanner scan = new Scanner (new FileReader ("DATAGeo_questions.txt"));// Declares and initializes a scanner named scan that contains a data file to read. 
    Scanner scan2 = new Scanner (new FileReader ("DATAGeo_answers.txt"));// Declares and initializes a scanner named scan2 that contains a data file to read. 
    Scanner scan3 = new Scanner (new FileReader ("DATAHintGeo_answers.txt"));// Declares and initializes a scanner named scan3 that contains a data file to read. 
    ArrayList<String> quest = new ArrayList<String>();// Declares an String arraylist variable named quest. 
    ArrayList<String> ans = new ArrayList<String>();// Declares an String arraylist variable named ans. 
    ArrayList<String> hint = new ArrayList<String>();// Declares an String arraylist variable named hint. 
    ArrayList<Integer> num = new ArrayList<Integer>();// Declares an Integer array variable named num. 
    ArrayList<String> quest_display = new ArrayList<String>();// Declares an String arraylist variable named quest_display. 
    ArrayList<String> ans_questions = new ArrayList<String>();// Declares an String arraylist variable named ans_questions. 
    ArrayList<String> hint_questions = new ArrayList<String>();// Declares an String arraylist variable named hint_questions. 
    for (int jam = 0; jam < 8; jam++)//starts a for loop that will loop 8 times.
    {
      String question = scan.nextLine();// Reads the file that is store in the scanner, scan, and input the data that is read into a String variable named question. 
      quest.add(question);// add the values that are stored in the variable question into the arraylist named quest. 
      String answer = scan2.nextLine();// Reads the file that is store in the scanner, scan, and input the data that is read into a String variable named answer. 
      ans.add(answer);// add the values that are stored in the variable answer into the arraylist named ans. 
      String hinted = scan3.nextLine();// Reads the file that is store in the scanner, scan, and input the data that is read into a String variable named hinted. 
      hint.add(hinted);// add the values that are stored in the variable hinted into the arraylist named hint. 
    }
    int R_Num = 0;// declares and intializes a variable named R_Num with a initial value of 0. 
    int count = 0;// declares and intializes a variable named count with a initial value of 0. This will be our counter. 
    while (count < 8)// starts a while loop that will loop around the code, 8 times. 
    {
      R_Num = (int)(Math.random()*8);//stores random numbers from 0-7 into the variable R_Num.
      if(!num.contains(R_Num))// starts an if statement that states that if the arraylist, num, does not contain the random integer that is stored in R_Num, then add that value of R_Num into the arraylist named num. 
      {
        num.add(R_Num);
        count++;// increment counter named count. 
      }
    }
    System.out.println(num);// prints out the values stored in the arraylist named num. 
    String resp = ""; // declares and initializes a String variable named resp. 
    int score = 0, total = 0; // declares and initializes variables total, r and score with both having an initial value of 0.
    for (int s = 0; s < 8; s++)// start a for loop that will loop 8 times. 
    {
      int h = 0;// declares and initializes a variable named h with an initial value of 0.
      System.out.println("Q: " + quest.get(num.get(s)));// prints out question by getting the index number of the arraylist quest that is correlated to the index number of the arralist num. 
      resp = input.nextLine();// stores user answer in a String variable named resp. 
      h++;// increments the counter named h. 
      while(!resp.equalsIgnoreCase(ans.get(num.get(s))))// loops through this code as long as the answer is not equal to the answer that is stores in the arraylist ans. 
      {
        System.out.println("Incorrect.");
        System.out.println("Hint: " + hint.get(num.get(s)));
        resp = input.nextLine();
        h++;
        if (h == 4)// starts if statement that states that if counter h is 4 then print out the number of tries and the answer to the question, which will prompt the user to the next question, using break.  
        {
          System.out.println("Your tried this question " + h + " times.");
          System.out.println("You have exceeded the amount of tries allowed. You will be brought to the next question. The answer was " + ans.get(num.get(s)));
          break;
        }
      }
      if(resp.equalsIgnoreCase(ans.get(num.get(s))))// starts if statement that states that if the answer is correct then display "your answer is correct", the number of guesses and increment the counter named score. 
      {
        System.out.println("Your answer is correct!");
        System.out.println("You have guessed " + h + " time(s).");
        score++;
        System.out.println(score + "/8");// prints out the user's score out of 8 questions.
      }
    }
  total = total + score;// add the score to total and store it in a variable total.
  System.out.println("/////////////////////////////////////////////////////////// You reach the end of the GEOGRAPHY game!");// prints out "you reach the end of the LOTRO game!".
  System.out.println("Your total score is : " + total + " out of 8. ");
  Double end = (total / 8.0)*100.0;// find the final score by dividing total by 8 and multiplying the quotient by 100. 
  System.out.println("Your score percentage is " + end + "%");// prints out a statement saying your final score for the game. 
 }
}
  
