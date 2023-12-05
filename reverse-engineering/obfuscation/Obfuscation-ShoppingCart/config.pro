-injars       ShoppingCart-Dev.jar
-outjars      ShoppingCart-Release.jar
#-libraryjars  <java.home>/jmods
-libraryjars  <java.home>/jmods/java.base.jmod

-keep public class org.se.lab.Main
{
    public static void main(java.lang.String[]);
}

-optimizationpasses 3
-overloadaggressively
-repackageclasses ''
-allowaccessmodification

-printmapping obfuscation.map



