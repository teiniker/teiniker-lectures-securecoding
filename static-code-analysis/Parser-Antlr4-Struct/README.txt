How to install ANTLR 4?
-------------------------------------------------------------------------------

Download: antlr-4.5.1-complete.jar
http://www.antlr.org/download.html

$ mkdir ~/install/antlr-4
$ cp antlr-4.5.1-complete.jar ~/install/antlr-4/

$ vi .bashrc
	alias antlr4='java -jar /home/student/install/antlr-4/antlr-4.5.1-complete.jar'
	alias grun='java -cp /home/student/install/antlr-4/antlr-4.5.1-complete.jar org.antlr.v4.gui.TestRig'


http://www.antlr.org/api/maven-plugin/latest/usage.html

	