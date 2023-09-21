const usersTable = document.querySelector('#users-table');
const modalWindow = document.querySelector('#editModal');
const user_id = modalWindow.querySelector('[name="id"]');
const firstName = modalWindow.querySelector('[name="firstName"]');
const lastName = modalWindow.querySelector('[name="lastName"]');
const age = modalWindow.querySelector('[name="age"]');
const password = modalWindow.querySelector('[name="password"]');
const user_role = modalWindow.querySelector('[name="user_role"]');
let role_id = 2;

document.querySelector('#editModal').querySelector('#modalButtonText').addEventListener('click', event => {
    delOrUpdate();
});

function addUserToTable(user) {
    const row = document.createElement('tr');
    row.innerHTML = `<td>${user.id}</td>
                     <td>${user.firstName}</td>
                     <td>${user.lastName}</td>
                     <td>${user.age}</td>
                     <td>${user.roles.map(role => role.role).join(', ')}</td>
                        <td><button id="editButton${user.id}" style="background-color: turquoise" type="button" class="btn btn-primary editButton" data-bs-toggle="modal" data-bs-target="#editModal">Edit</button></td>
                         <td><button id="deleButton${user.id}" style="background-color: red" type="button" class="btn btn-danger editButton" data-bs-toggle="modal" data-bs-target="#editModal">Delete</button></td>`;
    row.setAttribute('id', `userRow${user.id}`);
    usersTable.appendChild(row);
}

function createPage(){
    console.log('Start')
    const tbody = usersTable.querySelector('tbody');
    while (tbody.firstChild) {
        tbody.removeChild(tbody.firstChild);
    }
    fetch("api/admin/").then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    }).then(data => {
        data.forEach(item => {
            addUserToTable(item);
        })
    });
    // Отслеживаем нажатие кнопок в таблице
    usersTable.addEventListener('click', event => {
        const target = event.target;
        if (target.classList.contains('editButton')) {
            const user_id = target.id.substring(10);
            userInfo(user_id);
            if (target.innerText === 'Delete') {
                blockModal(true, 'Delete', user_id);
            } else {
                blockModal(false, 'Edit', user_id);
            }
        }
    });
}





function blockModal(f, name) {
    const modalWindow = document.querySelector('#editModal');
    const formElements = modalWindow.querySelectorAll('.form-control');
    formElements.forEach(item => {
        item.disabled = f;
    })
    modalWindow.querySelector('#modalButtonText').innerText = name;

}

function userInfo(url_id) {
    fetch("/api/admin/" + url_id).then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    }).then(data => {
        user_id.setAttribute('value', data.id);
        firstName.setAttribute('value', data.firstName);
        lastName.setAttribute('value', data.lastName);
        age.setAttribute('value', data.age);
        password.setAttribute('value', data.password);
    });

}

function delOrUpdate(){
    if (user_role.value === "ADMIN"){
        role_id = 1;
    }else {
        role_id = 2;
    }
    const button = event.target;
    if (button.innerText === "Edit"){
        console.log('Меняем его')
        const data = {
            id: user_id.value,
            firstName: firstName.value,
            lastName: lastName.value,
            age: age.value,
            password: password.value,
            roles: [{ id: role_id, role: user_role.value }]
        }
        myRequest(data, "PATCH", '')
    }else if (button.innerText === "Delete"){
        console.log('Удаляем его')
        fetch("/api/admin/" + user_id.value, {method: "DELETE"}).then(response =>{
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            usersTable.querySelector('#userRow' + user_id.value).remove();
        });
    }
}

function myRequest(data, method, url_id) {

    const requestOptions = {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    fetch("/api/admin/" + url_id, requestOptions).then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const rowToUpdate = usersTable.querySelector("#userRow" + data.id);
        if (rowToUpdate) {
            // Обновить содержимое ячеек строки
            rowToUpdate.innerHTML = `
        <td>${data.id}</td>
        <td>${data.firstName}</td>
        <td>${data.lastName}</td>
        <td>${data.age}</td>
        <td>${data.roles.map(role => role.role).join(', ')}</td>
<td><button id="editButton${data.id}" style="background-color: turquoise" type="button" class="btn btn-primary editButton" data-bs-toggle="modal" data-bs-target="#editModal">Edit</button></td>
                         <td><button id="deleButton${data.id}" style="background-color: red" type="button" class="btn btn-danger editButton" data-bs-toggle="modal" data-bs-target="#editModal">Delete</button></td>`;
        }
    });
}
document.addEventListener('DOMContentLoaded', (event) => {
    createPage();
});