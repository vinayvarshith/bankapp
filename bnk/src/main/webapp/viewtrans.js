
b2.onclick=()=>{
		let value=document.getElementById("cust_accno").value;
		if(value==='' || value.length==0){
			alert("value is empty cannot continue the search");
			return;
		}
		//let url="/suresh_bank_1/CustomerTransactions?cust_accno=" +value;
		
	let url="http://localhost:9000/bank1/CustomerTransactions?cust_accno="+value;
		fetch(url)
		     .then(response => response.json())
		     .then(res => {
		    	 let data="<table class='table-table-striped table-bordered'> <thead class='thead-dark'> <tr><th>TransactionId</th><th>TransactionType</th><th>OpenBalance</th><th>CloseBalance</th><th>AccountNo</th><th>Date</th></thead><tbody>"
		    	 
		     
		    	 
		    	  res.forEach(e=>{
		    		  data=data +"<tr><td>" +e.trans_id + "</td>";
		    		  data=data +"<td>" + e.trans_type + "</td>";
		    		  data=data +"<td>" + e.open_bal1 + "</td>";
		    		  data=data +"<td>" + e.close_bal + "</td>";
		    		  data=data +"<td>" + e.cust_accno + "</td>";
		    		  data=data +"<td>" + e.date + "</td>";
		    		  
		    	  });
		    	 data = data + "</tbody></table>"
		    	 document.getElementById("results").innerHTML =data;
		     })
		     
	}
