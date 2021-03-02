let baseUrl = '/TuitionReimbursementManagementSystem';
let nav = document.getElementById('navBar');
let loggedUser = null;
checkLogin();
setNav();

function setNav(){nav.innerHTML = `
            <a href="index.html"><strong>Tuition Reimbursement Managemnent System</strong></a>
            <a href="myPending.html">View Pending</a>`;
	 if (!loggedUser) {
        nav.innerHTML += `
            <form>
                <label for="user">Username: </label>
                <input id="username" name="username" type="text" />
                <label for="password"> Password: </label>
                <input id="password" name="password" type="password" />
                <button type="button" id="loginBtn">Log In</button>
            </form>
        `;
	}else {
        nav.innerHTML += `
            <a href="myPending.html">My Pending</a>
            <span>
                <a href="profile.html">${loggedUser.username}&nbsp;</a>
                <button type="button" id="loginBtn">Log Out</button>
            </span>
        `;
	}
	let loginBtn = document.getElementById('loginBtn');
	if (loggedUser) loginBtn.onclick = logout;
	else loginBtn.onclick =login;


	async function login() {
		//http://localhost:8080/users?username=postgres&password=4271
		url += 'username' + document.getElementById('username').value + '&';
		url += 'password' + document.getElementById('password').value;
		let response = await fetch(url, {method: 'POST'}); 
    switch (response.status) {
        case 200: // successful
            loggedUser = await response.json();
            setNav();
            break;
        case 400: // incorrect password
            alert('Incorrect password, try again.');
            document.getElementById('password').value = '';
            break;
        case 404: // user not found
            alert('That user does not exist.');
            document.getElementById('username').value = '';
            document.getElementById('password').value = '';
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }
}
async function logout() {
    let url = baseUrl + '/username';
    let response = await fetch(url, {method:'DELETE'});

    if (response.status != 200) alert('Something went wrong.');
    loggedUser = null;
    setNav();
}

async function checkLogin() {
    let url = baseUrl + '/username';
    let response = await fetch(url);
    if (response.status === 200) loggedUser = await response.json();
    setNav();
}
	
	}