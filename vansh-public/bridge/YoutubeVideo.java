public class YoutubeVideo extends Video {
    public YoutubeVideo(VideoProcessor processor) {
        super(processor);
    }

    @Override
    public void process(String video) {
        System.out.println("Processing " + video + " in Youtube");
        processor.process(video);
    }
    
}
