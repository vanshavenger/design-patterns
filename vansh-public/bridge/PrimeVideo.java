public class PrimeVideo extends Video {
    public PrimeVideo(VideoProcessor processor) {
        super(processor);
    }

    @Override
    public void process(String video) {
        System.out.println("Processing " + video + " in Prime Video");
        processor.process(video);
    }
    
}
