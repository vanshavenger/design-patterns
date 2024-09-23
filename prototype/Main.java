package prototype;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        DatabaseConnection db = new DatabaseConnection();

        db.setUrl("jdbc:mysql://localhost:3306/mydb");

        db.loadVeryImportantData();

        System.out.println(db);

        try {
            DatabaseConnection db1 = db.clone();
            db1.setUrl("jdbc:mysql://localhost:3306/anotherdb");
            System.out.println(db1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();

        }
    }
    
}
