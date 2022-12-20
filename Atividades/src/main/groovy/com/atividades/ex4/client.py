import socket

def main():
    # Create a TCP/IP socket
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # Connect the socket to the port where the server is listening
    server_address = ('localhost', 10000)
    print('connecting to {} port {}'.format(*server_address))
    sock.connect(server_address)

    try:
        # Send data
        height = input('Enter your height: ')
        gender = input('Enter your gender (male or female): ')
        data = f"{height},{gender}"
        sock.sendall(data.encode())

        # Look for the response
        amount_received = 0
        amount_expected = len(data)

        while amount_received < amount_expected:
            data = sock.recv(1024).decode()
            amount_received += len(data)
            print(f"Your ideal weight is {data}")
    finally:
        sock.close()

if __name__ == '__main__':
    main()
