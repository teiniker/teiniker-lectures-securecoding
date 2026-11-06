# GDB Tutorial 

The **GNU Debugger (gdb)** can not only be used at the source level, but is 
also very well suited for dynamically analyzing assembly code.


## Disassembly Code 

We can set the **disassembly style** used by the disassemble.
There are two disassembly modes:

* **att**: GDB will use the **AT&T disassembly** style (e.g. mov 0xc(%ebp),%eax).

* **intel**: 	GDB will use the **Intel disassembly** style (e.g. mov eax, DWORD PTR [ebp+0xc]).

The **default value** for the disassembly-flavor setting is `att`.

_Example:_ Set disassembly mode
```bash
(gdb) set disassembly-flavor att
(gdb) set disassembly-flavor intel
(gdb) show disassembly-flavor
```

Note that we can use a `.gdbinit` file with the content:
```
set disassembly-flavor intel
```
to change the disassembly-flavor permanently. 


_Example:_ Disassemble a function

```bash
$ gdb ./secret 

(gdb) disassemble main
```

_Example:_  Disassemble a range of addresses

```bash
(gdb) disassemble 0x401000, 0x401200
```

## Running a Program

Before you can step, you need to start or restart the program inside GDB.

_Example:_ Start GDB witha a particular binary 

```bash
$ gdb ./secret 
(gdb) run               # Start program from beginning
```

_Example:_ Load a program and execute it 
```bash
$ gdb 
(gdb) file ./secret     # Load executable
(gdb) run               # Start program from beginning
```

_Example:_ Execute a program with arguments 
```bash
$ gdb 
(gdb) run arg1 arg2  
```

To **exit the gdb**, we use the `quit` command:

_Example:_ Quit out of gdb
```bash
(gdb) quit  
```


## Breakpoints

A breakpoint interrupts the execution flow by pausing right before a specific instruction is executed.

So when our program hits a breakpoint:
* The CPU stops executing your program’s instructions.
* Control returns to the debugger.
* We can now inspect registers, memory, variables, stack, or even modify values before continuing.

We can define breakpoints in different ways:

* **Function breakpoint**: Stops when function begins

    _Example:_ `(gdb) break main`

* **Address breakpoint**: Stops at a specific instruction

    _Example:_ `(gdb) break *0x401000`

* **Conditional breakpoint**: Stops only when a condition is true

    _Example:_ `(gdb) break *0x401000 if $rax == 0`


We can also list and modify breakpoints:

* **List all breakpoints**:

    _Example:_ `(gdb) info breakpoints`

* **Disable breakpoint**: Disable first breakpoint

    _Example:_ `(gdb) disable 1` 

* **Enable breakpoint**: Enable first breakpoint

    _Example:_ `(gdb) enable 1`

* **Remove breakpoint**: Remove first breakpoint

    _Example:_ `(gdb) delete 1`  

* **Clear all breakpoints** in a function:  

    _Example:_ `(gdb) clear main` 


### Continue After Breakpoint

* **Resumes execution** until the next stop

    _Example:_ `(gdb) continue`


### Stepping Through Execution 

Stepping lets us control how far the program runs between stops.

#### Source-Level Stepping

If we compiled with `-g`, GDB knows which instructions correspond to each source line.

* `step` (or `s`): Execute one **source line**, stepping *into* functions. Calls are entered.

* `next` (or `n`): Execute one **source line**, stepping *over* functions (calls are run entirely).

* `finish`: Run until the current function returns (stops after returning).

* `until`: Run until a specific line or address (good for loops).


#### Instruction-Level Stepping

When debugging at the assembly level, we can use instruction-level commands.

* `stepi` (or `si`): Execute one **assembly instruction**, step *into* calls (like `step` but in asm)
* `nexti` (or `ni`): Execute one **assembly instruction**, step *over* calls (Like `next` but in asm)



## Registers 

Registers are **small, fast storage locations inside the CPU**.
They hold immediate data that the CPU is currently working with.

When we debug at the assembly level, inspecting registers shows us 
exactly what the CPU is doing at this moment.

### Common Registers (x86-64 Example)

* **Instruction pointer**: Address of the next instruction to execute (`rip`)
* **General purpose**: Hold data and addresses (`rax, rbx, rcx, rdx, rsi, rdi, rbp, rsp, r8–r15`)
* **Flags**: Bitfield storing condition codes like ZF, CF, SF, OF, etc. (`eflags`)
* **Segment registers**: Used mainly by the OS for memory segmentation (`cs, ds, ss, es, fs, gs`)
* **Floating-point / SIMD**: Hold vector or floating-point data (`st0–st7, xmm0–xmm31`)

