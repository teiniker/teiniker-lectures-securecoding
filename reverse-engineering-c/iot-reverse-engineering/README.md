# IoT Reverse Engineering

The aim of this introduction is to show how firmware can be analyzed.

The firmware to be examined can either be read from devices or downloaded 
from the Internet.
We are using explicit **training software** (IoTGoat, Damn Vulnerable Router Firmware (DVRF)) 
that was implemented for training purposes.

The tools we need for this static analysis are installed in **Kali Linux**.

## Static Analysis 

### IoT Goat 

The IoTGoat Project is a deliberately insecure firmware based on OpenWrt and maintained by OWASP as a platform 
to educate software developers and security professionals with testing commonly found vulnerabilities in IoT devices. 
The vulnerability challenges are based on the OWASP IoT Top 10 noted below, as well as "easter eggs" from project contributors.

We download the [firmware](https://github.com/OWASP/IoTGoat/releases) from GitHub.

[IoTGoat challenges](https://github.com/OWASP/IoTGoat/wiki/IoTGoat-challenges)
```
Download: IoTGoat-x86.img.gz

$ gunzip IoTGoat-x86.img.gz

$ binwalk -e IoTGoat-x86.img 
DECIMAL       HEXADECIMAL     DESCRIPTION
--------------------------------------------------------------------------------
262144        0x40000         Linux EXT filesystem, blocks count: 4096, image size: 4194304, rev 2.0, ext2 filesystem data, UUID=57f8f4bc-abf4-655f-bf67-946fc0f9c0f9
5325930       0x51446A        xz compressed data
17301504      0x1080000       Squashfs filesystem, little endian, version 4.0, compression:xz, size: 3481630 bytes, 1352 inodes, blocksize: 262144 bytes, created: 2019-01-30 12:21:02

$ tree _IoTGoat-x86.img.extracted
```
Here we see, that the image contains a **Linux kernel** and a **Squashfs filesystem**.
It is not uncommon that IoT Devices run a Linux system because the need a WiFi network stack.

Within the extracted Linux filesystem, we can look for interesting files...


### Firmwalker

A simple bash script for searching the extracted or mounted firmware file system is called 
[firmwalker](https://github.com/craigz28/firmwalker).
```
$ git clone https://github.com/craigz28/firmwalker.git
$ cd firmwalker

$ ./firmwalker/firmwalker.sh _IoTGoat-x86.img.extracted
***Firmware Directory***
../_IoTGoat-x86.img.extracted
***Search for password files***
##################################### passwd
d/squashfs-root/bin/passwd
d/squashfs-root/etc/passwd

##################################### shadow
d/squashfs-root/etc/shadow
...
```

```
$ less _IoTGoat-x86.img.extracted/squashfs-root/etc/shadow
root:$1$Jl7H1VOG$Wgw2F/C.nLNTC.4pwDa4H1:18145:0:99999:7:::
daemon:*:0:0:99999:7:::
ftp:*:0:0:99999:7:::
network:*:0:0:99999:7:::
nobody:*:0:0:99999:7:::
dnsmasq:x:0:0:99999:7:::
dnsmasq:x:0:0:99999:7:::
iotgoatuser:$1$79bz0K8z$Ii6Q/if83F1QodGmkb4Ah.:18145:0:99999:7:::
```


### Damn Vulnerable Router Firmware (DVRF)

DVRF is another training firmware which is available for free.
We can download the [firmware](https://github.com/praetorian-inc/DVRF/tree/master/Firmware) from GitHub.
```
Download: DVRF_v03.bin
```

Using **binwalk**, we can list the content of the firmware image:
```
$ binwalk DVRF_v03.bin
DECIMAL       HEXADECIMAL     DESCRIPTION
--------------------------------------------------------------------------------
0             0x0             BIN-Header, board ID: 1550, hardware version: 4702, firmware version: 1.0.0, build date: 2012-02-08
32            0x20            TRX firmware header, little endian, image size: 7753728 bytes, CRC32: 0x436822F6, flags: 0x0, version: 1, header size: 28 bytes, loader offset: 0x1C, linux kernel offset: 0x192708, rootfs offset: 0x0
60            0x3C            gzip compressed data, maximum compression, has original file name: "piggy", from Unix, last modified: 2016-03-09 08:08:31
1648424       0x192728        Squashfs filesystem, little endian, non-standard signature, version 3.0, size: 6099215 bytes, 447 inodes, blocksize: 65536 bytes, created: 2016-03-10 04:34:22
```

We can also use binwalk to extract the filesystem from the given image file:
```
$ binwalk -e DVRF_v03.bin
$ tree _DVRF_v03.bin.extracted/squashfs-root/
_DVRF_v03.bin.extracted/squashfs-root/
├── bin
│   ├── addgroup -> busybox
│   ├── adduser -> busybox
│   ├── busybox
│   ├── cat -> busybox
│   ├── chgrp -> busybox
│   ├── chmod -> busybox
│   ├── chown -> busybox
│   ├── cp -> busybox
...
├── dev
├── etc
...
```
Now we can **navigate in the file system** and analyse configuration files, stored certificates, web pages, etc.
Because this is a manual task, it can take some time. 

Here is a tool called **firmwalker** which can automate most of this work:
```
$ ./firmwalker.sh ../_DVRF_v03.bin.extracted/squashfs-root/
***Firmware Directory***
../_DVRF_v03.bin.extracted/squashfs-root/
***Search for password files***
##################################### passwd
/etc/passwd
/usr/bin/passwd
##################################### shadow
/etc/shadow
##################################### *.psk

***Search for Unix-MD5 hashes***

***Search for SSL related files***
##################################### *.crt
##################################### *.pem
##################################### *.cer
##################################### *.p7b
##################################### *.p12
##################################### *.key
...

```

Finally, we can **analyze binaries** to find hard coded secrets and interesting vulnerabilities.


## References
* [Reverse Engineering the TP-Link HS110](https://www.softscheck.com/en/reverse-engineering-tp-link-hs110/)
* [YouTube: Simple Firmware Reverse Engineering](https://youtu.be/oqk3cU7ekag)
* [YouTube: IoT Firmware Analysis](https://youtu.be/bwZlwIOMkJE)

* Aditya Gupta. **The IoT Hacker's Handbook**. Apress, 2019
	* Chapter 7: Firmware Reverse Engineering and Exploitation  

* **Reverse Engineering Tools**
    * [Binwalk](https://github.com/ReFirmLabs/binwalk)
    * [Firmwalker](https://github.com/craigz28/firmwalker)

* **Training Firmware**
    * [IoTGoat Project](https://github.com/OWASP/IoTGoat)
    * [Damn Vulnerable Router Firmware (DVRF) v0.3](https://github.com/praetorian-inc/DVRF/tree/master/Firmware)



*Egon Teiniker, 2020-2022, GPL v3.0*
