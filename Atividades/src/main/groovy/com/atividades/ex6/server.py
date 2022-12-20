import socket

server_address = ('localhost', 5000)
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind(server_address)
server_socket.listen(1)

connection, client_address = server_socket.accept()

name = connection.recv(1024).decode()
level = connection.recv(1024).decode()
gross_salary = int(connection.recv(1024).decode())
dependents = int(connection.recv(1024).decode())

if level == "A":
if dependents == 0:
discount = 0.03
else:
discount = 0.08
elif level == "B":
if dependents == 0:
discount = 0.05
else:
discount = 0.1
elif level == "C":
if dependents == 0:
discount = 0.08
else:
discount = 0.15
elif level == "D":
if dependents == 0:
discount = 0.1
else:
discount = 0.17

net_salary = gross_salary - (gross_salary * discount)

connection.send(str(net_salary).encode())

connection.close()



