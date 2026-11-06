# Example: Reverse Engineering - Product Key 

In the given binary, username and product key will be checkt before the program 
goes on. 
```bash
$ ./product <username> <key>
```

If the correct username and product key are supplied, the program prints 
```
Welcome to your product.
```

Otherwise it prints 
```
Invalid product key or username!
```

## Dynamic Analysis 

Use the **gdb** to manipulate the control flow.
Modify register values to bypass the username and key checks.

1. **Start debugger with binary**:

    ```bash
    $ gdb ./product
    ```

2. **List all named functiosn in the binary**:

    ```bash
    (gdb) info functions
    Non-debugging symbols:
    0x0000000000001000  _init
    0x0000000000001030  puts@plt
    0x0000000000001040  strcmp@plt
    0x0000000000001050  exit@plt
    0x0000000000001060  __cxa_finalize@plt
    0x0000000000001070  _start
    0x00000000000010a0  deregister_tm_clones
    0x00000000000010d0  register_tm_clones
    0x0000000000001110  __do_global_dtors_aux
    0x0000000000001150  frame_dummy
    0x0000000000001159  validate_key
    0x000000000000118d  validate_username
    0x00000000000011c1  main
    0x0000000000001244  _fini
    ```

3. **Analyze the control flow of `main`**:

    Fokus on:
    * **call** instructions 

    * **test** and **je** instructions 

    ```bash
    (gdb) disass main
    Dump of assembler code for function main:
    0x00005555555551c1 <+0>:	push   rbp
    0x00005555555551c2 <+1>:	mov    rbp,rsp
    0x00005555555551c5 <+4>:	sub    rsp,0x10
    0x00005555555551c9 <+8>:	mov    DWORD PTR [rbp-0x4],edi
    0x00005555555551cc <+11>:	mov    QWORD PTR [rbp-0x10],rsi
    0x00005555555551d0 <+15>:	cmp    DWORD PTR [rbp-0x4],0x3
    0x00005555555551d4 <+19>:	je     0x5555555551ef <main+46>
    0x00005555555551d6 <+21>:	lea    rax,[rip+0xe4b]        # 0x555555556028
    0x00005555555551dd <+28>:	mov    rdi,rax
    0x00005555555551e0 <+31>:	call   0x555555555030 <puts@plt>
    0x00005555555551e5 <+36>:	mov    edi,0x0
    0x00005555555551ea <+41>:	call   0x555555555050 <exit@plt>
    0x00005555555551ef <+46>:	mov    rax,QWORD PTR [rbp-0x10]
    0x00005555555551f3 <+50>:	add    rax,0x8
    0x00005555555551f7 <+54>:	mov    rax,QWORD PTR [rax]
    0x00005555555551fa <+57>:	mov    rdi,rax
    0x00005555555551fd <+60>:	call   0x55555555518d <validate_username>
    0x0000555555555202 <+65>:	test   al,al
    0x0000555555555204 <+67>:	je     0x55555555522e <main+109>
    0x0000555555555206 <+69>:	mov    rax,QWORD PTR [rbp-0x10]
    0x000055555555520a <+73>:	add    rax,0x10
    0x000055555555520e <+77>:	mov    rax,QWORD PTR [rax]
    0x0000555555555211 <+80>:	mov    rdi,rax
    0x0000555555555214 <+83>:	call   0x555555555159 <validate_key>
    0x0000555555555219 <+88>:	test   al,al
    0x000055555555521b <+90>:	je     0x55555555522e <main+109>
    0x000055555555521d <+92>:	lea    rax,[rip+0xe24]        # 0x555555556048
    0x0000555555555224 <+99>:	mov    rdi,rax
    0x0000555555555227 <+102>:	call   0x555555555030 <puts@plt>
    0x000055555555522c <+107>:	jmp    0x55555555523d <main+124>
    0x000055555555522e <+109>:	lea    rax,[rip+0xe33]        # 0x555555556068
    0x0000555555555235 <+116>:	mov    rdi,rax
    0x0000555555555238 <+119>:	call   0x555555555030 <puts@plt>
    0x000055555555523d <+124>:	mov    eax,0x0
    0x0000555555555242 <+129>:	leave
    0x0000555555555243 <+130>:	ret
    ```

    Set breakpoints immediately before each `test` instruction. 

    ```bash
    0x00005555555551fd <+60>:	call   0x55555555518d <validate_username>
    0x0000555555555202 <+65>:	test   al,al                                <== break
    0x0000555555555204 <+67>:	je     0x55555555522e <main+109>                
    0x0000555555555206 <+69>:	mov    rax,QWORD PTR [rbp-0x10]
    0x000055555555520a <+73>:	add    rax,0x10
    0x000055555555520e <+77>:	mov    rax,QWORD PTR [rax]
    0x0000555555555211 <+80>:	mov    rdi,rax
    0x0000555555555214 <+83>:	call   0x555555555159 <validate_key>
    0x0000555555555219 <+88>:	test   al,al                                <== break
    0x000055555555521b <+90>:	je     0x55555555522e <main+109>             
    0x000055555555521d <+92>:	lea    rax,[rip+0xe24]        # 0x555555556048
    0x0000555555555224 <+99>:	mov    rdi,rax
    0x0000555555555227 <+102>:	call   0x555555555030 <puts@plt>
    0x000055555555522c <+107>:	jmp    0x55555555523d <main+124>

    (gdb) break *0x0000555555555202
    (gdb) break *0x0000555555555219
    ```

    Now, we run the application until the first breakpoint.
    At each breakpoint, inspect the `AL` register (e.g., `print $al`) and set it to `1` 
    (`set $al=1`) so the subsequent `je` is not taken and execution follows the success path:

    ```bash
    (gdb) run homer xxxxxx

    Breakpoint 1, 0x0000555555555202 in main ()
    (gdb) print $al
    $4 = 0
    (gdb) set $al=1
    (gdb) print $al
    $5 = 1
    (gdb) c
    Continuing.

    Breakpoint 2, 0x0000555555555219 in main ()
    (gdb) print $al
    $6 = 0
    (gdb) set $al=1
    (gdb) print $al
    $7 = 1
    (gdb) c
    Continuing.
    Welcome to your product.
    ```

    With this, we have achieved the goal by manipulating the control flow.


