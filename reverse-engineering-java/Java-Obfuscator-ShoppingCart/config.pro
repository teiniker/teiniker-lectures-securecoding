-injars       ShoppingCart-1.0.0.jar
-outjars      ShoppingCart-1.0.0-release.jar
#-libraryjars  <java.home>/jmods
-libraryjars  <java.home>/jmods/java.base.jmod
-printmapping ShoppingCart.map

-optimizationpasses 3
-overloadaggressively
-repackageclasses ''
-allowaccessmodification

-keep public class org.se.lab.Main 
{
    public static void main(java.lang.String[]);
}