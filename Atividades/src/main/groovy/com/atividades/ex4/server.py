import socket

def calculate_ideal_weight(height, gender):
    if gender == 'male':
        return (72.7 * height) - 58
    elif gender == 'female':
        return (62.1 * height) - 44.7
    else:
        return 0

def main():
    # Create a TCP/IP socket
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # Bind the socket to the port
    server_address = ('localhost', 10000)
    print('starting up on {} port {}'.format(*server_address))
    sock.bind(server_address)

    # Listen for incoming connections
    sock.listen(1)

    while True:
        # Wait for a connection
        print('waiting for a connection')
        connection, client_address = sock.accept()
        try:
            print('connection from', client_address)

            # Receive the data in small chunks and retransmit it
            while True:
                data = connection.recv(1024).decode()
                if data:
                    height, gender = data.split(',')
                    height = float(height)
                    ideal_weight = calculate_ideal_weight(height, gender)
                    connection.sendall(str(ideal_weight).encode())
                else:
                    print('no more data from', client_address)
                    break
        finally:
            # Clean up the connection
            connection.close()

if __name__ == '__main__':
    main()
