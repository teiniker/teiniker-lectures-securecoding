-injars       ShoppingCart-1.0.0.jar
-outjars      ShoppingCart-1.0.0-out.jar
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

-printmapping ShoppingCart.map



