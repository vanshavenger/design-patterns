package prototype;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    private String url;
    private String imp_data;
    private List<String> domains = new ArrayList<>();

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImp_data() {
        return imp_data;
    }

    public void setImp_data(String imp_data) {
        this.imp_data = imp_data;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }
    

    public void loadVeryImportantData() {
        this.imp_data = "Very important data";

        domains.add("google.com");
        domains.add("facebook.com");
        domains.add("twitter.com");
        domains.add("instagram.com");
        // Simulate a long process

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.url + " " + this.imp_data + " " + this.domains;
    }

    @Override
    public DatabaseConnection clone() throws CloneNotSupportedException {
        DatabaseConnection db = new DatabaseConnection();
        db.setUrl(this.url);
        db.setImp_data(this.imp_data);

        List<String> domains = new ArrayList<>();

        for (String domain : this.domains) {
            domains.add(domain);
        }

        db.setDomains(domains);
        return db;
    }
    





    
    
}
