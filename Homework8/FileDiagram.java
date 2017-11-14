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
				
				for(int j = 0; j < tab; j++){
					textOutput.append("\t");
				}
				textOutput.append("|");
				textOutput.append("____" + list[i].getName() + "\n");
				directory(list[i], tab + 2);
			}
			else{
				
				for(int j = 0; j < tab; j++){
					textOutput.append("\t");
				}
				textOutput.append("|");
				textOutput.append("____" + list[i].getName() + "\n");
			}
		}
	}
}