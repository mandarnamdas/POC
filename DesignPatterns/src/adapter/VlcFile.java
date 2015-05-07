package adapter;

public class VlcFile implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String fileName) {
		System.out.println("The VLC file "+fileName+" is playing.");
	}

	@Override
	public void playMP4(String fileName) {
		// TODO Auto-generated method stub
		
	}

}
