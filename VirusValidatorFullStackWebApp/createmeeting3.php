<html lang="en">
  <!-- copy-->

  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>CALENDAR</title>
    <link rel="stylesheet" href="css/createmeeting.css" />
    <!-- bootstrap css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <!-- Responsive-->

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Edu+NSW+ACT+Foundation&family=Poppins&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
      integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
  </head>

  <body>
    <div class="container mt-5">
      <div class="text-center">
        <h1 class="display-5 mb-5">CREATE MEETING:</h1>
      </div>
      <div class="main row justify-content-center">
        <form
          action="createmeeting2.php"
          method="post"
          class="row just mb-4"
          autocomplete="off"
        >
        <?php if(isset($_GET['error'])) {  ?> 
          <p class="error"> <?php echo $_GET['error']; ?></p>
        <?php } ?> 
          <div class="col-10 col-md-8 mb-3">
            <label for="email">Email:</label>
            <input
              class="form-control"
              type="email"
              id="email"
              name="email"
              placeholder="Enter the attendee's email"
            />
          </div>
          <div class="col-10 col-md-8 mb-3">
            <label for="virus-type"
              >Select the virus type you wish the attendees to be tested
              on:</label
            >
            <!-- <input
              class="form-control"
              type="text"
              id="virus-type"
              placeholder="Enter the virus name"
            /> -->
            <div class="col-10 col-md-8 mb-3">
              <select
                name="virus-type"
                id="virus-type"
                class="col-10 col-md-8 mb-3"
              >
                <option value="flu">Flu (Influenza)</option>
                <option value="covid">Coronavirus (COVID-19)</option>
                <option value="chickenpox">Chickenpox (Varicella)</option>
                <option value="tuberculosis">Tuberculosis</option>
                <option value="mpox">Monkeypox (Mpox)</option>
              </select>
            </div>
          </div>

          <div class="col-10 col-md-8 mb-3">
            <label for="date">Enter the date:</label>
            <input
              class="form-control"
              type="date"
              name="date"
              id="date"
              placeholder="Enter the date"
            />
          </div>

          <div class="col-10 col-md-8 mb-3">
            <label for="time">Enter the time:</label>
            <input
              class="form-control"
              type="time"
              id="time"
              name="time"
              placeholder="Enter the time"
            />
          </div>

          <div class="col-10 col-md-8">
            <input type="submit" class="btn btn-success" value="Submit" />
          </div>
        </form>

        <div class="col-10 mt-5">
          <table class="table table-striped table-light">
            <thead>
              <tr>
                <th>Email</th>
                <th>Type Of Virus Quiz</th>
                <th>Date</th>
                <th>Time</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody id="meeting-list">
              <td>example@example.com</td>
              <td>VIRUS</td>
              <td>0000-00-00</td>
              <td>00:00</td>
              <td>
                <a href="#" class="btn btn-warning btn-sm edit">Edit</a>
                <a href="#" class="btn btn-danger btn-sm delete">Delete</a>
              </td>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <script src="js/createmeeting.js" defer></script>
    <!-- <script src="js/create.js"></script> -->
    <script src="js/test.js"></script>
  </body>
</html>
