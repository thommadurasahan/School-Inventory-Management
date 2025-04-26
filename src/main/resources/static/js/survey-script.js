// // Function to load surveys
// function loadSurveys() {
//     fetch(`http://localhost:8080/api/v1/surveys/view-surveys`)
//         .then(response => response.json())
//         .then(data => {
//
//             // Get table reference
//             const table = document.getElementById('surveys-table');
//
//             // Clear existing rows except header
//             while (table.rows.length > 1) {
//                 table.deleteRow(1);
//             }
//
//             // Add new rows from data
//             data.types.forEach(survey => {
//                 const row = table.insertRow();
//
//                 // Add cells for each column
//                 const typeIdCell = row.insertCell();
//                 typeIdCell.textContent = type.typeId;
//
//                 const typeNameCell = row.insertCell();
//                 typeNameCell.textContent = type.typeName || '';
//
//                 const typeAddedOnCell = row.insertCell();
//                 typeAddedOnCell.textContent = type.typeAddedOn || '';
//             });
//
//         })
//         .catch(error => {
//             console.error('Error loading surveys:', error);
//             alert('Failed to load surveys.');
//         });
// }

// Handles the form submission for updating a survey.
document.querySelector('form[name="survey-update-form"]').addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const jsonData = Object.fromEntries(formData.entries());
    const surveyId = Number(jsonData.surveyId); // Extract the surveyID from the form data

    const response = await fetch(`http://localhost:8080/api/v1/surveys/update-survey-by-id/${surveyId}`, { // Use backticks here
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    });

    if (response.ok) {
        alert('Survey updated successfully!');
    } else {
        alert('Failed to update survey.');
    }
});