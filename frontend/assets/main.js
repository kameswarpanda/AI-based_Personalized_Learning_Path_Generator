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
  .then(data => {
    // Get the div where you want to display the result
    const learningPathDiv = document.getElementById('learningPathResult');
    
    // Display the generated learning path in the div
    learningPathDiv.innerHTML = `<p><strong>Learning Path:</strong> ${data.path}</p>`;
  })
  .catch(error => {
    console.error('Error:', error);
    
    // Display an error message if the fetch fails
    const learningPathDiv = document.getElementById('learningPathResult');
    learningPathDiv.innerHTML = `<p style="color:red;"><strong>Error:</strong> Unable to generate the learning path.</p>`;
  });
});
