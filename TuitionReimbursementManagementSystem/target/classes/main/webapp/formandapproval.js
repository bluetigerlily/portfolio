let approvalmenu = false;
setup();

function setup() {
    getpendingapproval().then(() => {
        checkLogin().then(() => {
            if (loggedUser.role === 'directsuperemp') employeeSetup();
			if (loggedUser.role === 'directsuperbenco') employeeSetup();
			if (loggedUser.role === 'departmenthead') employeeSetup();
			if (loggedUser.role === 'benco') employeeSetup();
        });
    });
}

async function getevents() {
    let url = baseUrl + '/events';
    let response = await fetch(url);
    if (response.status === 200) {
        let user = await response.json();
        populateevents(user);
    }
}

function populateevents(events) {
    let events = document.getElementById('events');
    events.innerHTML = '';

    if (events.length > 0) {
        let table = document.createElement('table');
        table.id = 'eventsTable';

        table.innerHTML = `
            <tr>
                <th>user</th>
                <th>role</th>
                <th>events</th>
                <th></th>
            </tr>
        `;

        for (let user of events) {
            let tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${user.user}</td>
                <td>${user.role}</td>
                <td>${user.events}</td>
            `;
            let td = document.createElement('td');
            let ul = document.createElement('ul');
            for (let pa of user.events) {
                let li = document.createElement('li');
                li.innerHTML = pa.name;
                ul.appendChild(li);
            }
            td.appendChild(ul);
            tr.appendChild(td);

            let approvebtn = document.createElement('button');
            approvebtn.type = 'button';
            approvebtn.id = events.name + '_' + events.id;
            approvebtn.textContent = 'Approved';
           	approvebtn.disabled = !loggedUser;
            // <button type="button" id="Howard_6"
            //  disabled="false">approvebntn</button>
            
            let btnTd = document.createElement('td');
            btnTd.appendChild(approveBtn);
            tr.appendChild(btnTd);
            table.appendChild(tr);
            
            approvebtn.addEventListener('click', approveevents);
        }

        events.appendChild(table);
    } else {
        events.innerHTML = 'No events needing approval available.';
    }
}

async function approveevents() {
    let btnId = events.target.id;
    let index = btnId.indexOf('_'); // find underscore (see line 46)
    let id = btnId.slice(index+1); // get text after underscore
    let name = btnId.replace('_', ''); // remove underscore
    if (confirm('You want to approve ' + name + '?')) {
        let url = baseUrl + '/events/approve/' + id;
        let response = await fetch(url, {method:'PUT'});
        switch (response.status) {
            case 200:
                alert('You approved the event ' + name + '!');
                break;
            case 409:
                alert('That event doesn\'t seem to be needing approval...');
                break;
            case 401:
                alert('Hold on, you\'re not logged in!');
                break;
            default:
                alert('Something went wrong.');
                break;
        }
    }
}

function employeeSetup() {
    let employeeSpan = document.getElementById('role');
    employeeSpan.removeAttribute('hidden');
    // add role
    if (!(document.getElementById('addeventbutton'))) {
        let addeventbutton = document.createElement('button');
        addeventbutton.type = 'button';
        addeventbutton.textContent = 'Add event';
        addeventbutton.id = 'addeventbutton';
        addeventbutton.onclick = addeventMenu;
        employeeSpan.appendChild(addeventBtn);
    }

    // edit userTable
    let userTable = document.getElementById('user');
    for (let tr of userTable.childNodes) {
        if (tr.nodeName === 'TR') {
            let td = document.createElement('td');
            if (tr != userTable.childNodes.item(0)) {
                let editBtn = document.createElement('button');
                editBtn.id = 'edit_' + tr.childNodes.item(1).textContent;
                editBtn.type = 'button';
                editBtn.textContent = 'Edit';
                editBtn.onclick = edituser;
                td.appendChild(editBtn);
            }
            tr.appendChild(td);
        }
    }
}

function addeventMenu() {
    let employeeSpan = document.getElementById('events');
    addeventMenuOpen = !addeventMenuOpen;
    console.log('add event menu open? ' + addeventMenuOpen);

    if (addeventMenuOpen) {
        employeeSpan.innerHTML += `<form id="add-event-form">
        <label for="firstname">First Name:</label>
        <input type="text" id="name" placeholder="Name" required />

		<label for="lastname">Last Name:</label>
        <input type="text" id="name" placeholder="Name" required />
        
        <label for="useremail">Email:</label>
        <input type="email" id="email" placeholder="email" required />
        
        <label for="fundsavailable">Funds Available:</label>
        <input type="number" id="funds" placeholder="fundsavailable" required />

		<label for="fundspending">Amount Already Pending Reimbursement:</label>
        <input type="number" id="fundspending" placeholder="fundspending" required />
		
		<label for="role">Role:</label>
        <input type="text" id="role" placeholder="role" required />
		
		<label for="events">What is the event name:</label>
        <input type="text" id="events" placeholder="events" required />
	
	 <label for="eventcost">Cost of the Event:</label>
     <input type="number" id="eventcost" placeholder="eventcost" required />

	 <label for="eventlocation">Location of the Event:</label>
        <input type="text" id="eventlocation" placeholder="eventlocation" required />

		 <label for="currentdate">Todays Date:</label>
        <input type="date" id="currentdate" placeholder="currentdate" required />

	 <label for="eventstartdate">Start Date of the Event:</label>
        <input type="date" id="eventstartdate" placeholder="eventstartdate" required />
	
		 <label for="eventenddate">End Date of the Event:</label>
        <input type="date" id="eventenddate" placeholder="eventenddate" required />
	
	 <label for="eventdescription">Description of the Event:</label>
        <input type="text" id="eventdescription" placeholder="eventdescription" required />
	
 <label for="gradingformatpresentation">Will you be Doing a Presentation instead of a Letter Grade?:</label>
        <input type="boolean" id="gradingformatpresentation" placeholder="gradingformatpresentation" required />	

 <label for="gradingformatletterdefault">Will you be using the default letter grade:</label>
        <input type="boolean" id="gradingformatletterdefault" placeholder="gradingformatletterdefault" required />

 <label for="gradingformatlettercustom">Will you be using a custom passing letter grade:</label>
        <input type="boolean" id="gradingformatlettercustom" placeholder="gradingformatlettercustom" required />

 <label for="isurgent">Is your Reimbursement Request Urgent:</label>
        <input type="boolean" id="isurgent" placeholder="isurgent" required />
        

</select>

        <button type="button" onclick="addevent()" id="submit-add-event-form" >Submit</button>
        </form>
        `;
        populateevents();
        let submitAddBtn = document.getElementById('submit-add-event-form');
        submitAddBtn.onclick = addevent;
    } else {
        employeeSpan.removeChild(document.getElementById('add-event-form'));
    }

    let addeventBtn = document.getElementById('addeventBtn');
    addeventBtn.onclick = addeventMenu;
}

function editevent() {
    let editBtn = events.target;
    let editId = events.target.id;
    let editTd = editBtn.parentElement;
    let editTr = editTd.parentElement;

    let nodes = editTr.childNodes;

    editTr.innerHTML = `
        <td>${nodes.item(1).innerHTML}</td>
        <td><input id = "eCfirstname" type = "text" value = ${nodes.item(3).innerHTML}></td>
        <td><input id = "eClastname" type = "text" value = ${nodes.item(5).innerHTML}></td>
        <td>${nodes.item(7).innerHTML}</td>
        <td>${nodes.item(9).innerHTML}</td>
        <td><button disabled = 'true'>Approve</button>
        <button id = ${editId}>Save</button></td>
        `;
    //<input id = "eCevent" type = "text" value = ${nodes[3].innerHTML}>
    editBtn = document.getElementById(edituserid);
    editBtn.addEventListener('click', saveevent);

}

async function saveevent()
{
    let btnId = events.target.id;
    let index = btnId.indexOf('_');
    let id = btnId.slice(index+1); // get text after underscore

    let url = baseUrl + '/username/' + id;

    let response = await fetch(url);

    let user = await response.json();

    user.events = document.getElementById('eCfirstname').value;
    user.events = document.getElementById('eClastname').value;

    let newResponse = await fetch(url,{method:'PUT',body:JSON.stringify(events)});
    if (newResponse.status === 200) {
        alert('Updated successfully.');
    } else {
        alert('Something went wrong.');
    }
    
    setup();
}

async function populateevents() {
    let eventDropDown = document.getElementById('events');
    let url = baseUrl + '/user/events';
    let response = await fetch(url);
    if (response.status === 200) {
        for (let events of events) {
            let eventOption = document.createElement('option');
            eventOption.value = events.id;
            eventOption.textContent = events.name;
            eventDropDown.appendChild(eventOption);
        }
    } else {
        alert('Something went wrong.');
        addeventMenuOpen = true;
        addeventMenu();
    }
}

async function addevent() {
    let events = {};
    events.userid = 0;
    events.events = document.getElementById('events').value;
    events.eventcost = document.getElementById('eventcost').value;
    events.eventlocation = document.getElementById('eventlocation').value;
    events.currentdate = document.getElementById('currentdate').value;
    events.eventstartdate =document.getElementById('eventstartdate').value;
    events.eventenddate =document.getElementById('eventenddate').value;
    events.eventdescription = document.getElementById('eventdescription').value;
	events.gradingformatpresentation =document.getElementById('gradingformatpresentation').value;
	events.gradingformatletterdefault =document.getElementById('gradingformatletterdefault').value;
	events.gradingformatlettercustom =document.getElementById('gradingformatlettercustom').value;
	events.isurgent=document.getElementById('isurgent').value;
	
    let url = baseUrl + '/events';
    let response = await fetch(url, {method:'POST', body:JSON.stringify(events)});
    if (response.status === 201) {
        alert('Added event successfully.');
    } else {
        alert('Something went wrong.');
    }
    addeventMenu();
    setup();
}