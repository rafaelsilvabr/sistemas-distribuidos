import requests

data = {
"age": 65,
"length_of_service": 30
}
response = requests.post("http://localhost:5000/retire", json=data)
print(response.text) # Output: "Employee can retire."

data = {
"age": 60,
"length_of_service": 25
}
response = requests.post("http://localhost:5000/retire", json=data)
print(response.text) # Output: "Employee can retire."

data = {
"age": 55,
"length_of_service": 20
}
response = requests.post("http://localhost:5000/retire", json=data)
print(response.text) # Output: "Employee cannot retire."