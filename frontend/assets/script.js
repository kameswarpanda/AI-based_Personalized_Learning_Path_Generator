// frontend/assets/js/main.js
document.getElementById('userForm').addEventListener('submit', function(event) {
  event.preventDefault();
  const skills = document.getElementById('skills').value;
  const interests = document.getElementById('interests').value;
  const background = document.getElementById('background').value;
  
  fetch('http://localhost:8080/api/generate-path', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ skills, interests, background })
  })
  .then(response => response.json())
  .then(data => alert('Learning Path: ' + data.path))
  .catch(error => console.error('Error:', error));
});
