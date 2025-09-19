// Handles the form submission for updating a repair.
document.querySelector('form[name="repair-update-form"]').addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const jsonData = Object.fromEntries(formData.entries());
    const repairId = Number(jsonData.repairId); // Extract the repairID from the form data

    const response = await fetch(`http://localhost:8080/api/v1/repairs/update-repair-by-id/${repairId}`, { // Use backticks here
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    });

    if (response.ok) {
        alert('Repair updated successfully!');
    } else {
        alert('Failed to update repair.');
    }
});