package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Creatures.Creature;

public class SaveState {

	public static void save() throws IOException 
	{
		FileOutputStream save = new FileOutputStream("lvlSave.xml");
		ObjectOutputStream outputStream = new ObjectOutputStream(save);
		outputStream.writeObject(Screen.GameScreen.world);
		outputStream.writeObject(Screen.GameScreen.player);
		outputStream.close();
		save.close();
		System.out.println("The game was saved!");
		return;
	}
	
	//loads a savefile
	@SuppressWarnings("unchecked")
	public static void load() throws IOException, ClassNotFoundException 
	{
		FileInputStream save = new FileInputStream("lvlSave.xml");
		ObjectInputStream inputStream = new ObjectInputStream(save);
		Screen.GameScreen.world = (World) inputStream.readObject();
		Screen.GameScreen.player = (Creature) inputStream.readObject();
		inputStream.close();
		save.close();
		System.out.println("The game was loaded!");
		return;
	}
	

	public static void deleteSave() 
	{
		File saveFile = new File("lvlSave.xml");
		saveFile.delete();
	}
}
