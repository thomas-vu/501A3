import java.util.*;

public class ObjectCreator
{
	public ObjectCreator()
	{
		
	}
	
	public Object createObject()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Which object would you like to create?");
		System.out.println("1. Simple object");
		System.out.println("2. Object with references to other objects");
		System.out.println("3. Object with array of primitives");
		System.out.println("4. Object with array of references");
		System.out.println("5. Object using collection instance");
		int objectChoice = sc.nextInt();
		
		if (objectChoice == 1) return createSimpleObject(sc);
		else if (objectChoice == 2) return createReferencesObjects(sc);
		else if (objectChoice == 3) return createArrayOfPrimitives(sc);		
		else if (objectChoice == 4)
		{
			ArrayOfReferences arrayOfReferences = new ArrayOfReferences();
			sc.close();
			return arrayOfReferences;
		}
		
		else
		{
			CollectionInstance collectionInstance = new CollectionInstance();
			sc.close();
			return collectionInstance;
		}
	}
	
	public Object createSimpleObject(Scanner sc)
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
		return simpleObject;
	}
	
	public Object createReferencesObjects(Scanner sc)
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
		return referencesObjects;
	}
	
	public Object createArrayOfPrimitives(Scanner sc)
	{
		ArrayOfPrimitives arrayOfPrimitives = new ArrayOfPrimitives();
		int fieldChoice = 0;
		while (fieldChoice != 4)
		{
			System.out.println("Set array values?");
			System.out.println(Arrays.toString(arrayOfPrimitives.primitiveArray));
			System.out.println("1. Index 0 = " + arrayOfPrimitives.primitiveArray[0]);
			System.out.println("2. Index 1 = " + arrayOfPrimitives.primitiveArray[1]);
			System.out.println("3. Index 2 = " + arrayOfPrimitives.primitiveArray[2]);
			System.out.println("4. Done");
			fieldChoice = sc.nextInt();
			
			if (fieldChoice == 1) {System.out.println("Enter an integer value: "); arrayOfPrimitives.primitiveArray[0] = sc.nextInt();}
			if (fieldChoice == 2) {System.out.println("Enter an integer value: "); arrayOfPrimitives.primitiveArray[1] = sc.nextInt();}
			if (fieldChoice == 3) {System.out.println("Enter an integer value: "); arrayOfPrimitives.primitiveArray[2] = sc.nextInt();}				
		}
		return arrayOfPrimitives;
	}
	
}
