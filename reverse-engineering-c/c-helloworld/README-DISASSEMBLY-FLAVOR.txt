Disassembly-flavor 

Controls the disassembly style used by the disassemble and x commands.

Syntax

	set disassembly-flavor att
	set disassembly-flavor intel
	show disassembly-flavor

Modes

att
	GDB will use the AT&T disassembly style (e.g. mov 0xc(%ebp),%eax).

intel
	GDB will use the Intel disassembly style (e.g. mov eax, DWORD PTR [ebp+0xc]).
	Default mode

The default value for the disassembly-flavor setting is 'att'.

Note that we can use a ".gdbinit" file with the content:

set disassembly-flavor intel

to change the disassembly-flavor permanently. 
