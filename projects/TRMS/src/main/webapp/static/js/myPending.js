
checkLogin().then(populateEvents);
checkLogin().then(poplutateRole);
checkLogin().then(populateUser);


function populateEvents() {
    let events = loggedUser.events;
    let events = document.getElementById('events');

    if (events.length > 0) {
        let table = document.createElement('table');

        table.innerHTML = `
            <tr>
                <th>id</th>
                <th>certification</th>
                <th>certificationprep</th>
                <th>other</th>
                <th>seminar</th>
                <th>technicaltraining</th>
                <th>universitycourse</th>
                <th>eventcost</th>
                <th>eventlocation</th>
                <th>currentdate</th>
                <th>eventstartdate</tr>
                <th>eventenddate</tr>
                <th>eventdescription</th>
                <th>gradingformatpresentation</th>
                <th>gradingformatletterdefault</th>
                <th>gradingformatlettercustom</th>
                <th>requestjustification</th>
                <th>isurgent</th>
                <th>rejectionjustification</th>
                <th>empsubmitted</th>
                <th>dseapproved</th>
                <th>dhapproved</th>
                <th>bencoapproved</th>
                <th>finalsay</th>
                <th>changerequestamount</th>
                <th>changedamountto</th>
                <th>events</th>
            </tr>
        `;
    
    for (let user of events) {
            let tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${user.id}</td>
                <td>${user.role}</td>
                <td>${user.events}</td>
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

function populateUser() {
    let user = loggedUser.user;
    let user = document.getElementById('user');

    if (user.length > 0) {
        let table = document.createElement('table');

        table.innerHTML = `
            <tr>
                <th>id</th>
                <th>username</th>
                <th>password</th>
                <th>firstname</th>
                <th>lastname</th>
                <th>useremail</th>
                <th>fundsavailable</th>
                <th>fundspending</th>
                <th>role</th>
                <th>events</th>
            </tr>
        `;
        
    
 for (let user of user) {
            let tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${user.fundsavailable}</td>
                <td>${user.funndspending}</td>
                <td>${user.role}</td>
            `;

            let td = document.createElement('td');
            let ul = document.createElement('ul');
 
            td.appendChild(ul);
            tr.appendChild(td);
            table.appendChild(tr);

        user.appendChild(table);
      } 
          } else {
        user.innerHTML = 'Your Funds Available will Reset at the Start of the New Year.';

}
}

function populateRole() {
    let role = loggedUser.role;
    let role = document.getElementById('role');

    if (role.length > 0) {
        let table = document.createElement('table');

        table.innerHTML = `
            <tr>
                <th>id</th>
                <th>employee</th>
                <th>directsuperemp</th>
                <th>directsuperbenco</th>
                <th>departmenthead</th>
                <th>benco</th>
                <th>role</th>
            </tr>
        `;
    
    
        role.appendChild(table);
      } else {

        user.innerHTML = 'Your Role is '+role;

}
}
        

    