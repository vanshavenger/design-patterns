package command;

public class Main {
    public static void main (String[] args) {
        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();

        System.out.println(
                textFileOperationExecutor.executeOperation(new OpenTextFileOperation(new TextFile("file1.txt"))));

        System.out.println(
                textFileOperationExecutor.executeOperation(new SaveTextFileOperation(new TextFile("file2.txt"))));


        textFileOperationExecutor.readOperations();
    }
}