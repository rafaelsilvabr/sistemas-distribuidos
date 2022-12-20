from flask import Flask, request
import requests

app = Flask(name)

@app.route('/calculate_salary', methods=['POST'])
def calculate_salary():

name = request.form['name']
level = request.form['level']
gross_salary = request.form['gross_salary']
dependents = request.form['dependents']

data = {'name': name, 'level': level, 'gross_salary': gross_salary, 'dependents': dependents}
r = requests.post('http://localhost:5000/calculate_salary', data=data)

return r.text

if name == 'main':
app.run()