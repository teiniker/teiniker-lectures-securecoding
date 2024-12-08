Model Solution: Java Decompiler - Password
-------------------------------------------------------------------------------

A) Extract JAR File
    $ mkdir tmp && cd tmp
    $ jar -xvf ../HardcodedPassword.jar

A) Extract Password from decompiled code: "hjHGzu&56nm;"
    $ java -cp HardcodedPassword.jar org.se.lab.CheckPassword
    password> hjHGzu&56nm;
    Welcome, you have entered a valid password!

B) Storage Algorithm
    i) extract the hardcoded string iteral="VvnoWnioi8hjHGzu&56nm;:mkhjghfg"
    ii) extract the right substring:
        starting with: literal+10
        length:6*2
        => "hjHGzu&56nm;"

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
