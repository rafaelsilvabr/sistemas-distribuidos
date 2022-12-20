#client

import requests


name = input("Please enter your name: ")

response = requests.get("http://server.com/api/person/" + name)

gender = response.json()["gender"]
age = response.json()["age"]

if gender == "male" and age >= 18:
print("You have reached the age of majority.")
elif gender == "female" and age >= 21:
print("You have reached the age of majority.")
else:
print("You have not reached the age of majority.")



