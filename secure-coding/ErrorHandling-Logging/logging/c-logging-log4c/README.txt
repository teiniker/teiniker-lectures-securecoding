How to install log4c ?
-------------------------------------------------------------------------------
http://sourceforge.net/projects/log4c/

$ cd Downloads/
$ tar xvzf log4c-1.2.4.tar.gz 
$ cd log4c-1.2.4/
$ ./configure --prefix=/home/student/install/log4c-1.2.4
$ make
$ make install

Add the following line to ~/.bashrc:
	export LD_LIBRARY_PATH=/home/student/install/log4c-1.2.4/lib:$LD_LIBRARY_PATH
	
	