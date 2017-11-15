import java.util.*;

public class ObjectCreator
{
	public ObjectCreator()
	{
		
	}
	
	public Object createObject()
	{
		Scanner sc = new Scanner(System.in);

		//ArrayOfPrimitives arrayOfPrimitives;
		//ArrayOfReferences arrayOfReferences;
		//CollectionInstance collectionInstance;
		
		System.out.println("Which object would you like to create?");
		System.out.println("1. Simple object");
		System.out.println("2. Object with references to other objects");
		System.out.println("3. Object with array of primitives");
		System.out.println("4. Object with array of references");
		System.out.println("5. Object using collection instance");
		int objectChoice = sc.nextInt();
		
		if (objectChoice == 1)
		{
			SimpleObject simpleObject = new SimpleObject();
			int fieldChoice = 0;
			while (fieldChoice != 4)
			{
				System.out.println("Set a field?");
				System.out.println("1. int intVal = " + simpleObject.intVal);
				System.out.println("2. float floatVal = " + simpleObject.floatVal);
				System.out.println("3. boolean booleanVal = " + simpleObject.booleanVal);
				System.out.println("4. Done");
				fieldChoice = sc.nextInt();
				
				if (fieldChoice == 1) {System.out.println("Enter an integer value: "); simpleObject.intVal = sc.nextInt();}
				if (fieldChoice == 2) {System.out.println("Enter a float value: "); simpleObject.floatVal = sc.nextFloat();}
				if (fieldChoice == 3) {System.out.println("Enter a boolean value: "); simpleObject.booleanVal = sc.nextBoolean();}				
			}
			sc.close();
			return simpleObject;
		}
		
		if (objectChoice == 2)
		{
			ReferencesObjects referencesObjects = new ReferencesObjects();
			int fieldChoice = 0;
			while (fieldChoice != 4)
			{
				System.out.println("Set simple object's fields?");
				System.out.println("1. int simple.intVal = " + referencesObjects.simple.intVal);
				System.out.println("2. float simple.floatVal = " + referencesObjects.simple.floatVal);
				System.out.println("3. boolean simple.booleanVal = " + referencesObjects.simple.booleanVal);
				System.out.println("4. Done");
				fieldChoice = sc.nextInt();
				
				if (fieldChoice == 1) {System.out.println("Enter an integer value: "); referencesObjects.simple.intVal = sc.nextInt();}
				if (fieldChoice == 2) {System.out.println("Enter a float value: "); referencesObjects.simple.floatVal = sc.nextFloat();}
				if (fieldChoice == 3) {System.out.println("Enter a boolean value: "); referencesObjects.simple.booleanVal = sc.nextBoolean();}				
			}
			sc.close();
			return referencesObjects;
		}
		
		sc.close();
		return null;
	}
}
