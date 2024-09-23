package prototype;

public class DatabaseConnection {

    private String url;
    private String imp_data;

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
    
    public void loadVeryImportantData() {
        this.imp_data = "Very important data";
    }

    @Override
    public String toString() {
        return this.url + " " + this.imp_data;
    }

    @Override
    public DatabaseConnection clone() throws CloneNotSupportedException {
        DatabaseConnection db = new DatabaseConnection();
        db.setUrl(this.url);
        db.setImp_data(this.imp_data);
        return db;
    }
    





    
    
}
