package adapter;

public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer amp;
	
	public MediaAdapter(String mediaType) {
		if (mediaType.equalsIgnoreCase("VLC")) {
			amp = new VlcFile();
		} else if (mediaType.equalsIgnoreCase("MP4")) {
			amp = new Mp4File();
		}
	}
	
	@Override
	public void play(String mediaType, String fileName) {
		
		if (mediaType.equalsIgnoreCase("VLC")) {
			amp.playVLC(fileName);
		} else if (mediaType.equalsIgnoreCase("MP4")) {
			amp.playMP4(fileName);
		}
	}

}
