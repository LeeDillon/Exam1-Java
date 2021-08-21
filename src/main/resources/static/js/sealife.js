const taskUrl = "http://"+window.location.hostname+":8080";

let fishtable = document.querySelector('#fishtable');

function getData(url, callback) {
  let jsonData;
  fetch(url)
    .then((response) => response.json())
    .then((data) => {
      (jsonData = data);
      console.log(data)
    })
    .then(() => callback(jsonData))
    .catch((error) => console.log(error));
}


getData(`${taskURL}/getAll`, createTable);

function createTable(tableData) {
  var table = document.createElement('table');
  var tableBody = document.createElement('tbody');
  var tableHead = document.createElement('th');

  var heading_1 = document.createElement('th');
  heading_1.innerHTML = "ID No.";
  var heading_2 = document.createElement('th');
  heading_2.innerHTML = "Name";
  var heading_3 = document.createElement('th');
  heading_3.innerHTML = "Colour";
  var heading_4 = document.createElement('th');
  heading_4.innerHTML = "Length";
  var heading_5 = document.createElement('th');
  heading_5.innerHTML = "Weight";

  table.appendChild(heading_1);
  table.appendChild(heading_2);
  table.appendChild(heading_3);
  table.appendChild(heading_4);
  table.appendChild(heading_5);


  console.log(tableData);
  tableData.forEach(function (rowData) {
    var row = document.createElement('tr');

    var id = document.createElement('td');
    id.appendChild(document.createTextNode(rowData.id));
    row.appendChild(id);

    var name = document.createElement('td');
    name.appendChild(document.createTextNode(rowData.name));
    row.appendChild(name);

    var colour = document.createElement('td');
    colour.appendChild(document.createTextNode(rowData.colour));
    row.appendChild(colour);

    var length = document.createElement('td');
    length.appendChild(document.createTextNode(rowData.length));
    row.appendChild(length);

    var weight = document.createElement('td');
    weight.appendChild(document.createTextNode(rowData.weight));
    row.appendChild(weight);

    tableBody.appendChild(row);
  });

  table.appendChild(tableBody);
  fishtable.appendChild(table);
}

let form = document.querySelector('#addfishform');
let addBtn = document.querySelector('#addfish');
addBtn.addEventListener("click", function (event) {
  postData(event)
});

function postData(event) {
  event.preventDefault();
  let fname = document.querySelector('#fishname').value;
  let fcolour = document.querySelector('#fishcolour').value;
  let flength = document.querySelector('#fishlength').value;
  let fweight = document.querySelector('#fishweight').value;
  fetch(`${taskURL}/create`, {
    method: 'post',
    headers: {
      "Content-type": "application/json"
    },
    body: JSON.stringify(
      {
        "name": fname,
        "colour": fcolour,
        "length": flength,
        "weight": fweight
      })
  })
    .then(response => console.log(response))
    .catch(error => console.log(error));
  window.location.reload();
}

let upBtn = document.querySelector('#updatefish');
upBtn.addEventListener("click", function (event) {
  updateData(event)
});

function updateData(event) {
  event.preventDefault();
  console.log('anything');
  let id = document.querySelector('#fishid').value
  let fname = document.querySelector('#fishname').value;
  let fcolour = document.querySelector('#fishcolour').value;
  let flength = document.querySelector('#fishlength').value;
  let fweight = document.querySelector('#fishweight').value;
  fetch(`${taskURL}/update/${id}`, {
    method: 'put',
    headers: {
      "Content-type": "application/json"
    },
    body: JSON.stringify(
      {
        "name": fname,
        "colour": fcolour,
        "length": flength,
        "weight": fweight
      })
  })
    .then(response => console.log(response))
    .catch(error => console.log(error));
  window.location.reload();
}

let delBtn = document.querySelector('#deleteBtn')
delBtn.addEventListener("click", function (event) {
  deleteData(event)
});

function deleteData(event) {
  event.preventDefault();
  let id = document.querySelector('#fishid').value
  fetch(`${taskURL}/delete/${id}`, {
    method: 'delete'
  })
  window.location.reload();
}