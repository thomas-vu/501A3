import java.util.*;
import java.lang.reflect.*;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Serializer
{
	public Serializer()
	{
		
	}
	
	public org.jdom2.Document serialize(Object obj)
	{		
		Class objClass = obj.getClass();
		int id = obj.hashCode();
		
		Element rootElement = new Element("serialized");
		Element objectElement = new Element("object");
		objectElement.setAttribute("class", objClass.getName());
		objectElement.setAttribute("id", Integer.toString(id));
		rootElement.addContent(objectElement);

		Field[] fields = objClass.getDeclaredFields();
		for (Field field : fields)
		{
			Element fieldElement = new Element("field");
			fieldElement.setAttribute("name", field.getName());
			fieldElement.setAttribute("declaringclass", field.getDeclaringClass().getName());
			objectElement.addContent(fieldElement);
			
			try
			{
				field.setAccessible(true);
				Object value = field.get(obj);
				try
				{
					if (value.getClass().isPrimitive() || isWrapper(value.getClass())) 
					{
						Element valueElement = new Element("value");
						valueElement.addContent(field.get(obj).toString());
						fieldElement.addContent(valueElement);
					}
					else if (value.getClass().isArray())
					{
						Element arrayElement = new Element("object");
						arrayElement.setAttribute("class", field.getClass().getName());
						arrayElement.setAttribute("id", Integer.toString(value.hashCode()));
						arrayElement.setAttribute("length", Integer.toString(Array.getLength(value)));
						for (int i = 0; i < Array.getLength(value); i++)
						{
							Element valueElement = new Element("value");
							valueElement.addContent(Array.get(value, i).toString());
							arrayElement.addContent(valueElement);
						}
						rootElement.addContent(arrayElement);
					}
					else
					{
						Element referenceElement = new Element("reference");
						referenceElement.addContent(Integer.toString(field.hashCode()));
						fieldElement.addContent(referenceElement);
					}
				}
				catch (NullPointerException e) { System.out.println("     " + field.getName() + " = null"); }
			}
			catch (Exception e) { e.printStackTrace(); }
		}

		return new Document(rootElement);
	}
	
	// Author: https://stackoverflow.com/questions/709961/determining-if-an-object-is-of-primitive-type
	private static final Set<Class> WRAPPERS = new HashSet(Arrays.asList(Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Void.class));
	public static boolean isWrapper(Class c) { return WRAPPERS.contains(c); }
	
}