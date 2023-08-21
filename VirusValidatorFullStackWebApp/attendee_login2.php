<?php
session_start();
include "form.php";

if(isset($_POST['username']))
{
    function validate($data)
    {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
        return $data;
    }
}

$username = validate($_POST['username']);

if(empty($username))
{
    echo "<script language='javascript'>";
    echo 'alert("Error: Empty Input");';
    echo 'window.location.replace("attendee-login.php");';
    echo "</script>";
    exit();
}

$sql = "SELECT * FROM attendee_login WHERE email='$username'";

$result = mysqli_query($con, $sql);

if(mysqli_num_rows($result) === 1)
{
    $row = mysqli_fetch_assoc($result);
    if($row['email'] === $username)
    {
        echo "Logged in!";
        $_SESSION['email'] = $row['email'];
        $_SESSION['id'] = $row['id'];
        $_SESSION['virus'] = $row['virus'];
        header("Location: attendee-homepage.php");
        exit();
    }
    else
    {
        echo "<script language='javascript'>";
        echo 'alert("Error: Error");';
        echo 'window.location.replace("attendee-login.php");';
        echo "</script>";
        exit();
    }
}
else
{
    echo "<script language='javascript'>";
    echo 'alert("Invalid E-mail");';
    echo 'window.location.replace("attendee-login.php");';
    echo "</script>";
    exit();

}
?>