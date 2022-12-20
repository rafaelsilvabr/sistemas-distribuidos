def calculate_credit_for_client(name, average_balance):
url = 'http://localhost:5000/calculate_credit'
data = {'name': name, 'average_balance': average_balance}
response = requests.post(url, json=data)
return response.text

print(calculate_credit_for_client('Joao', 300))

print(calculate_credit_for_client('Fernando', 500))

print(calculate_credit_for_client('Alice', 100))