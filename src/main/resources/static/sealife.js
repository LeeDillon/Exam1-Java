let fishtable = document.querySelector('#fishtable');

function getData(url, callback) {
    let jsonData;
    fetch(url)
      .then((response) => response.json())
      .then((data) => {(jsonData = data);
         console.log(data)})
      .then(() => callback(jsonData))
      .catch((error) => console.log(error));
  }

getData('http://localhost:9001/getAll', createTable);

function createTable(tableData) {
    var table = document.createElement('table');
    var tableBody = document.createElement('tbody');
  
    console.log(tableData);
    tableData.forEach(function(rowData) {
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

document.querySelectorAll('#addfishform input');
let datafromform = Array.from(document.querySelectorAll('#addfishform input'))
.reduce((acc, input) => ({...acc,[input.id]: input.value }), {});

function postData(url, callback) {
    fetch(url, {
    method: 'post',
    headers: {
        "Content-type": "application/json"
    },
    body: JSON.stringify(
        {
            datafromform
        })
}
.then(res => res.json())
.then((data) => console.log(`Request succeeded with JSON response ${data}`))
.catch((error) => console.log(`Request failed ${error}`)))
}

let button = document.querySelector("#addfish");
button.addEventListener("submit", postData('http://localhost:9001/create', ));
// postData('http://localhost:9001/create', postData);



