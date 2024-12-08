Exercise: Obfuscation - Hardcoded Password
-------------------------------------------------------------------------------

From decompiling the obfuscated JAR file, we can learn:
- CheckPassword.main() is not obfuscated, because it is the entry point
    of the application.
- String literals are also not obfuscated (bad news for hardcoded passwords
    and keys).

Decompiled code:
public class Main {
   public static void main(String[] var0) {
      Scanner var2 = new Scanner(System.in);
      System.out.print("password> ");
      String var1 = var2.next();
      new .a();
      if ("VvnoWnioi8hjHGzu&56nm;:mkhjghfg".substring(10, 22).equals(var1)) {
         System.out.println("Welcome, you have entered a valid password!");
      } else {
         System.out.println("Login rejected, invalid password!");
      }

      var2.close();
   }
}

Password:
"VvnoWnioi8hjHGzu&56nm;:mkhjghfg"
 0123456789012345678901234567890
=> "hjHGzu&56nm;"
