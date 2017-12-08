/*
*	Chipok Tsang
*
*	This progam handles plugins. It searches and list the plugins available from the
*	plugin directory. The user enters the plugin name from the list and the program runs
*	the functions of those plugins.
*/

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class PluginSelector{
	
	public static void main(String[] args) throws Throwable{

		File pluginFolder = new File("./plugin");
		File[] plugins = pluginFolder.listFiles();
		ArrayList<String> pluginNames = new ArrayList<String>();

		for(File f : plugins){
			String name = f.getCanonicalFile().getName();
			if(name.contains(".java") && !name.equalsIgnoreCase("myplugin.java")){
				pluginNames.add(name.substring(0, name.length() - 5));
			}
		}

		Scanner in = new Scanner(System.in);

		System.out.println("Type in the name of the plugin you want from the list below: ");
		for(String f: pluginNames){
			System.out.println(f);
		}
		String input = "";

		while(in.hasNext()){
			input = in.next();
			boolean exists = false;

			for(String f: pluginNames){
				if(input.equalsIgnoreCase(f)){
					exists = true;
					input = f;
					break;
				}
			}
			if(exists){
				break;
			}
			else{
				System.out.println("Plugin not found. Please enter a plugin from the list.");
			}

		}
		System.out.println(input + " has been selected.");

		Class<?> pluginClass = Class.forName("plugin." + input);
		Object pluginInstance = pluginClass.newInstance();

		Method helloMethod = pluginClass.getMethod("whoSaysHello");
		Method byeMethod = pluginClass.getMethod("whoSaysBye");

		helloMethod.invoke(pluginInstance);
		byeMethod.invoke(pluginInstance);

	}
}
