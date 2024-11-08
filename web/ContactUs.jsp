<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - RRTS</title>
    <link rel="stylesheet" href="ContactUs.css">
</head>

<body>
    <header>
        <h1>Contact Us - Rapid Road Repair System</h1>
    </header>

    <div class="container contact-section">
        <h2>We'd Love to Hear from You</h2>
        <p>If you have any feedback, questions, or would like to share information, please fill out the form below. Our team will get back to you as soon as possible.</p>
    </div>

    <div class="container form-section">
        <form action="SubmitFeedbackServlet" method="POST">
            <label for="name">Full Name</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email Address</label>
            <input type="email" id="email" name="email" required>

            <label for="phone">Phone Number</label>
            <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" required>

            <label for="message">Message</label>
            <textarea id="message" name="message" rows="5" placeholder="Share your feedback or questions here..." required></textarea>

            <button type="submit" class="submit-btn">Submit</button>
        </form>
    </div>

    <div class="container back-home-section">
        <a href="HomePage.jsp" class="back-home-btn">Back to Home</a>
    </div>
</body>

</html>
