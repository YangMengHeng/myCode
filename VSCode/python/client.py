import socket
import sys

HOST = '127.0.0.1'
PORT = 12000
clientSocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
print("client socket created.")

clientSocket.connect((HOST, PORT))
print("client connected successfully.")

while 1:
    senData = input("Please input to be converted data: ")
    clientSocket.sendall(senData.encode())
    receiveData = clientSocket.recv(1024)
    print("After converting, the data from server is :", receiveData.decode())
    answer = input("Do you want to get more information?(y/n): ")
    if answer != 'y':
        break
clientSocket.close()