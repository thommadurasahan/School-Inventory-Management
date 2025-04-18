// Fetch and populate Type options
async function loadTypes() {
    const response = await fetch('/api/v1/types/view-types');
    if (response.ok) {
        const types = await response.json();
        const typeSelect = document.getElementById('type-name');
        types.forEach(type => {
            const option = document.createElement('option');
            option.value = type.typeId; // Use typeId as the value
            option.textContent = type.typeName;
            typeSelect.appendChild(option);
        });
    } else {
        console.error('Failed to load types');
    }
}

// Fetch and populate Supplier options
async function loadSuppliers() {
    const response = await fetch('/api/v1/suppliers/view-suppliers');
    if (response.ok) {
        const suppliers = await response.json();
        const supplierSelect = document.getElementById('supplier-name');
        suppliers.forEach(supplier => {
            const option = document.createElement('option');
            option.value = supplier.supplierId; // Use supplierId as the value
            option.textContent = supplier.supplierName;
            supplierSelect.appendChild(option);
        });
    } else {
        console.error('Failed to load suppliers');
    }
}

// Call the functions on page load
document.addEventListener('DOMContentLoaded', async () => {
    try {
        await loadTypes(); // Wait for loadTypes to complete
        await loadSuppliers(); // Wait for loadSuppliers to complete
    } catch (error) {
        console.error('Error loading types or suppliers:', error);
    }
});

// This script handles the form submission for adding a new item.
document.querySelector('form[name="item-insert-form"]').addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const jsonData = Object.fromEntries(formData.entries());

    // Convert typeName and supplierName to typeId and supplierId
    jsonData.typeId = jsonData.typeName;
    jsonData.supplierId = jsonData.supplierName;
    delete jsonData.typeName;
    delete jsonData.supplierName;

    const response = await fetch('/api/v1/items/add-item', {
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