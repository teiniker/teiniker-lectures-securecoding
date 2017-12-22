JDepend
-------------------------------------------------------------------------------
http://clarkware.com/software/JDepend.html

JDepend traverses Java class file directories and generates design quality 
metrics for each Java package, including:

* Number of Classes and Interfaces
	The number of concrete and abstract classes (and interfaces) in the package
	is an indicator of the extensibility of the package.

* Afferent Couplings (Ca)
	The number of other packages that depend upon classes within the package is 
	an indicator of the package's responsibility.

* Efferent Couplings (Ce)
	The number of other packages that the classes in the package depend upon is 
	an indicator of the package's independence.

* Abstractness (A)
	The ratio of the number of abstract classes (and interfaces) in the 
	analyzed package to the total number of classes in the analyzed package.

	The range for this metric is 0 to 1, with A=0 indicating a completely 
	concrete package and A=1 indicating a completely abstract package.

* Instability (I)
	The ratio of efferent coupling (Ce) to total coupling (Ce + Ca) such that 
	I = Ce / (Ce + Ca). This metric is an indicator of the package's resilience 
	to change.

	The range for this metric is 0 to 1, with I=0 indicating a completely 
	stable package and I=1 indicating a completely instable package.

* Distance from the Main Sequence (D)
	The perpendicular distance of a package from the idealized line A + I = 1. 
	This metric is an indicator of the package's balance between abstractness 
	and stability.

	A package squarely on the main sequence is optimally balanced with respect 
	to its abstractness and stability. 
	Ideal packages are either completely abstract and stable (x=0, y=1) or 
	completely concrete and instable (x=1, y=0).

	The range for this metric is 0 to 1, with D=0 indicating a package that is 
	coincident with the main sequence and D=1 indicating a package that is as 
	far from the main sequence as possible.

* Package Dependency Cycles
	Package dependency cycles are reported along with the hierarchical paths of 
	packages participating in package dependency cycles.


How to Ignore System Packages?
-------------------------------------------------------------------------------
Add the jdepend.properties file to your home directory and specify the
packages which should be ignored:

$ pwd
/home/student

$ cat jdepend.properties 
ignore.java=java.*,javax.*
ignore.sun=sun.*,com.sun.*
ignore.jboss=org.jboss.*
ignore.primefaces=org.primefaces.*


How to use JDepend from the command line?
-------------------------------------------------------------------------------

$ java -cp vendor/jdepend/lib/jdepend-2.9.1.jar jdepend.textui.JDepend ~/workspace-2014ws-itm12-PracticalSE/Zeiterfassung/target/classes

$ java -cp vendor/jdepend/lib/jdepend-2.9.1.jar jdepend.swingui.JDepend ~/workspace-2014ws-itm12-PracticalSE/Zeiterfassung/target/classes


How to generate a Graph?
-------------------------------------------------------------------------------
$ ant jdepend-to-graphviz
$ dot -Tpdf jdepend-report.dot -o jdepend-report.pdf


Related Links
-------------------------------------------------------------------------------

* JDepend Maven Plugin
	http://mojo.codehaus.org/jdepend-maven-plugin/
