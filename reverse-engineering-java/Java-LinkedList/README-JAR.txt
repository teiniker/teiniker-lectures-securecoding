Java Archive File (JAR)
-------------------------------------------------------------------------------
To create a JAR file from your project we can use Maven:

$ mvn package
$ ll target/Java-LinkedList-0.0.1-SNAPSHOT.jar

But there is anohter tool shipped with the JDK that can be used to handle JAR files:

$ mkdir tmp
$ cd tmp
$ cp ../target/Java-LinkedList-0.0.1-SNAPSHOT.jar .

$ jar tf Java-LinkedList-0.0.1-SNAPSHOT.jar
  META-INF/
  META-INF/MANIFEST.MF
  org/
  org/se/
  org/se/lab/
  org/se/lab/LinkedList.class
  org/se/lab/LinkedListImpl.class
  org/se/lab/Node.class
  META-INF/maven/
  META-INF/maven/org.se.lab/
  META-INF/maven/org.se.lab/Java-LinkedList/
  META-INF/maven/org.se.lab/Java-LinkedList/pom.xml
  META-INF/maven/org.se.lab/Java-LinkedList/pom.properties


$ jar xvf Java-LinkedList-0.0.1-SNAPSHOT.jar
    created: META-INF/
   inflated: META-INF/MANIFEST.MF
    created: org/
    created: org/se/
    created: org/se/lab/
   inflated: org/se/lab/LinkedList.class
   inflated: org/se/lab/LinkedListImpl.class
   inflated: org/se/lab/Node.class
    created: META-INF/maven/
    created: META-INF/maven/org.se.lab/
    created: META-INF/maven/org.se.lab/Java-LinkedList/
   inflated: META-INF/maven/org.se.lab/Java-LinkedList/pom.xml
   inflated: META-INF/maven/org.se.lab/Java-LinkedList/pom.properties

$ rm Java-LinkedList-0.0.1-SNAPSHOT.jar
$ rm -r META-INF/maven/
$ tree
├── META-INF
│   └── MANIFEST.MF
└── org
    └── se
        └── lab
            ├── LinkedList.class
            ├── LinkedListImpl.class
            └── Node.class

$ cat META-INF/MANIFEST.MF
Manifest-Version: 1.0
Archiver-Version: Plexus Archiver
Created-By: Apache Maven 3.6.2
Built-By: student
Build-Jdk: 13

$ jar cvf Java-LinkedList-0.0.1-SNAPSHOT.jar .
added manifest
adding: org/(in = 0) (out= 0)(stored 0%)
adding: org/se/(in = 0) (out= 0)(stored 0%)
adding: org/se/lab/(in = 0) (out= 0)(stored 0%)
adding: org/se/lab/LinkedList.class(in = 260) (out= 187)(deflated 28%)
adding: org/se/lab/LinkedListImpl.class(in = 1482) (out= 806)(deflated 45%)
adding: org/se/lab/Node.class(in = 846) (out= 426)(deflated 49%)
ignoring entry META-INF/
ignoring entry META-INF/MANIFEST.MF



$ jar --help
Usage: jar [OPTION...] [ [--release VERSION] [-C dir] files] ...
jar creates an archive for classes and resources, and can manipulate or
restore individual classes or resources from an archive.

 Examples:
 # Create an archive called classes.jar with two class files:
 jar --create --file classes.jar Foo.class Bar.class

 # Create an archive using an existing manifest, with all the files in foo/:
 jar --create --file classes.jar --manifest mymanifest -C foo/ .

 # Create a modular jar archive, where the module descriptor is located in
 # classes/module-info.class:
 jar --create --file foo.jar --main-class com.foo.Main --module-version 1.0
     -C foo/ classes resources

 # Update an existing non-modular jar to a modular jar:
 jar --update --file foo.jar --main-class com.foo.Main --module-version 1.0
     -C foo/ module-info.class

 # Create a multi-release jar, placing some files in the META-INF/versions/9 directory:
 jar --create --file mr.jar -C foo classes --release 9 -C foo9 classes

To shorten or simplify the jar command, you can specify arguments in a separate
text file and pass it to the jar command with the at sign (@) as a prefix.

 Examples:
 # Read additional options and list of class files from the file classes.list
 jar --create --file my.jar @classes.list


 Main operation mode:

  -c, --create               Create the archive
  -i, --generate-index=FILE  Generate index information for the specified jar
                             archives
  -t, --list                 List the table of contents for the archive
  -u, --update               Update an existing jar archive
  -x, --extract              Extract named (or all) files from the archive
  -d, --describe-module      Print the module descriptor, or automatic module name

 Operation modifiers valid in any mode:

  -C DIR                     Change to the specified directory and include the
                             following file
  -f, --file=FILE            The archive file name. When omitted, either stdin or
                             stdout is used based on the operation
      --release VERSION      Places all following files in a versioned directory
                             of the jar (i.e. META-INF/versions/VERSION/)
  -v, --verbose              Generate verbose output on standard output

 Operation modifiers valid only in create and update mode:

  -e, --main-class=CLASSNAME The application entry point for stand-alone
                             applications bundled into a modular, or executable,
                             jar archive
  -m, --manifest=FILE        Include the manifest information from the given
                             manifest file
  -M, --no-manifest          Do not create a manifest file for the entries
      --module-version=VERSION    The module version, when creating a modular
                             jar, or updating a non-modular jar
      --hash-modules=PATTERN Compute and record the hashes of modules
                             matched by the given pattern and that depend upon
                             directly or indirectly on a modular jar being
                             created or a non-modular jar being updated
  -p, --module-path          Location of module dependence for generating
                             the hash

 Operation modifiers valid only in create, update, and generate-index mode:

  -0, --no-compress          Store only; use no ZIP compression

 Other options:

  -?, -h, --help[:compat]    Give this, or optionally the compatibility, help
      --help-extra           Give help on extra options
      --version              Print program version

 An archive is a modular jar if a module descriptor, 'module-info.class', is
 located in the root of the given directories, or the root of the jar archive
 itself. The following operations are only valid when creating a modular jar,
 or updating an existing non-modular jar: '--module-version',
 '--hash-modules', and '--module-path'.

 Mandatory or optional arguments to long options are also mandatory or optional
 for any corresponding short options.
