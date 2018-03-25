#!/usr/bin/python
import sys
import time
import socket
import threading

def help(str):
    print(str)
    sys.exit()

if len(sys.argv) != 3:
    help("Help: "+sys.argv[0]+" IP port")

try:
    socket.inet_pton(socket.AF_INET, sys.argv[1])
except:
    help("Error: invalid IP.")

ip = sys.argv[1]

try:
    port = int(sys.argv[2])
except:
    help("Error: the port must be an integer number.")

if port < 0 or port > 65535:
    help("Error: port number out of valid range [0-65535].")

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

try:
    server.bind((ip, port))
except(OSError):
    help("Error: port already in use.")
except:
    help("Error: couldn't bind socket on "+ip+":"+port+".")

server.listen(10)

