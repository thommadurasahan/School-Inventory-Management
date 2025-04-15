// Variables to keep track of pagination state
let currentPage = 0;
let totalPages = 0;
const pageSize = 10;

// Function to load items for a specific page
function loadItems(page) {
    fetch(`/api/inventory/items/view-paginated-items?page=${page}&size=${pageSize}`)
        .then(response => response.json())
        .then(data => {
            // Update pagination state
            currentPage = data.currentPage;
            totalPages = data.totalPages;

            // Get table reference
            const table = document.getElementById('paginated-items-table');

            // Clear existing rows except header
            while (table.rows.length > 1) {
                table.deleteRow(1);
            }

            // Add new rows from data
            data.items.forEach(item => {
                const row = table.insertRow();

                // Add cells for each column
                const idCell = row.insertCell();
                idCell.textContent = item.id;

                const nameCell = row.insertCell();
                nameCell.textContent = item.name || '';

                const typeNameCell = row.insertCell();
                typeNameCell.textContent = item.typeName || '';

                const voucherCell = row.insertCell();
                voucherCell.textContent = item.voucherNo || '';

                const quantityCell = row.insertCell();
                quantityCell.textContent = item.quantity || '';

                const supplierCell = row.insertCell();
                supplierCell.textContent = item.supplierName || '';

                const dateCell = row.insertCell();
                dateCell.textContent = item.receivedDate || '';
            });

            // Update pagination UI
            updatePagination();
        })
        .catch(error => {
            console.error('Error loading items:', error);
        });
}

// Function to update pagination UI
function updatePagination() {
    const pagination = document.getElementById('pagination');
    pagination.innerHTML = '';

    // Previous button
    const prevLink = document.createElement('a');
    prevLink.href = '#';
    prevLink.innerHTML = '&laquo;';
    if (currentPage === 0) {
        prevLink.className = 'disabled';
    } else {
        prevLink.onclick = function (e) {
            e.preventDefault();
            loadItems(currentPage - 1);
        };
    }
    pagination.appendChild(prevLink);

    // Page numbers
    const maxVisiblePages = 6; // Maximum number of page links to show
    let startPage = Math.max(0, currentPage - Math.floor(maxVisiblePages / 2));
    let endPage = Math.min(totalPages - 1, startPage + maxVisiblePages - 1);

    if (endPage - startPage < maxVisiblePages - 1) {
        startPage = Math.max(0, endPage - maxVisiblePages + 1);
    }

    for (let i = startPage; i <= endPage; i++) {
        const pageLink = document.createElement('a');
        pageLink.href = '#';
        pageLink.textContent = (i + 1).toString();
        if (i === currentPage) {
            pageLink.className = 'active';
        }
        pageLink.onclick = function (e) {
            e.preventDefault();
            loadItems(i);
        };
        pagination.appendChild(pageLink);
    }

    // Next button
    const nextLink = document.createElement('a');
    nextLink.href = '#';
    nextLink.innerHTML = '&raquo;';
    if (currentPage + 1 >= totalPages) {
        nextLink.className = 'disabled';
    } else {
        nextLink.onclick = function (e) {
            e.preventDefault();
            loadItems(currentPage + 1);
        };
    }
    pagination.appendChild(nextLink);
}

// // Load first page when page loads
// document.addEventListener('DOMContentLoaded', function () {
//     loadItems(0);
// });

function initializePagination() {
    const pagination = document.getElementById('pagination');
    pagination.innerHTML = '';

    // Add empty pagination placeholder until "View All" is clicked
    const placeholderLink = document.createElement('a');
    placeholderLink.textContent = '1';
    placeholderLink.className = 'disabled';
    pagination.appendChild(placeholderLink);
}

// Initialize the page when DOM is loaded
document.addEventListener('DOMContentLoaded', function () {
    initializePagination();
});