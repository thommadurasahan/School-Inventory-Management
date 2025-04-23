// Handles the form submission for adding a new type.
document.querySelector('form[name="type-insert-form"]').addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const jsonData = Object.fromEntries(formData.entries());

    const response = await fetch('http://localhost:8080/api/v1/types/add-type', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    });

    if (response.ok) {
        alert('Type added successfully!');
    } else {
        alert('Failed to add type.');
    }
});

// Function to load types
function loadTypes() {
    fetch(`http://localhost:8080/api/v1/types/view-types`)
        .then(response => response.json())
        .then(data => {

            // Get table reference
            const table = document.getElementById('types-table');

            // Clear existing rows except header
            while (table.rows.length > 1) {
                table.deleteRow(1);
            }

            // Add new rows from data
            data.types.forEach(type => {
                const row = table.insertRow();

                // Add cells for each column
                const typeIdCell = row.insertCell();
                typeIdCell.textContent = type.typeId;

                const typeNameCell = row.insertCell();
                typeNameCell.textContent = type.typeName || '';

                const typeAddedOnCell = row.insertCell();
                typeAddedOnCell.textContent = type.typeAddedOn || '';
            });

        })
        .catch(error => {
            console.error('Error loading types:', error);
            alert('Failed to load types.');
        });
}

// Handles the form submission for updating a type.
document.querySelector('form[name="type-update-form"]').addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const jsonData = Object.fromEntries(formData.entries());
    const typeId = Number(jsonData.typeId); // Extract the typeID from the form data

    const response = await fetch(`http://localhost:8080/api/v1/types/update-type-by-id/${typeId}`, { // Use backticks here
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    });

    if (response.ok) {
        alert('Type updated successfully!');
    } else {
        alert('Failed to update type.');
    }
});