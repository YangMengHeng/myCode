import socket
import sys

HOST = '127.0.0.1'
PORT = 12000
serverSocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
print("server socket created.")

serverSocket.bind((HOST, PORT))
serverSocket.listen(1)
print("server is ready to receive data.")

while 1:
    conn, addr = serverSocket.accept()
    print("Connected by ", addr)
    while 1:
        data = conn.recv(1024).decode()
        print(data)
        conn.sendall(data.upper().encode())
serverSocket.close()