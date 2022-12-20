import requests
age = int(input("Enter the age of the swimmer: "))
data = {'age': age}
response = requests.post('http://localhost:5000/swimmerclassification', data=data)
print("The swimmer's classification is:", response.text)