<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>View Citizens</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
            text-align: center;
        }

        .button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Citizen Details</h1>

    <%-- Get the list of citizens from the request attribute --%>
    <%
        List<String[]> citizensList = (List<String[]>) request.getAttribute("citizensList");
        if (citizensList != null && !citizensList.isEmpty()) {
    %>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Address</th>
                </tr>
            </thead>
            <tbody>
                <%-- Loop through the list of citizens and display their details --%>
                <%
                    for (String[] citizen : citizensList) {
                %>
                    <tr>
                        <td><%= citizen[0] %></td>
                        <td><%= citizen[1] %></td>
                        <td><%= citizen[2] %></td>
                        <td><%= citizen[3] %></td>
                        <td><%= citizen[4] %></td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <% } else { %>
        <p>No citizens found.</p>
    <% } %>

    <a href="ClerkPage.jsp" class="button">Back to Home</a>
</body>
</html>
