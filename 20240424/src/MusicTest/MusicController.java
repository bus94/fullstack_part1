package MusicTest;

import java.util.ArrayList;

public class MusicController {

	private ArrayList<Music> list = new ArrayList<Music>();
	
	
	public void addList(Music newMusic) {
		list.add(newMusic);
	}
	
	public ArrayList<Music> getList() {
		return list;
	}

	
	
	
}
