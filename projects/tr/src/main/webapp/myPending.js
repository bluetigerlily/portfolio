checkLogin().then(populateEvents);

function populateEvents() {
    let events = loggedUser.events;
    let events = document.getElementById('events');

    if (events.length > 0) {
        let table = document.createElement('table');

        table.innerHTML = `
            <tr>
                <th>user</th>
                <th>events</th>
                <th>role</th>
            </tr>
        `;

        for (let user of events) {
            let tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${user.user}</td>
                <td>${user.events}</td>
                <td>${user.role}</td>
            `;
            let td = document.createElement('td');
            let ul = document.createElement('ul');
 
            td.appendChild(ul);
            tr.appendChild(td);
            table.appendChild(tr);
        }

        events.appendChild(table);
    } else {
        events.innerHTML = 'You don\'t have any pending event forms.';
    }
}