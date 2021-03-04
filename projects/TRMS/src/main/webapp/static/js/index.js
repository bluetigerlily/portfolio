let baseUrl = '/TRMS/static';
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
                <label for="username">Username: </label>
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
                <a href="profile.html">${loggedUser.user}&nbsp;</a>
                <button type="button" id="loginBtn">Log Out</button>
            </span>
        `;
	}
 


let loginBtn = document.getElementById('loginBtn');
if (loggedUser) loginBtn.onclick = logout;
else loginBtn.onclick =login;

}

	async function login() {
		//http://localhost:8083/users?user=postgres&pass=4271
		login.innerHTML= '<form id = login></form>'
		let url = baseUrl + '/user/login?';
		url += 'username=' + document.getElementById('username').value + '&';
        url += 'password=' + document.getElementById('password').value;
        
        let response = await fetch(url, {method: 'POST'}); 
        console.log("step 0")
        console.log(response);
    switch (response.status) {
        case 200: // successful
            loggedUser = await response.json();
           setNav();
           console.log("step 1")
           break;

        case 400: // incorrect password
            alert('Incorrect password, try again.');
            document.getElementById('password').value = '';
            console.log("step 2")
            break;
        case 404: // user not found
            alert('That user does not exist.');
            document.getElementById('username').value = '';
            document.getElementById('password').value = '';
            console.log("step 3")
            break;
        default: // other error
            alert('Something went wrong.');
            console.log("step 4")
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
	
