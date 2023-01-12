Example: java.util.PropertyPermission
-------------------------------------------------------------------------------
This simple Java program reads the value of the user.home system property. 

public class PropertyPermission
{
    public static void main(String[] args)
    {
        String p = System.getProperty("user.home"); 
        System.out.println(p);

    }
}

If we execute this program locally, we will get the following output:

$ java -cp ./target/classes org.se.lab.PropertyPermission
/home/student

If we start the program with a SecurityManager and a restrictive policy file, 
we can restrict the access to the user.home system properties:

$ java -cp ./target/classes -Djava.security.manager org.se.lab.PropertyPermission

Exception in thread "main" java.security.AccessControlException: 
  access denied ("java.util.PropertyPermission" "user.home" "read")
    at java.security.AccessControlContext.checkPermission(AccessControlContext.java:366)
    at java.security.AccessController.checkPermission(AccessController.java:555)
    at java.lang.SecurityManager.checkPermission(SecurityManager.java:549)
    at java.lang.SecurityManager.checkPropertyAccess(SecurityManager.java:1302)
    at java.lang.System.getProperty(System.java:706)
    at org.se.lab.PropertyPermission.main(PropertyPermission.java:11)

To switch on the permission in our own policy file to read the system property, 
we have to uncomment the following line in the local my.policy file:

    //permission java.util.PropertyPermission "user.home", "read";

$ java -cp ./target/classes -Djava.security.policy=my.policy -Djava.security.manager org.se.lab.PropertyPermission
/home/student



Example: java.lang.reflect.ReflectPermission
-------------------------------------------------------------------------------
The given User class has a private field called id.

public class User
{
    public User(int id, String username, String password)
    {
        setId(id);
        setUsername(username);
        setPassword(password);
    }
    
    
    private int id;
    public final int getId()
    {
        return id;
    }
    private final void setId(int id)
    {
        this.id = id;
    }
    // ...
}

By using the Java reflection API, it is possible to access even private members 
of Java objects at runtime. Here is a program that changes the user's id to the 
value 17 by directly accessing the private field.

public class ReflectPermission
{
    public static void main(String[] args)
    {
        try
        {
            User user = new User(7, "teini", "*****");
            Field id = user.getClass().getDeclaredField("id");            
            id.setAccessible(true); // Note that we access a private field!!!
            id.setInt(user, 17);
            int i = id.getInt(user);
            
            System.out.println("id = " + i);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

After starting the program we can see the changed value of the private field id:

$ java -cp ./target/classes org.se.lab.ReflectPermission
id = 17

To stop this kind of reflection, use the SecurityManager with a proper policy file:

$ java -cp ./target/classes -Djava.security.policy=my.policy -Djava.security.manager org.se.lab.ReflectPermission

java.security.AccessControlException: access denied ("java.lang.reflect.ReflectPermission" "suppressAccessChecks")
    at java.security.AccessControlContext.checkPermission(AccessControlContext.java:366)
    at java.security.AccessController.checkPermission(AccessController.java:555)
    at java.lang.SecurityManager.checkPermission(SecurityManager.java:549)
    at java.lang.reflect.AccessibleObject.setAccessible(AccessibleObject.java:128)
    at org.se.lab.ReflectPermission.main(ReflectPermission.java:18)

Again, to switch off this restriction, uncomment the following line in the local
my.policy file:

//permission java.lang.reflect.ReflectPermission "suppressAccessChecks", "";


Example: org.se.lab.CustomPermission
-------------------------------------------------------------------------------
We can define our own Permission as well:

	 static final private java.security.Permission CUSTOM_PERMISSION =
			new RuntimePermission("customPermission");

Using this CUSTOM_PERMISSION, we can implement our own SecurityManager guards:

    SecurityManager sm = System.getSecurityManager();
    if (sm != null)
    {
        sm.checkPermission(CUSTOM_PERMISSION);
    }

Again, we can confige this permission in our my.policy file:
    permission java.lang.RuntimePermission "customPermission";

$ java -cp ./target/classes -Djava.security.policy=my.policy -Djava.security.manager org.se.lab.CustomPermission


Example: org.se.lab.LoggingSecurityManager
-------------------------------------------------------------------------------
To find out all the permissions will be checked during a program execution, we can
use a subclass of the SecurityManager which logs all checks to the console.

$ java -cp ./target/classes -Djava.security.manager=org.se.lab.LoggingSecurityManager org.se.lab.PropertyPermission

