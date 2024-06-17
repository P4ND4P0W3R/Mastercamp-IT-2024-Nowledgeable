let fetch = require('node-fetch')

fetch('http://localhost:3000/app.html')
.then(response => response.text()) // Si vous attendez une réponse au format JSON
.then(data => console.log(data))