### Inspecting Registers

* **View all registers**: `(gdb) info registers`

* **Print a specific register**: Use the \$ prefix to refer to a register: 

    ```bash
    (gdb) print $rax         # value in decimal
    (gdb) print/x $rax       # value in hexadecimal
    (gdb) print/t $eflags    # value in binary
    (gdb) print/f $xmm0      # value in floating point
    ```

### Modifying Registers

* **Set a register value**:

    ```bash
    (gdb) set $rax = 0xdeadbeef
    (gdb) set $rbx = 42
    (gdb) set $rip = 0x401080     # jump to a different instruction
    ```

* **Modify the flags**:
    ```bash
    (gdb) set $eflags |= 0x80    # Set the Sign Flag (bit 7)
    ```


## Memory

Memory is a giant **array of bytes**. Every variable, instruction, or string 
lives somewhere in that space.
**Each byte has an address**, which you can think of as its coordinate.

In GDB, we can inspect any address we know, or even peek at the memory pointed 
to by a register like $rsp (stack pointer) or $rdi (function argument).


### Inspecting Memory

The main GDB command for reading memory is **x**, short for examine.

_Syntax:_ `(gdb) x/NFU ADDRESS`

| Symbol | Meaning                                                                 |
| ------ | ----------------------------------------------------------------------- |
| **N**  | Number of units to display (e.g., 16)                                   |
| **F**  | Format: how to print the data (hex, decimal, chars, instructions, etc.) |
| **U**  | Unit size: how big each unit is (byte, halfword, word, giant word)      |


**Common Formats**:

| Code | Format                    | Example        |
| ---- | ------------------------- | -------------- |
| `x`  | hexadecimal               | `0xdeadbeef`   |
| `d`  | signed decimal            | `42`           |
| `u`  | unsigned decimal          | `4294967295`   |
| `t`  | binary                    | `101010`       |
| `f`  | floating-point            | `3.14`         |
| `c`  | character                 | `'A'`          |
| `s`  | string                    | `"Hello"`      |
| `i`  | instruction (disassembly) | `mov eax, ebx` |


**Unit Sizes**:

| Code | Unit       | Bytes |
| ---- | ---------- | ----- |
| `b`  | byte       | 1     |
| `h`  | halfword   | 2     |
| `w`  | word       | 4     |
| `g`  | giant word | 8     |


_Example:_ Inspect a **C string** - Prints the string located where \$rdi points (typical for printf’s first argument)

```bash
(gdb) x/s $rdi
```

_Example:_ View a data region in **hex and ASCII** - 32 bytes, one per line, hex format

```bash
(gdb) x/32xb 0x404000
```


_Example:_ Inspect **stack memory** - Shows 16 eight-byte (giant word) values from the current stack pointer

```bash
(gdb) x/16gx $rsp
```


_Example:_ Inspect **instruction memory** - Disassembles the next 10 instructions starting at the instruction pointer

```bash
(gdb) x/10i $rip
```


### Following Pointers

Memory inspection works recursively. If a register holds an address, we can follow it:

```bash
(gdb) x/gx $rdi          # show pointer value
(gdb) x/s  *$rdi         # show string stored at address in RDI
(gdb) x/xg **$rdi        # double dereference (pointer to pointer)
```

The `*` operator dereferences just like in C.


### Modifying Memory

We can write directly to any address we can read (as long as the program 
allows it - e.g. not read-only code sections).

_Syntax:_ `(gdb) set {type}ADDRESS = VALUE`

Where `{type}` can be `char`, `short`, `int`, `long`, `float`, `double`, etc.


_Example:_ Write a single byte 

```bash
(gdb) set {char}0x404000 = 0x41     # 'A'
```

_Example:_ Write a 32-bit integer

```bash
(gdb) set {int}($rbp-0x4) = 1234
```

_Example:_ Write a string

```bash
(gdb) set {char[6]}0x404100 = "Hello"
```


_Example:_ Overwrite instruction bytes (patch code)

```bash
(gdb) set {unsigned char}$rip = 0x90   # NOP instruction
(gdb) set {unsigned char}($rip+1) = 0xCC  # INT3 breakpoint
```



## References

* [YouTube: Master GNU Debugger: Debug C++ & Assembly Programs with GDB Like a Pro](https://youtu.be/lPcwsvSWak0?si=a2ZSHaHRLspXKCZQ)

* Norman Matloff, **Peter Jay Salzman. The Art of Debugging With GDB, DDD, and Eclipse**. No Starch Press, 2008

*Egon Teiniker, 2025, GPL v3.0*