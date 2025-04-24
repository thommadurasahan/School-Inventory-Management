// Fetch and populate Type options
async function loadTypes() {
    try {
        const response = await fetch('http://localhost:8080/api/v1/types/view-types');
        if (response.ok) {
            const data = await response.json(); // Parse the JSON response
            const types = data.types; // Access the 'types' array
            console.log('Fetched types:', types); // Log the fetched data

            if (!Array.isArray(types)) {
                console.error('Expected an array but got:', types);
                alert('Failed to load types: Invalid data format.');
                return;
            }

            const typeSelect = document.getElementById('type-name');
            if (!typeSelect) {
                console.error('Element with ID "type-name" not found');
                alert('Failed to load types: Element not found.');
                return;
            }

            types.forEach(type => {
                const option = document.createElement('option');
                option.value = type.typeId; // Use typeId as the value
                option.textContent = type.typeName;
                typeSelect.appendChild(option);
            });

            console.log('Type options populated successfully.');
        } else {
            console.error('Failed to load types, status:', response.status);
            alert('Failed to load types.');
        }
    } catch (error) {
        console.error('Error loading types:', error);
        alert('Error loading types. Check console for details.');
    }
}

// Fetch and populate Supplier options
async function loadSuppliers() {
    try {
        const response = await fetch('http://localhost:8080/api/v1/suppliers/view-suppliers');
        if (response.ok) {
            const data = await response.json(); // Parse the JSON response
            const suppliers = data.suppliers; // Access the 'suppliers' array
            console.log('Fetched suppliers:', suppliers); // Log the fetched data

            if (!Array.isArray(suppliers)) {
                console.error('Expected an array but got:', suppliers);
                alert('Failed to load suppliers: Invalid data format.');
                return;
            }

            const supplierSelect = document.getElementById('supplier-name');
            if (!supplierSelect) {
                console.error('Element with ID "supplier-name" not found');
                alert('Failed to load suppliers: Element not found.');
                return;
            }

            suppliers.forEach(supplier => {
                const option = document.createElement('option');
                option.value = supplier.supplierId; // Use supplierId as the value
                option.textContent = supplier.supplierName;
                supplierSelect.appendChild(option);
            });

            console.log('Supplier options populated successfully.');
        } else {
            console.error('Failed to load suppliers, status:', response.status);
            alert('Failed to load suppliers.');
        }
    } catch (error) {
        console.error('Error loading suppliers:', error);
        alert('Error loading suppliers. Check console for details.');
    }
}

// Call the functions on page load
document.addEventListener('DOMContentLoaded', async () => {
    try {
        await loadTypes(); // Wait for loadTypes to complete
        await loadSuppliers(); // Wait for loadSuppliers to complete
    } catch (error) {
        console.error('Error initializing form selections:', error);
    }
});

// Handles the form submission for adding a new item.
document.querySelector('form[name="item-insert-form"]').addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const jsonData = Object.fromEntries(formData.entries());

    // Convert typeName and supplierName to typeId and supplierId
    jsonData.typeId = jsonData.typeName;
    jsonData.supplierId = jsonData.supplierName;
    delete jsonData.typeName;
    delete jsonData.supplierName;

    const response = await fetch('http://localhost:8080/api/v1/items/add-item', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    });

    if (response.ok) {
        alert('Item added successfully!');
    } else {
        alert('Failed to add item.');
    }
});

// Function to load items
function loadItems() {
    fetch(`http://localhost:8080/api/v1/items/view-items`)
        .then(response => response.json())
        .then(data => {
            // Check if the response is an array
            if (!Array.isArray(data)) {
                console.error('Expected an array but got:', data);
                alert('Failed to load items: Invalid response format.');
                return;
            }

            // Get table reference
            const table = document.getElementById('items-table');

            // Clear existing rows except header
            while (table.rows.length > 1) {
                table.deleteRow(1);
            }

            // Add new rows from data
            data.forEach(item => {
                const row = table.insertRow();

                // Add cells for each column
                const itemIdCell = row.insertCell();
                itemIdCell.textContent = item.itemId;

                const itemNameCell = row.insertCell();
                itemNameCell.textContent = item.itemName || '';

                const typeNameCell = row.insertCell();
                typeNameCell.textContent = item.type?.typeName || '';

                const voucherNoCell = row.insertCell();
                voucherNoCell.textContent = item.voucherNo || '';

                const quantityCell = row.insertCell();
                quantityCell.textContent = item.quantity || '';

                const supplierNameCell = row.insertCell();
                supplierNameCell.textContent = item.supplier?.supplierName || '';

                const receivedOnCell = row.insertCell();
                receivedOnCell.textContent = item.receivedOn || '';
            });

            console.log('Items loaded successfully.');
        })
        .catch(error => {
            console.error('Error loading items:', error);
            alert('Error loading items. Check console for details.');
        });
}

// Handles the form submission for updating an item.
document.querySelector('form[name="item-update-form"]').addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const jsonData = Object.fromEntries(formData.entries());
    const itemId = Number(jsonData.itemId); // Extract the itemID from the form data

    const response = await fetch(`http://localhost:8080/api/v1/items/update-item-by-id/${itemId}`, { // Use backticks here
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    });

    if (response.ok) {
        alert('Item updated successfully!');
    } else {
        alert('Failed to update item.');
    }
});