## Patch Binary 

In this step we will modify the binary so that the desired control 
flow is forced. **Replace the conditional jump instructions with 
No Operation (NOP) instructions** to skip the checks permanently.

We use a **hex editor** (VS Code Extension) to overwrite the two-byte 
`JE` instructions with a two-byte NOP sequence (`66 90`). 

There are different **No Operation (NOP)** commands we can use for x86-64 CPUs:

```
90                ; 1-byte NOP 

In multi-byte NOPs, used for instruction alignment or padding, other encodings 
like the following are common:
66 90             ; 2-byte NOP
0F 1F 00          ; 3-byte NOP
0F 1F 40 00       ; 4-byte NOP
0F 1F 44 00 00    ; 5-byte NOP
```

1. **Make a backup of the original binary before editing**: 

    ```bash
    $ cp product product-hack
    ```

2. **Disassembly the binary**:

    ```bash
    $ objdump -d product-hack

    00000000000011c1 <main>:
    ...
    11fd:       e8 8b ff ff ff          call   118d <validate_username>
    1202:       84 c0                   test   %al,%al
    1204:       74 28                   je     122e <main+0x6d>          <== replace
    1206:       48 8b 45 f0             mov    -0x10(%rbp),%rax
    120a:       48 83 c0 10             add    $0x10,%rax
    120e:       48 8b 00                mov    (%rax),%rax
    1211:       48 89 c7                mov    %rax,%rdi
    1214:       e8 40 ff ff ff          call   1159 <validate_key>
    1219:       84 c0                   test   %al,%al
    121b:       74 11                   je     122e <main+0x6d>         <== replace
    121d:       48 8d 05 24 0e 00 00    lea    0xe24(%rip),%rax        
    1224:       48 89 c7                mov    %rax,%rdi
    1227:       e8 04 fe ff ff          call   1030 <puts@plt>
    ...
    ```

3. **Go to the following addresses and replace the two bytes with `66 90`**:

    ```
    1204:	74 28                	je     122e <main+0x6d>
    121b:	74 11                	je     122e <main+0x6d>
    ```

    ```bash
    $ objdump -d product-hack
    ...
    11fd:	e8 8b ff ff ff       	call   118d <validate_username>
    1202:	84 c0                	test   %al,%al
    1204:	66 90                	xchg   %ax,%ax                      <== NOP
    1206:	48 8b 45 f0          	mov    -0x10(%rbp),%rax
    120a:	48 83 c0 10          	add    $0x10,%rax
    120e:	48 8b 00             	mov    (%rax),%rax
    1211:	48 89 c7             	mov    %rax,%rdi
    1214:	e8 40 ff ff ff       	call   1159 <validate_key>
    1219:	84 c0                	test   %al,%al
    121b:	66 90                	xchg   %ax,%ax                      <== NOP
    121d:	48 8d 05 24 0e 00 00 	lea    0xe24(%rip),%rax       
    1224:	48 89 c7             	mov    %rax,%rdi
    1227:	e8 04 fe ff ff       	call   1030 <puts@plt>
    ...
    ```

4. **Save the file and run it**:

    ```bash
    $ ./product-hack homer xxxxxx
    Welcome to your product.
    ```
    
    The changes are now permanent, and username and product key checks have been disabled.


*Egon Teiniker, 2025, GPL v3.0*