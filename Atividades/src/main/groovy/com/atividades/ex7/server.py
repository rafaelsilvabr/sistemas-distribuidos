import flask

app = flask.Flask(name)

@app.route("/retire", methods=["POST"])
def retire():
    data = flask.request.get_json()
    age = data["age"]
    length_of_service = data["length_of_service"]

    if age >= 65 and length_of_service >= 30:
        return "Employee can retire."
    elif age >= 60 and length_of_service >= 25:
        return "Employee can retire."
    else:
        return "Employee cannot retire."
if name == "main":
app.run()