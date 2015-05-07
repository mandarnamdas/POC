package adapter;

public class Mp4File implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playMP4(String fileName) {
		System.out.println("The MP4 file "+fileName+" is playing.");		
	}
}
