// Handles the form submission for adding a new supplier.
document.querySelector('form[name="supplier-insert-form"]').addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const jsonData = Object.fromEntries(formData.entries());

    const response = await fetch('http://localhost:8080/api/v1/suppliers/add-supplier', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    });

    if (response.ok) {
        alert('Supplier added successfully!');
    } else {
        alert('Failed to add supplier.');
    }
});

// Function to load Suppliers
function loadSuppliers() {
    fetch(`http://localhost:8080/api/v1/suppliers/view-suppliers`)
        .then(response => response.json())
        .then(data => {

            // Get table reference
            const table = document.getElementById('suppliers-table');

            // Clear existing rows except header
            while (table.rows.length > 1) {
                table.deleteRow(1);
            }

            // Add new rows from data
            data.suppliers.forEach(supplier => {
                const row = table.insertRow();

                // Add cells for each column
                const supplierIdCell = row.insertCell();
                supplierIdCell.textContent = supplier.id;

                const supplierNameCell = row.insertCell();
                supplierNameCell.textContent = supplier.supplierName || '';

                const addressCell = row.insertCell();
                addressCell.textContent = supplier.address || '';

                const contactNoCell = row.insertCell();
                contactNoCell.textContent = supplier.contactNo || '';

                const supplierAddedOnCell = row.insertCell();
                supplierAddedOnCell.textContent = supplier.supplierAddedOn || '';
            });

        })
        .catch(error => {
            console.error('Error loading suppliers:', error);
            alert('Failed to load suppliers.');
        });
}