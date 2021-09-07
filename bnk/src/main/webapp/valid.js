const form = document.getElementById('form');

form.addEventListener('submit', e => {
    e.preventDefault()

    if (!checkInputs() ) {

        let url = "http://localhost:9000/bank1/bank";
        fetch(url, {
            method: 'post',
            body: JSON.stringify({
                cust_name: document.getElementById('name').value,
                cust_emailid: document.getElementById('emailid').value,
                cust_phno: document.getElementById('mobilenumber').value,
                cust_id: document.getElementById('userid').value,
                cust_pwd: document.getElementById('password').value
            }),
            headers: {
                'content-type': 'application/json; charset=UTF-8',
            }
        }).then(function (response) {
            alert("success");
            console.log("success");
            var results = document.getElementById('results')
            results.innerHTML = `<p>You have Succesfully Registered with Suresh Bank :) </p>
    <p><a href='/bank1'>Click Here to LOGIN</a></p>`})
    }
    else {
        console.log("error");
        alert("error");
    }
})

function checkInputs() {
    console.log("hii");
    const name = document.getElementById('name').value.trim();
    const cust_emailid = document.getElementById('emailid').value.trim();
    const cust_phno = document.getElementById('mobilenumber').value.trim();
    const cust_id = document.getElementById('userid').value.trim();
    const cust_pwd1 = document.getElementById('password').value.trim();

    if (name === '') {
        setErrorFor(name, 'Name Cannot be Empty');
    } else {
        setSuccessFor(name);
    }

    

    if (cust_emailid === '') {
        setErrorFor(emailid, 'Email cannot be blank');
    } else if (!isEmail(cust_emailid)) {
        setErrorFor(emailid, 'Not a valid email');
    } else {
        setSuccessFor(emailid);
    }

    if (cust_phno === '') {
        setErrorFor(mobilenumber, 'Mobile Number cannot be blank');
    } else if (!isMobileNumber(cust_phno)) {
        setErrorFor(mobilenumber, 'Not a valid MobileNumber');
    } else {
        setSuccessFor(mobilenumber);
    }

    if (cust_id === '') {
        setErrorFor(userid, 'CustomerId Cannot be Empty');
    } else {
        setSuccessFor(userid);
    }

    if (cust_pwd1 === '') {
        setErrorFor(password, 'Password cannot be blank');
    } else {
        setSuccessFor(password);
    }
}

function setErrorFor(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    formControl.className = 'form-control error';
    small.innerText = message;
}

function setSuccessFor(input) {
    const formControl = input.parentElement;
    formControl.className = 'form-control success';
}

function isEmail(cust_emailid) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(emailId);
}

function isMobileNumber(cust_phno) {
    return /^\d{10}$/;
}


