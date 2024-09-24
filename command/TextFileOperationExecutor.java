package command;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vanshchopra
 */


public class TextFileOperationExecutor {

    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }
    
    public void readOperations(){
        for(TextFileOperation textFileOperation : textFileOperations){
            System.out.println(textFileOperation);
        }
    }

}
