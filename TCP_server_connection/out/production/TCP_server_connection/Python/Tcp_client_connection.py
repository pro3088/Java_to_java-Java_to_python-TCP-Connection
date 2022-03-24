# -*- coding: utf-8 -*-
"""
Project: Client Tcp Application
"""

import socket
import sys

# Create a TCP/IP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect the socket to the port where the server is listening
server_address = ('localhost', 9046)
print(sys.stderr, 'connecting to port: ' , server_address)
sock.connect(server_address)



try:
    print("connected to: ", server_address)
    text = input("Do you want to exit: yes or no: ")
    
    while text != "yes":
        
        word = repr(text)
        
        sock.sendall(b' %s \n' % bytes(input("Enter a word: "), 'utf-8'))
    
        data = sock.recv(1024)
    
        print(data)
    

finally:
    print (sys.stderr, 'closing socket')
    sock.close()