package adapter;

public class Mp3File implements MediaPlayer {

	MediaAdapter adapter;
	
	@Override
	public void play(String mediaType, String fileName) {
		if (mediaType.equalsIgnoreCase("MP3")) {
			System.out.println("The MP3 file "+fileName+" is playing.");
		} else if (mediaType.equalsIgnoreCase("VLC") || mediaType.equalsIgnoreCase("MP4")) {
			adapter = new MediaAdapter(mediaType);
			adapter.play(mediaType, fileName);
		} else {
			System.out.println("Unrecognised format "+mediaType);
		}
	}
}
