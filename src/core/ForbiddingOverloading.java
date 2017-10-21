package core;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ForbiddingOverloading {

	public static void main(String[] args) {
	       try{
				Method[] methods=Add.class.getDeclaredMethods();
				Set<String> set=new HashSet<>();
				boolean overload=false;
				for(int i=0;i<methods.length;i++)
				{
					if(set.contains(methods[i].getName()))
					{
						overload=true;
						break;
					}
					set.add(methods[i].getName());
					
				}
				if(overload)
				{
					throw new Exception("Overloading not allowed");
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
	}