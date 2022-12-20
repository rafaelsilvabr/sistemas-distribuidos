#server

import requests

from flask import Flask, request, jsonify
app = Flask(name)

data = {
	"John": {"gender": "male", "age": 25},
	"Jane": {"gender": "female", "age": 30},
}

@app.route("/api/person/<name>", methods=["GET"])
def get_person_details(name):
# check if person exists in our data
if name not in data:
	return "Person not found", 404
	# return person's gender and age
return jsonify(data[name])

if name == "main":
app.run()