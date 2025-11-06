Model Solution: Java Decompiler - Password
-------------------------------------------------------------------------------

A) Analyze Storage Algorithm
    i) Extract JAR File
        $ mkdir tmp && cd tmp
        $ jar -xvf ../HardcodedPassword.jar

    ii) extract the hardcoded string iteral="VvnoWnioi8hjHGzu&56nm;:mkhjghfg"

    iii) extract the right substring:
        starting with: literal+10
        length:6*2

B) Extract Password
    => "hjHGzu&56nm;"

    $ java -cp HardcodedPassword.jar org.se.lab.CheckPassword
    password> hjHGzu&56nm;
    Welcome, you have entered a valid password!


public class CheckPassword {
    public CheckPassword() {
    }

    private static int constant() {
        return 2;
    }

    private static int len() {
        return 6 * constant();
    }

    private static String secret() {
        return "VvnoWnioi8hjHGzu&56nm;:mkhjghfg";
    }

    private static boolean validate(String password) {
        return secret().substring(10, 10 + len()).equals(password);
    }
    //...
}


