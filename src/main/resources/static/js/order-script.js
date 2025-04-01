const orders = [
    { id: 1, itemName: "Laptop", quantity: 2, price: "$2000", status: "Pending" },
    { id: 2, itemName: "Monitor", quantity: 5, price: "$500", status: "Completed" },
    { id: 3, itemName: "Keyboard", quantity: 10, price: "$300", status: "Pending" }
];

function filterOrders() {
    const selectedStatus = document.getElementById("statusFilter").value;
    const tableBody = document.getElementById("orderTableBody");
    tableBody.innerHTML = "";

    const filteredOrders = orders.filter(order => order.status === selectedStatus);

    if (filteredOrders.length === 0) {
        tableBody.innerHTML = "<tr><td colspan='5' style='text-align:center;'>No orders found</td></tr>";
    } else {
        filteredOrders.forEach(order => {
            const row = `<tr>
                <td>${order.id}</td>
                <td>${order.itemName}</td>
                <td>${order.quantity}</td>
                <td>${order.price}</td>
                <td>${order.status}</td>
            </tr>`;
            tableBody.innerHTML += row;
        });
    }

    document.getElementById("ordersTable").style.display = "block";
}

function updateOrder() {
    const orderId = document.getElementById("updateOrderId").value;
    const itemName = document.getElementById("updateItemName").value;
    const quantity = document.getElementById("updateQuantity").value;
    const price = document.getElementById("updatePrice").value;
    const status = document.getElementById("updateStatus").value;


    const orderIndex = orders.findIndex(order => order.id == orderId);

    if (orderIndex !== -1) {
        // Update order details
        orders[orderIndex] = { id: orderId, itemName, quantity, price, status };
        alert("Order updated successfully!");
        filterOrders();
    } else {
        alert("Order ID not found!");
    }
}












