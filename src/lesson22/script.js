document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('select');
    M.FormSelect.init(elems);

    var modals = document.querySelectorAll('.modal');
    M.Modal.init(modals);
});

function calculateAge(birthdate) {
    let dob = new Date(birthdate);
    let diff_ms = Date.now() - dob.getTime();
    let age_dt = new Date(diff_ms);

    return Math.abs(age_dt.getUTCFullYear() - 1970);
}

function calculateAverageAge() {
    let table = document.getElementById('students');
    let totalAge = 0;
    let count = 0;

    for (let r = 1, n = table.rows.length; r < n; r++) {
        let age = parseInt(table.rows[r].cells[3].innerText);
        totalAge += age;
        count++;
    }
    return (totalAge / count).toFixed(2);
}

function addStudent() {
    let name = document.getElementById('name').value;
    let dob = document.getElementById('dob').value;
    let gender = document.getElementById('gender').value;
    let age = calculateAge(dob);


    let table = document.getElementById('students');

    let row = table.insertRow(-1);
    let cell1 = row.insertCell(0);
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);
    let cell4 = row.insertCell(3);

    cell1.innerHTML = name;
    cell2.innerHTML = dob;
    cell3.innerHTML = gender;
    cell4.innerHTML = age;

    let form = document.querySelector("#add-student-modal form");
    form.reset();

    let modalInstance = M.Modal.getInstance(document.getElementById('add-student-modal'));
    modalInstance.close();

    document.getElementById('average-age').innerHTML = calculateAverageAge();
}

