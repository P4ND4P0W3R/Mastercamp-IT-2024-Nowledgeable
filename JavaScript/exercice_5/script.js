const taskForm = document.getElementById('task-form')
const taskInput = document.getElementById('task-input')
const taskList = document.getElementById('task-list')
const notification = document.getElementById('notification')

function fetchTasks() {
    fetch('http://localhost:3000/tasks')
        .then((response) => response.json())
        .then((tasks) => {
            const taskList = document.getElementById('task-list')
            taskList.innerHTML = '' // Clear existing list

            tasks.forEach((task) => {
                const listItem = document.createElement('li')

                const checkbox = document.createElement('input')
                checkbox.type = 'checkbox'
                checkbox.checked = task.done
                checkbox.addEventListener('change', () => {
                    updateTaskStatus(task.name, checkbox.checked)
                })

                const textNode = document.createTextNode(task.name)
                listItem.appendChild(checkbox)
                listItem.appendChild(textNode)
                taskList.appendChild(listItem)
            })
        })
        .catch((error) => console.error('Error fetching tasks:', error))
}

function updateTaskStatus(taskName, done) {
    fetch(`http://localhost:3000/tasks/${taskName}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ done }),
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error('Failed to update task status')
            }
            return response.json()
        })
        .then((updatedTask) => {
            console.log('Task status updated:', updatedTask)
            fetchTasks()
        })
        .catch((error) => console.error('Error updating task status:', error))
}

fetchTasks()

taskForm.addEventListener('submit', (event) => {
    event.preventDefault()

    const taskText = taskInput.value.trim()
    if (taskText !== '') {
        fetch('http://localhost:3000/tasks', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ task: taskText }),
        })
            .then((response) => {
                if (response.ok) {
                    return response.json()
                } else {
                    throw new Error('Error when creating a task.')
                }
            })
            .then((data) => {
                console.log('Added task: ', data)
                showNotification('Task added successfully')
                taskInput.value = ''
                location.reload()
            })
            .catch((error) => {
                console.error(error)
                showNotification('Failed to add task', true)
            })
    }
})

function showNotification(message, isError = false) {
    notification.textContent = message
    notification.style.display = 'block'
    notification.style.color = isError ? 'red' : 'green'
    setTimeout(() => {
        notification.style.display = 'none'
    }, 3000)
}
