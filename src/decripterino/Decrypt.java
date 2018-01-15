/*Noah lattari
 * CPS 109
 * November 2 2016
 * Ryerson University 
 * This program decrypts the text given in "input.txt"
 * and produces the result in a created file "output.txt"
 */



package decripterino;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

public class Decrypt {

	public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
	public static int rand1;
	public static int rand2;
	public static char char1;
	public static char char2;
	public static String newAlpha = alphabet;
	public static String result;
	public static String finalResult;
	public static String newLine;

	public static void main(String args[]) throws Exception {

		/*
		 * 
		 * Begin Part 1
		 * 
		 * Read Input file / Change to uppercase
		 */
		
		PrintStream out = new PrintStream(new
		FileOutputStream("output.txt")); System.setOut(out);
		 

		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		newLine = br.readLine().toUpperCase();

		br.close();

		for (int j = 0; j < newLine.length(); j++) {
			char charLine = newLine.charAt(j);

			if (Character.isLetter(charLine) == false) {
				newLine = newLine.replace(charLine, ' ');
			}
		}

		/*
		 * 
		 * Begin Part 2A
		 * 
		 * Transposition - find order of numerical pattern
		 * 
		 */
		
		String key = "ABCDEFGH";
		int hash = key.hashCode();
		Random random = new Random(hash);
		//Switches the numbers 100 times 
		int[] pattern = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int[] newPattern = pattern;
		int rand3;
		int rand4;
		int temp;
		for (int i = 0; i < 100; i++) {

			rand3 = random.nextInt(8);
			rand4 = random.nextInt(8);
			temp = newPattern[rand3];
			newPattern[rand3] = newPattern[rand4];
			newPattern[rand4] = temp;
		}

		/*
		 * 
		 * Begin Part 2B
		 * 
		 * Transposition - Re-order letters
		 * 
		 */

		Decrypt.Decryption();

		/*
		 * 
		 * Begin Part 3
		 * 
		 * Substitution - Letter switching combination
		 * 
		 * 
		 */

		random = new Random(hash);
		//Generates the encrypted alphabet.
		for (int i = 0; i < 100; i++) {

			rand1 = random.nextInt(27);
			rand2 = random.nextInt(27);
			char1 = newAlpha.charAt(rand1);
			char2 = newAlpha.charAt(rand2);

			if (rand1 > rand2) {
				newAlpha = newAlpha.substring(0, rand2) + char1 + newAlpha.substring(rand2 + 1, rand1) + char2
						+ newAlpha.substring(rand1 + 1, newAlpha.length());
			} else if (rand1 < rand2) {
				newAlpha = newAlpha.substring(0, rand1) + char2 + newAlpha.substring(rand1 + 1, rand2) + char1
						+ newAlpha.substring(rand2 + 1, newAlpha.length());
			}
		}

		/*
		 * 
		 * Final Part
		 * 
		 * Print out decrypted statement
		 */

		String finalResult = new String(Decrypt.Substitution(result));
		System.out.println(finalResult);

	}

