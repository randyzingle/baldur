package com.bms.baldur.lambda;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Lambda1 {

	public static void main(String[] args) {
		Lambda1 lam = new Lambda1();
		lam.simple();
		lam.parameters();
	}
	
	private void simple() {
		// A lambda expression is an interface with a single abstract method
		// you can use it directly or assign it to as a reference of that interface type:	
		Runnable r = () -> System.out.println("running as a reference to a Runnable");
		Thread t = new Thread(r);
		t.start();
		
		// or as an anonymous type:
		new Thread(
				() -> System.out.println("running directly as a lambda expression")
		).start();
		
		// note the lambdas argument types (none in this case) and return type (void in this case) must
		// match the object.method reference that it is replacing
		
		// basically we're removing the object reference + method reference and just including the body
		// MyRunnable.run() become just the body of the run() method directly
	}
	
	private void parameters() {
		// now we'll try a method that requires parameters
		File f = new File("src/main/java/com/bms/baldur/lambda");
		String[] allNames = f.list(); // get all files in the above directory
		System.out.println(Arrays.asList(allNames));
		
		// Now will use boolean FilenameFilter.accept(File dir, String name) as a lambda
		String[] startsWithL = f.list( (File dir, String name) -> name.startsWith("L") );
		System.out.println(Arrays.asList(startsWithL));
	}

}
