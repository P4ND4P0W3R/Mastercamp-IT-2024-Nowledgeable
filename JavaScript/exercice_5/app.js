const express = require('express')
const app = express()
const port = 3000

const cors = require('cors')

app.use(cors())
app.use(express.json())

const tasks = [
    { name: 'eat', done: false },
    { name: 'sleep', done: false },
    { name: 'code', done: false },
]

app.post('/tasks', (req, res) => {
    const newTask = { name: req.body.task, done: false }
    tasks.push(newTask)
    res.json({ message: 'Task added successfully' })
})

app.get('/tasks', (req, res) => {
    res.json(tasks)
})

app.put('/tasks/:name', (req, res) => {
    const taskName = req.params.name
    const done = req.body.done

    const taskIndex = tasks.findIndex((task) => task.name === taskName)
    if (taskIndex !== -1) {
        tasks[taskIndex].done = done
        res.json({ message: 'Task status updated successfully' })
    } else {
        res.status(404).json({ error: 'Task not found' })
    }
})

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})