	public static char[] Substitution(String result) {
		//Find the first occurance of each letter in the encrypted message 
		char[] resultArray = result.toCharArray();

		int intA = newAlpha.indexOf('A');
		int intB = newAlpha.indexOf('B');
		int intC = newAlpha.indexOf('C');
		int intD = newAlpha.indexOf('D');
		int intE = newAlpha.indexOf('E');
		int intF = newAlpha.indexOf('F');
		int intG = newAlpha.indexOf('G');
		int intH = newAlpha.indexOf('H');
		int intI = newAlpha.indexOf('I');
		int intJ = newAlpha.indexOf('J');
		int intK = newAlpha.indexOf('K');
		int intL = newAlpha.indexOf('L');
		int intM = newAlpha.indexOf('M');
		int intN = newAlpha.indexOf('N');
		int intO = newAlpha.indexOf('O');
		int intP = newAlpha.indexOf('P');
		int intQ = newAlpha.indexOf('Q');
		int intR = newAlpha.indexOf('R');
		int intS = newAlpha.indexOf('S');
		int intT = newAlpha.indexOf('T');
		int intU = newAlpha.indexOf('U');
		int intV = newAlpha.indexOf('V');
		int intW = newAlpha.indexOf('W');
		int intX = newAlpha.indexOf('X');
		int intY = newAlpha.indexOf('Y');
		int intZ = newAlpha.indexOf('Z');
		int int0 = newAlpha.indexOf(' ');
		//Switches the letter found with its corresponding alphabet code
		for (int n = 0; n < result.length(); n++) {
			if (resultArray[n] == 'A') {
				resultArray[n] = alphabet.charAt(intA);
			} else if (resultArray[n] == 'B') {
				resultArray[n] = alphabet.charAt(intB);
			} else if (resultArray[n] == 'C') {
				resultArray[n] = alphabet.charAt(intC);
			} else if (resultArray[n] == 'D') {
				resultArray[n] = alphabet.charAt(intD);
			} else if (resultArray[n] == 'E') {
				resultArray[n] = alphabet.charAt(intE);
			} else if (resultArray[n] == 'F') {
				resultArray[n] = alphabet.charAt(intF);
			} else if (resultArray[n] == 'G') {
				resultArray[n] = alphabet.charAt(intG);
			} else if (resultArray[n] == 'H') {
				resultArray[n] = alphabet.charAt(intH);
			} else if (resultArray[n] == 'I') {
				resultArray[n] = alphabet.charAt(intI);
			} else if (resultArray[n] == 'J') {
				resultArray[n] = alphabet.charAt(intJ);
			} else if (resultArray[n] == 'K') {
				resultArray[n] = alphabet.charAt(intK);
			} else if (resultArray[n] == 'L') {
				resultArray[n] = alphabet.charAt(intL);
			} else if (resultArray[n] == 'M') {
				resultArray[n] = alphabet.charAt(intM);
			} else if (resultArray[n] == 'N') {
				resultArray[n] = alphabet.charAt(intN);
			} else if (resultArray[n] == 'O') {
				resultArray[n] = alphabet.charAt(intO);
			} else if (resultArray[n] == 'P') {
				resultArray[n] = alphabet.charAt(intP);
			} else if (resultArray[n] == 'Q') {
				resultArray[n] = alphabet.charAt(intQ);
			} else if (resultArray[n] == 'R') {
				resultArray[n] = alphabet.charAt(intR);
			} else if (resultArray[n] == 'S') {
				resultArray[n] = alphabet.charAt(intS);
			} else if (resultArray[n] == 'T') {
				resultArray[n] = alphabet.charAt(intT);
			} else if (resultArray[n] == 'U') {
				resultArray[n] = alphabet.charAt(intU);
			} else if (resultArray[n] == 'V') {
				resultArray[n] = alphabet.charAt(intV);
			} else if (resultArray[n] == 'W') {
				resultArray[n] = alphabet.charAt(intW);
			} else if (resultArray[n] == 'X') {
				resultArray[n] = alphabet.charAt(intX);
			} else if (resultArray[n] == 'Y') {
				resultArray[n] = alphabet.charAt(intY);
			} else if (resultArray[n] == 'Z') {
				resultArray[n] = alphabet.charAt(intZ);
			} else if (resultArray[n] == ' ') {
				resultArray[n] = alphabet.charAt(int0);
			}

		}

		return resultArray;
	}

	public static String Decryption() {
		//Assignes letters to immaginary 8x8 table
		String column0 = newLine.substring(40, 48);
		String column1 = newLine.substring(32, 40);
		String column2 = newLine.substring(8, 16);
		String column3 = newLine.substring(0, 8);
		String column4 = newLine.substring(24, 32);
		String column5 = newLine.substring(48, 56);
		String column6 = newLine.substring(56, 64);
		String column7 = newLine.substring(16, 24);

		String row0;
		String row1;
		String row2;
		String row3;
		String row4;
		String row5;
		String row6;
		String row7;
		//Manually build the rows from the table
		row0 = "" + column0.charAt(0) + column1.charAt(0) + column2.charAt(0) + column3.charAt(0) + column4.charAt(0)
				+ column5.charAt(0) + column6.charAt(0) + column7.charAt(0);
		row1 = "" + column0.charAt(1) + column1.charAt(1) + column2.charAt(1) + column3.charAt(1) + column4.charAt(1)
				+ column5.charAt(1) + column6.charAt(1) + column7.charAt(1);
		row2 = "" + column0.charAt(2) + column1.charAt(2) + column2.charAt(2) + column3.charAt(2) + column4.charAt(2)
				+ column5.charAt(2) + column6.charAt(2) + column7.charAt(2);
		row3 = "" + column0.charAt(3) + column1.charAt(3) + column2.charAt(3) + column3.charAt(3) + column4.charAt(3)
				+ column5.charAt(3) + column6.charAt(3) + column7.charAt(3);
		row4 = "" + column0.charAt(4) + column1.charAt(4) + column2.charAt(4) + column3.charAt(4) + column4.charAt(4)
				+ column5.charAt(4) + column6.charAt(4) + column7.charAt(4);
		row5 = "" + column0.charAt(5) + column1.charAt(5) + column2.charAt(5) + column3.charAt(5) + column4.charAt(5)
				+ column5.charAt(5) + column6.charAt(5) + column7.charAt(5);
		row6 = "" + column0.charAt(6) + column1.charAt(6) + column2.charAt(6) + column3.charAt(6) + column4.charAt(6)
				+ column5.charAt(6) + column6.charAt(6) + column7.charAt(6);
		row7 = "" + column0.charAt(7) + column1.charAt(7) + column2.charAt(7) + column3.charAt(7) + column4.charAt(7)
				+ column5.charAt(7) + column6.charAt(7) + column7.charAt(7);

		result = "" + row0 + row1 + row2 + row3 + row4 + row5 + row6 + row7;

		return result;
	}

}
