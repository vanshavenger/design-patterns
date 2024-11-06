public class Main {
    public static void main(String[] args) {
        TextFileOperationExecutor textFileOperatorExecutor = new TextFileOperationExecutor();
       

        textFileOperatorExecutor.executeOperation(
            new OpenTextFileOperation(new TextFile("file1.txt"))
        );

        textFileOperatorExecutor.executeOperation(
            new SaveTextFileOperation(new TextFile("file2.txt"))
        );
    }
}