let fetch = require('node-fetch')

fetch('http://localhost:3000/task')
    .then((response) => response.json()) // Si vous attendez une réponse au format JSON
    .then((data) => console.log(data))
