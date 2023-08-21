var selectedRow = null;

//Show Alerts
function showAlert(message, className) {
    const div = document.createElement("div");
    div.className = `alert alert-${className}`;

    div.appendChild(document.createTextNode(message));
    const container = document.querySelector(".container");
    const main = document.querySelector(".main");
    container.insertBefore(div, main);

    setTimeout(() => document.querySelector(".alert").remove(), 3000)
}

//Clear All Field
function clearFields() {
    // document.querySelector("#name").value = "";
    document.querySelector("#email").value = "";
    document.querySelector("#virus-type").value = "";
    document.querySelector("#date").value = "";
    document.querySelector("#time").value = "";
}

//Add Data

document.querySelector("#create-form").addEventListener("submit", (e) => {
    e.preventDefault();

    //get the values

    //  const name = document.querySelector("#name").value;
    const email = document.querySelector("#email").value;
    const virusType = document.querySelector("#virus-type").value;
    const date = document.querySelector("#date").value;
    const time = document.querySelector("#time").value;


    if (email == "" || virusType == "" || date == "" || time == "") {
        showAlert("Please fill in all fields", "danger");
    } else {
        if (selectedRow == null) {
            const list = document.querySelector("#meeting-list");
            const row = document.createElement("tr");

            row.innerHTML = `
            <td>${email}</td>
            <td>${virusType}</td>
            <td>${date}</td>
            <td>${time}</td>
             <td>
             <a href="#" class="btn btn-warning btn-sm edit">Edit</a>

                <a href="#" class="btn btn-danger btn-sm delete">Delete</a>
        
            `;
            list.append(row);
            selectedRow = null;
            showAlert("Attendee Added", "success");

        } else {
            //selectedRow.children[0].textContent = name;
            selectedRow.children[0].textContent = email;
            selectedRow.children[1].textContent = virusType;
            selectedRow.children[2].textContent = date;
            selectedRow.children[3].textContent = time;

            selectedRow = null;
            showAlert("Meeting Information Edited", "info")

        }

        //clearFields();
    }

});
//Edit Data
document.querySelector("#meeting-list").addEventListener("click", (e) => {
    target = e.target;
    if (target.classList.contains("edit")) {
        selectedRow = target.parentElement.parentElement;
        //document.querySelector("#name").value = selectedRow.children[0].textContent;
        document.querySelector("#email").value = selectedRow.children[0].textContent;
        document.querySelector("#virus-type").value = selectedRow.children[1].textContent;
        document.querySelector("#date").value = selectedRow.children[2].textContent;
        document.querySelector("#time").value = selectedRow.children[3].textContent;
    }
});
//Delete Data

document.querySelector("#meeting-list").addEventListener("click", (e) => {
    target = e.target;
    if (target.classList.contains("delete")) {
        target.parentElement.parentElement.remove();
        showAlert("Meeting Data Deleted", "danger");

    }
});