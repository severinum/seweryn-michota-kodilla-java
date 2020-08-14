package com.kodilla.stream.lambda.moje_lambda_param_names;

public class UserNameExecutor {

    public String processNames(String fname, String lname, UserNamesManipulatorInterface userNamesManipulatorInterface){
        String processedStr = userNamesManipulatorInterface.processStrings(fname, lname);
        return processedStr;
    }
}
