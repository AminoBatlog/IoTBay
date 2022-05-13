/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function startTime() {
    let date = new Date();
    let n = date.toDateString();
    let time = date.toLocaleTimeString();
    
    document.getElementbyId('time').innerHTML = n + ' - ' + time;
    tt = display_c();
}

function display_c() {
    const refresh = 1000;
    mytime = setTimeOut('startTime()', refresh);
}

function resetSearch() {
    document.getElementbyId("searchdate").value = "";
}

function filterSearch() {
    let input, table, tr, i, id;
    input = document.getElementById("searchdate");
    table = document.getElementbyId("accessTable");
    tr = table.getElementsByTagName("tr");
    for (int i = 0; i < tr.length; i++) {
        id = tr[i].getElementsByTagName("td")[0];
    }
    if (id) {
        if (id.innerHTML.indexOf(input) > -1) {
            tr[i].style.display = "";
        } else {
            tr[i].style.display = "none";
        }
    }
    
}


