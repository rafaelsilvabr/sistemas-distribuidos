from flask import Flask, request

app = Flask(name)

@app.route('/calculate_salary', methods=['POST'])
def calculate_salary():

name = request.form['name']
level = request.form['level']
gross_salary = int(request.form['gross_salary'])
dependents = int(request.form['dependents'])

if level == "A":
if dependents == 0:
discount = 0.03
else:
discount = 0.08
elif level == "B":
if dependents == 0:
discount = 0.05
else:
discount = 0.1
elif level == "C":
if dependents == 0:
discount = 0.08
else:
discount = 0.15
elif level == "D":
if dependents == 0:
discount = 0.1
else:
discount = 0.17

net_salary = gross_salary - (gross_salary * discount)

return str(net_salary)

if name == 'main':
app.run()