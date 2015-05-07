package adapter;

public class AdapterDemo {

	public static void main(String[] args) {
		
		Mp3File mp3 = new Mp3File();
		mp3.play("mp3", "test.mp3");
		mp3.play("mp4", "test.mp4");
		mp3.play("vlc", "test.vlc");
		mp3.play("avi", "test.avi");
	}
}
