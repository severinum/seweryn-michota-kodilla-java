package com.kodilla.stream.lambda.moje_lambda_param_names;

public class Test {

    public static void main(String[] args) {
        UserNameExecutor userNameExecutor = new UserNameExecutor();
        String fnameLname  = userNameExecutor.processNames("Adam", "Smith", (fname, lname) -> fname + " " + lname );
        String lnameFname = userNameExecutor.processNames("Adam", "Smith" , (fname, lname) -> lname + " " + fname );

        String manipulatedNames = userNameExecutor.processNames("Christopher", "McAllister" , (fname, lname) -> {
            if (fname.length() > 6) {
                fname = fname.substring(0,1) + ".";
            }
            return fname + " " + lname;
        } );

        System.out.println(fnameLname);
        System.out.println(lnameFname);
        System.out.println(manipulatedNames);
    }
}
