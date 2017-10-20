The GNU C Library (glibc)
-------------------------------------------------------------------------------
The GNU C Library project provides the core libraries for the GNU system and
GNU/Linux systems, as well as many other systems that use Linux as the kernel.

See: https://www.gnu.org/software/libc/manual/

How to use the test framework?
-------------------------------------------------------------------------------
See:
    https://developer.gimp.org/api/2.0/glib/glib-Testing.html
    https://developer.gnome.org/glib/stable/glib-Testing.html



How to install the glib2 library?
-------------------------------------------------------------------------------
$ yum install glib2-devel

$ pkg-config glib-2.0 --libs --cflags
    -I/usr/include/glib-2.0 -I/usr/lib64/glib-2.0/include -lglib-2.0

Note that this library is already installed in the Fedora VM.

