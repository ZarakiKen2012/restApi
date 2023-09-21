const createForm = document.querySelector('#createForm');
createForm.querySelector('.btn-primary').addEventListener('click', event => {
    if (createForm.querySelector('[name="user_role"]').value === "ADMIN") {
        role_id = 1;
    } else {
        role_id = 2;
    }
    const data = {
        firstName: createForm.querySelector('[name="firstName"]').value,
        lastName: createForm.querySelector('[name="lastName"]').value,
        age: createForm.querySelector('[name="age"]').value,
        password: createForm.querySelector('[name="password"]').value,
        roles: [{id: role_id, role: createForm.querySelector('[name="user_role"]').value}]
    }
    fetch('/api/admin/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)

    }).then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    }).then(response => {
        const row = document.createElement('tr');
        row.innerHTML = `<td>${response}</td>
                     <td>${data.firstName}</td>
                     <td>${data.lastName}</td>
                     <td>${data.age}</td>
                     <td>${data.roles.map(role => role.role).join(', ')}</td>
<td><button id="editButton${response}" style="background-color: turquoise" type="button" class="btn btn-primary editButton" data-bs-toggle="modal" data-bs-target="#editModal">Edit</button></td>
                         <td><button id="deleButton${response}" style="background-color: red" type="button" class="btn btn-danger editButton" data-bs-toggle="modal" data-bs-target="#editModal">Delete</button></td>`;
        row.setAttribute('id', `userRow${response}`);
        usersTable.appendChild(row);
    });
});

