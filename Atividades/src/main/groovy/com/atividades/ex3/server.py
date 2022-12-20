#server
from flask import Flask, jsonify

app = Flask(__name__)

# create a dictionary to store the grades of all students
students = {
  "John": {"N1": 8.0, "N2": 7.5, "N3": 6.0},
  "Jane": {"N1": 9.0, "N2": 9.0, "N3": 9.0},
  "Bob": {"N1": 6.0, "N2": 5.0, "N3": 4.0}
}

@app.route("/grades", methods=["POST"])
def add_grades():
  # parse the request payload to get the name and grades of the student
  data = request.json
  name = data["name"]
  N1 = data["N1"]
  N2 = data["N2"]
  N3 = data["N3"]

  # store the grades of the student in our records
  students[name] = {"N1": N1, "N2": N2, "N3": N3}

  # return a success message
  return "Grades added successfully.", 200

@app.route("/grades")
def get_grades():
  # get the name of the student from the query parameter
  name = request.args.get("name")

  # check if the student exists in our records
  if name in students:
    # return the grades of the student in JSON format
    return jsonify(students[name])
  else:
    # return a 404 error if the student is not found
    return "Student not found", 404

if __name__ == "__main__":
  app.run()