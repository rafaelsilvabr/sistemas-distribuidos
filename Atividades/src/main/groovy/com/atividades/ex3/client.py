#client

import requests

# read the name of the student
name = input("Enter the name of the student: ")

# make a request to the server for the grades of the student
response = requests.get(f"http://server.com/grades?name={name}")

# parse the response to get the grades
grades = response.json()
N1 = grades["N1"]
N2 = grades["N2"]
N3 = grades["N3"]

# calculate the arithmetic mean between N1 and N2
M = (N1 + N2) / 2

# check if the student is approved based on the rules
if M >= 7.0:
  print("The student is approved.")
elif M > 3.0 and M < 7.0:
  # calculate the arithmetic mean between M and N3
  M_N3 = (M + N3) / 2
  if M_N3 >= 5.0:
    print("The student is approved.")
  else:
    print("The student failed.")
else:
  print("The student failed.")