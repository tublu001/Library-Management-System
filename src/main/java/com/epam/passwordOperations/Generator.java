package com.epam.passwordOperations;


public class Generator 
{
	
	
//	public Generator(boolean IncludeUpper,boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
//		alphabet=new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
//	}
	
//	public Generator(PreferredPassword prefPass)
//	{}
	
	public String generatePassword(PreferredPassword prefPass) 
	{
		boolean IncludeUpper=prefPass.isIncludeUpper();
		boolean IncludeLower=prefPass.isIncludeLower();
		boolean IncludeNum=prefPass.isIncludeNum();
		boolean IncludeSym=prefPass.isIncludeSym();
		int length=prefPass.getLength();
		Alphabet alphabet;
		
		alphabet=new Alphabet(IncludeUpper , IncludeLower, IncludeNum, IncludeSym);
		
		final StringBuilder pass = new StringBuilder("");

		final int alphabetLength = alphabet.getAlphabet().length();
		
		int max = alphabetLength - 1; 
        int min = 0; 
        int range = max - min + 1; 
        
		
		
		for(int i=0;i<length;i++) {
			
			int index=(int)(Math.random() * range) + min; 
			
			pass.append(alphabet.getAlphabet().charAt(index));
		}
		
		return pass.toString();
		
	}
	
	
//	public static void printUsefulInfo() {
//		System.out.println();
//		System.out.println("Use a minimum password length of 8 or more characters if permitted");
//		System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
//		System.out.println("Generate passwords randomly where feasible");
//		System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
//		System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences,\nusernames, relative or pet names, romantic links (current or past) and biographical information (e.g., ID numbers, ancestors' names or dates).");
//		System.out.println("Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user");
//		System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
//	}
	
	
	
	
//	
//	public static void checkPassword() {
//		String input;
//		final Scanner in = new Scanner(System.in);
//
//		System.out.print("\nEnter your password:");
//		input = in.nextLine();
//		
//		final Password p = new Password(input);
//		
//		System.out.println(p.calculateScore());
//		
//		in.close();
//	}
//	
//	public static void printMenu() {
//		System.out.println();
//		System.out.println("Enter 1 - Password Generator");
//		System.out.println("Enter 2 - Password Stength Check");
//		System.out.println("Enter 3 - Useful Information");
//		System.out.println("Enter 4 - Quit");
//		System.out.print("Choice:");
//	}
//	
//	public static void main(String[] args) {
//		String Input;
//		final Scanner in = new Scanner(System.in);
//		System.out.println("Welcome to Ziz Password Services :)" );
//		printMenu();
//		while (in.hasNextLine()) {
//			
//			Input = in.nextLine();
//			
//			if (Input.equals("1")) {
//				requestPassword();
//				printMenu();
//			}
//			
//			else if (Input.equals("2")) {
//				checkPassword();
//				printMenu();
//			}
//			
//			else if (Input.equals("3")) {
//				printUsefulInfo();
//				printMenu();
//			}
//			
//			else if (Input.equals("4")) {
//				break;
//			}
//
//			else {
//				System.out.println();
//				System.out.println("Kindly select one of the available commands" );	
//				printMenu();
//			}
//		}
//		in.close();
//	}






}
