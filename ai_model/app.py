# ai_model/app.py
from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/generate-learning-path', methods=['POST'])
def generate_learning_path():
    # Get the JSON data sent by the frontend
    data = request.json
    skills = data['skills']
    interests = data['interests']
    background = data['background']
    
    # Simple AI logic to generate a learning path (you can expand this)
    learning_path = f"Based on your skills: '{skills}', interests: '{interests}', and background: '{background}', we recommend starting with Data Science."

    # Return the generated learning path as JSON
    return jsonify({'path': learning_path})

if __name__ == '__main__':
    app.run(port=5000, debug=True)
