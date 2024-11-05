public class Main {
    public static void main(String[] args) {
        Video youtibeVideo = new YoutubeVideo(new HDProcessor());
        youtibeVideo.process("a.mp4");

        Video primeVideo = new PrimeVideo(new UHD4KProcessor());
        primeVideo.process("b.mp4");
    }
}