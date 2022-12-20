import socket

server_address = ('localhost', 5000)
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect(server_address)

name = input("Enter the employee's name: ")
level = input("Enter the employee's level (A-D): ")
gross_salary = input("Enter the employee's gross salary: ")
dependents = input("Enter the number of dependents for the employee: ")

client_socket.send(name.encode())
client_socket.send(level.encode())
client_socket.send(gross_salary.encode())
client_socket.send(dependents.encode())

net_salary = client_socket.recv(1024).decode()
print("The employee's net salary is: ", net_salary)

client_socket.close()