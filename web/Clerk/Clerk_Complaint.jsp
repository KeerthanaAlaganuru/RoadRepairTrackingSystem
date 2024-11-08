<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clerk Complaint Form</title>
    <style>
        /* Same styling as before */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            box-sizing: border-box;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            font-size: 14px;
            margin-bottom: 6px;
        }
        input,
        textarea,
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }
        input:focus,
        textarea:focus,
        select:focus {
            border-color: #4caf50;
            outline: none;
        }
        button {
            width: 100%;
            padding: 12px;
            background-color: #4caf50;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
        button:disabled {
            background-color: #ccc;
            cursor: not-allowed;
        }
        .back-btn {
            background-color: #f44336;
            margin-top: 12px;
            color: white;
            font-size: 16px;
        }
        .back-btn:hover {
            background-color: #e53935;
        }
    </style>
</head>

<body>
    <form id="clerkForm" method="post" action="ClerkComplaintSubmissionServlet">
        <h2>Clerk Complaint Form</h2>

        <!-- Clerk-specific Information -->
        <div>
            <label for="clerkName">Name:</label>
            <input type="text" id="clerkName" name="clerkName" value="<%= session.getAttribute("clerkName") %>" readonly>

            <label for="clerkPhone">Phone:</label>
            <input type="tel" id="clerkPhone" name="clerkPhone" placeholder="Your Phone" required>

            <label for="location">Location (Urban/Rural):</label>
            <input type="text" id="location" name="location" placeholder="Location" required>

            <label for="issue">Address:</label>
            <textarea id="issue" name="issue" rows="4" placeholder="Address" required></textarea>

            <label for="complaintType">Complaint Type:</label>
            <select id="complaintType" name="complaintType" required>
                <option value="">Select Road Related Complaint Type</option>
                <option value="Potholes">Potholes</option>
                <option value="Road Damage">Road Damage</option>
                <option value="Street Light Issue">Street Light Issue</option>
                <option value="Traffic Signal Issue">Traffic Signal Issue</option>
                <option value="Blocked Drain">Blocked Drain</option>
                <option value="Roadside Garbage">Roadside Garbage</option>
                <option value="Speed Bumps Issue">Speed Bumps Issue</option>
                <option value="Road Construction Delay">Road Construction Delay</option>
            </select>

            <label for="message">Message:</label>
            <textarea id="message" name="message" rows="4" placeholder="Details of the complaint" required></textarea>
        </div>

        <!-- Submit Button -->
        <div>
            <button type="submit">Submit</button>
        </div>

        <!-- Back to Home Button -->
        <div>
            <button type="button" class="back-btn" onclick="window.location.href='ClerkPage.jsp'">Back to Home</button>
        </div>
    </form>
</body>

</html>
