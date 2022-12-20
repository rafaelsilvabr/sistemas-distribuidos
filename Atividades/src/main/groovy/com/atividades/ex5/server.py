from flask import Flask, request
app = Flask(name)

@app.route('/swimmerclassification', methods=['POST'])
def classify_swimmer():
age = request.form['age']
if age <= 5:
classification = "Infantil A"
elif age <= 7:
classification = "Infantil B"
elif age <= 11:
classification = "Juvenil A"
elif age <= 14:
classification = "Juvenil B"
else:
classification = "Adulto"
return classification

