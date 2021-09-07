
b1.onclick = () => {
    let url = "http://localhost:9000/bank1/EmpSearch?"
    fetch(url)
        .then(response => response.json())
        .then(res => {
            let data = "<table class='table table-striped table-bordered'> <thead class='thead-dark'> <tr><th>CustName</th><th>CustAccNo</th><th>AAdhar</th><th>OpenBal</th><th>CustID</th></thead><tbody>"
            res.forEach(e => {
                data = data + "<tr><td>" + "hello" + "</td>";
                data = data + "<td>" + e.cust_accno+ "</td>";
                data = data + "<td>" + e.aadhar + "</td>";
                data = data + "<td>" + e.open_bal + "</td>";
                data = data + "<td>" + e.userId1 + "</td></tr>";
            });
            data = data + "</tbody></table>"
            document.getElementById("results").innerHTML = data;
        })

}

b2.onclick = () => {
	
	let value=document.getElementById("cust_accno").value;
	if(value==='' || value.length==0){
		alert("value is empty cannot continue the search");
		return;
	}
	
    let url = "http://localhost:9000/bank1/EmployeSearchByAcc?cust_accno=" +value;
    fetch(url)
        .then(response => response.json())
        .then(res => {
        	let data = "<table class='table table-striped table-bordered'> <thead class='thead-dark'> <tr><th>CustName</th><th>CustAccNo</th><th>AAdhar</th><th>OpenBal</th><th>CustID</th></thead><tbody>"
                res.forEach(e => {
                    data = data + "<tr><td>" + e.cust_name + "</td>";
                    data = data + "<td>" + e.cust_accno+ "</td>";
                    data = data + "<td>" + e.aadhar + "</td>";
                    data = data + "<td>" + e.open_bal + "</td>";
                    data = data + "<td>" + e.userId1 + "</td></tr>";
                });
                data = data + "</tbody></table>"
                document.getElementById("results").innerHTML = data;
            })

}