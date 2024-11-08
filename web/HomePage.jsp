<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RRTS</title>
    <link rel="icon" href="Images/HomeLogo.jpg" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="HomePage.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>

<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="HomePage.jsp">
                <img src="Images/HomeLogo.jpg" alt="Logo" class="img-fluid rounded-circle navbar-logo">
                <span class="navbar-text">RoadRepair</span> <!-- Separate span for the text -->
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" 
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="HomePage.jsp"><i class="bi bi-house-door"></i> Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="LoginPage.jsp"><i class="bi bi-person-circle"></i> Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ContactUs.jsp"><i class="bi bi-envelope"></i> Contact Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AboutUs.jsp"><i class="bi bi-info-circle"></i> About Us</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
    
<!--    WELCOME SECTION-->
    <div class="welcome-section">
        <div class="main-heading">Welcome to the RRTS Website</div>
        
        <p class="subheading">Where community meets infrastructure improvement.</p>

        <div class="section-heading">Effortless Reporting</div>
        <ul>
            <li>We have streamlined the road repair process, empowering you to report issues effortlessly and efficiently.</li>
            <li>Your voice is essential to us, and we are dedicated to ensuring that it is heard loud and clear.</li>
            <li>Our innovative platform simplifies the complaint process, providing you with real-time updates on the status of your reports.</li>
            <li>Witness the commitment of our dedicated teams as they work tirelessly to enhance and maintain your community's road network.</li>
        </ul>

        <div class="section-heading">Transparency and Community Involvement</div>
        <ul>
            <li>We believe in transparency, offering open access to the status of all reported complaints to foster trust within the community.</li>
            <li>By actively involving residents, we cultivate a sense of shared responsibility and accountability.</li>
            <li>Together, we ensure a collaborative and proactive approach to road repair and maintenance.</li>
        </ul>

        <div class="section-heading">Join Us in Building a Better Future</div>
        <p>Let?s work together to create safer, more resilient roads for everyone.</p>
        <ul>
            <li>Report an issue now and be part of the momentum toward a better-connected community!</li>
            <li>Join us in our mission to ensure well-maintained and accessible roads for all.</li>
            <li>Be a catalyst for positive change in your neighborhood!</li>
        </ul>

        <!-- Video Section -->
        <div class="video-container">
            <video autoplay muted loop class="background-video">
                <source src="HomeVideo/homevideo.mp4" type="video/mp4">
                Your browser does not support the video tag.
            </video>
        </div>

        <div class="login-button-container">
            <div class="d-grid gap-2 d-md-block">
                <button type="button" class="btn btn-primary btn-lg btn-custom"  onclick="window.location.href='Login.jsp';">
                    Login
                </button>
            </div>
        </div>
    
        <!-- Content Section -->
        <div class="container-fluid text-center bg-white py-5 mt-5">
            <h1 class="animate-characters">Revitalize Our Roads Together</h1>
            <p class="lead mt-4">Explore our ongoing road repair initiatives aimed at enhancing safety and accessibility!</p>
            <p class="mt-3">Check out our image gallery showcasing the transformation of our community?s roadways!</p>
        </div>


        <!-- Carousel Section -->

        <div class="carousel-container">
            <div id="imageCarousel" class="carousel slide my-5" data-bs-ride="carousel" data-bs-interval="1000">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="Images/carousel.jpg" class="d-block w-100" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img src="Images/carousel1.jpg" class="d-block w-100" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img src="Images/carousel2.jpg" class="d-block w-100" alt="Third slide">
                    </div>
                    <div class="carousel-item">
                        <img src="Images/carousel3.jpg" class="d-block w-100" alt="Fourth slide">
                    </div>
                    <div class="carousel-item">
                        <img src="Images/carousel4.jpg" class="d-block w-100" alt="Fifth slide">
                    </div>
                    <div class="carousel-item">
                        <img src="Images/carousel5.jpg" class="d-block w-100" alt="Fifth slide">
                    </div>
                    <div class="carousel-item">
                        <img src="Images/carousel6.jpg" class="d-block w-100" alt="Fifth slide">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#imageCarousel" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#imageCarousel" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>

        <div class="content">
           <div class="container-2">
               <p class="articletext text-center">
                   <i class="fas fa-arrows-alt spin-icon" style="font-size: 1.5em;"></i>
                   Road Articles
                   <i class="fas fa-arrows-alt spin-icon" style="font-size: 1.5em;"></i>
               </p>

               <div class="row g-3 text-center container-fluid">
                   <!-- Article 1 -->
                   <div class="col-md-3">
                       <div class="card">
                           <div class="card-body">
                               <h5 class="card-title">Many roads in city have bumps...</h5>
                               <p class="card-text">Mastic asphalt is a bituminous mixture that has more bitumen content...</p>
                               <a href="Articles/article1.jsp" class="btn btn-primary">Know more ?</a>
                           </div>
                       </div>
                   </div>

                   <!-- Article 2 -->
                   <div class="col-md-3">
                       <div class="card">
                           <div class="card-body">
                               <h5 class="card-title">Roads across Kolkata lie battered...</h5>
                               <p class="card-text">The Bypass service road leading to the Ruby crossing from Avishikta...</p>
                               <a href="Articles/article2.jsp" class="btn btn-primary">Know more ?</a>
                           </div>
                       </div>
                   </div>

                   <!-- Article 3 -->
                   <div class="col-md-3">
                       <div class="card">
                           <div class="card-body">
                               <h5 class="card-title">KMC using plastic in Diamond Harbour Road</h5>
                               <p class="card-text">The stretch of Diamond Harbour Road where the KMC is using plastic...</p>
                               <a href="Articles/article3.jsp" class="btn btn-primary">Know more ?</a>
                           </div>
                       </div>
                   </div>

                   <!-- Article 4 -->
                   <div class="col-md-3">
                       <div class="card">
                           <div class="card-body">
                               <h5 class="card-title">Improving rural road connectivity</h5>
                               <p class="card-text">Efforts are being made to connect remote villages through better roads...</p>
                               <a href="Articles/article4.jsp" class="btn btn-primary">Know more ?</a>
                           </div>
                       </div>
                   </div>


                   <!-- Article 3 -->
                   <div class="col-md-3">
                       <div class="card">
                           <div class="card-body">
                               <h5 class="card-title">KMC using plastic in Diamond Harbour Road</h5>
                               <p class="card-text">The stretch of Diamond Harbour Road where the KMC is using plastic...</p>
                               <a href="Articles/article3.jsp" class="btn btn-primary">Know more ?</a>
                           </div>
                       </div>
                   </div>

                   <!-- Article 4 -->
                   <div class="col-md-3">
                       <div class="card">
                           <div class="card-body">
                               <h5 class="card-title">Improving rural road connectivity</h5>
                               <p class="card-text">Efforts are being made to connect remote villages through better roads...</p>
                               <a href="Articles/article4.jsp" class="btn btn-primary">Know more ?</a>
                           </div>
                       </div>
                   </div>

                    <!-- Article 1 -->
                   <div class="col-md-3">
                       <div class="card">
                           <div class="card-body">
                               <h5 class="card-title">Many roads in city have bumps...</h5>
                               <p class="card-text">Mastic asphalt is a bituminous mixture that has more bitumen content...</p>
                               <a href="Articles/article1.jsp" class="btn btn-primary">Know more ?</a>
                           </div>
                       </div>
                   </div>

                   <!-- Article 2 -->
                   <div class="col-md-3">
                       <div class="card">
                           <div class="card-body">
                               <h5 class="card-title">Roads across Kolkata lie battered...</h5>
                               <p class="card-text">The Bypass service road leading to the Ruby crossing from Avishikta...</p>
                               <a href="Articles/article2.jsp" class="btn btn-primary">Know more ?</a>
                           </div>
                       </div>
                   </div>


               </div>
           </div>
       </div>
    
    <!--     accordian    -->
    
    <div class="container mt-5" id="FAQ">
    <div class="accordion" id="accordionExample">
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    How can I report a road repair issue?
                </button>
            </h2>
            <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    To report a road repair issue, you can reach out to our dedicated hotline at [8889988899] or submit a written complaint on our website. We encourage you to provide detailed information, including the location, description of the issue, and any other relevant details.
                </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    Can I track the status of my reported road repair request?
                </button>
            </h2>
            <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    Yes, you can track the status of your reported road repair request by visiting our website. Use the provided tracking tool and enter your unique reference number to get real-time updates on the progress of repairs.
                </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    How are repair priorities determined?
                </button>
            </h2>
            <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    Repair priorities are determined by our experienced supervisors. They assess the severity of the road condition, considering factors such as safety risks, traffic volume, and the type of locality. Emergency repairs and critical issues are prioritized to ensure public safety.
                </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                    Can I request road repair statistics for my area?
                </button>
            </h2>
            <div id="collapseFour" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    Absolutely! To request road repair statistics for your area, please contact our office or submit a request through our website. We'll provide you with comprehensive information on the number and types of repairs carried out in your locality.
                </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                    Can residents participate in community efforts to improve road conditions?
                </button>
            </h2>
            <div id="collapseFive" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    Absolutely! We encourage community involvement in maintaining road conditions. Residents can participate in awareness campaigns, report issues promptly, and follow safety guidelines during repairs to contribute to the overall improvement of road infrastructure.
                </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                    How can I contact the mayor to discuss road repair concerns at a broader level?
                </button>
            </h2>
            <div id="collapseSix" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    Residents can contact the mayor's office through the designated contact channels to discuss road repair concerns at a broader level. The mayor welcomes input from the community and works towards addressing concerns to improve the city's infrastructure.
                </div>
            </div>
        </div>
    </div>
</div>
    </div>
    <!-- Footer -->
   <footer class="text-center mt-auto py-3" style="color: white; background-color: #091c3b;">
    <div class="container">
        <p class="mb-0" style="color: white;">&copy; 2024 RoadRepair. All rights reserved.</p>
        <div class="d-flex justify-content-center">
            <a href="#" class="mx-2 text-white"><i class="bi bi-facebook"></i></a>
            <a href="#" class="mx-2 text-white"><i class="bi bi-twitter"></i></a>
            <a href="#" class="mx-2 text-white"><i class="bi bi-instagram"></i></a>
        </div>
    </div>
</footer>



    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
</body>

</html>
