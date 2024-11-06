public class Main {
    public static void main(String[] args) {
        
        NewsAgency observable = new NewsAgency();
        NewsChannel observer1 = new NewsChannel();
        NewsChannel observer2 = new NewsChannel();

        observable.addObserver(observer1);
        observable.addObserver(observer2);



        observable.setNews("news");

        
        System.out.println(observer1.getNews());

        observable.removeObserver(observer1);

        observable.setNews("news2");

        System.out.println(observer2.getNews());
    }
    
}
