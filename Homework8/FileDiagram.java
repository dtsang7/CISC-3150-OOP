/*
*	Chipok Tsang
*
*	This program goes through a specified file system and outputs a tree diagram of all
*	the directories into a file called dir_tree.txt.
*
*/
import java.io.*;
public class FileDiagram{
	static FileWriter textOutput;
	
	public static void main(String[] args){
		try{
			textOutput = new FileWriter("dir_tree.txt");

			File currentDir = new File(".");
			String root = currentDir.getCanonicalFile().getName();
			textOutput.append(root + "\n");
			directory(currentDir, 1);
			textOutput.close();

		}catch(IOException ex){
			System.out.println("IOException caught");
		}
	}

	public static void directory(File dir, int tab) throws IOException{
		File directory = new File(dir.getPath());
		File [] list = directory.listFiles();

		if(list == null){
			return;
		}
		
		for(int i = 0; i < list.length; i++){
			if(list[i].getName().charAt(0) == '.'){
				//ignore;
			}
			else if(list[i].isDirectory()){
				for(int j = 1; j <= tab; j++){
					if(j%2 == 1){
						textOutput.append("\t");
						textOutput.append("|");

					}
					else{
						textOutput.append("\t");
					}
					
				}
				textOutput.append("____" + list[i].getName() + "\n");
				directory(list[i], tab + 2);
			}
			else{
				
				for(int j = 1; j <= tab; j++){
					if(j%2 == 1){
						textOutput.append("\t");
						textOutput.append("|");

					}
					else{
						textOutput.append("\t");
					}
					
				}
				textOutput.append("____" + list[i].getName() + "\n");
			}
		}
	}
}
