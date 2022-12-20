from flask import Flask, request

app = Flask(name)

@app.route('/calculate_credit', methods=['POST'])
def calculate_credit():
data = request.get_json()
name = data['name']
average_balance = data['average_balance']

if average_balance <= 200:
credit = 0
elif average_balance <= 400:
credit = 0.2 * average_balance
elif average_balance <= 600:
credit = 0.3 * average_balance
else:
credit = 0.4 * average_balance

return f'{name}, your average balance is {average_balance} and your credit amount is {credit}'

if name == 'main':
app.run()