<?php
session_start();
include "form.php";

// Get the form data from the $_POST superglobal array
$q1 = $_POST['q1'];
$q2 = $_POST['q2'];
$q3 = $_POST['q3'];
$q4 = $_POST['q4'];
$q5 = $_POST['q5'];
$q6 = $_POST['q6'];
$q7 = $_POST['q7'];
$q8 = $_POST['q8'];
$q9 = $_POST['q9'];
$q10 = $_POST['q10'];
$email = $_SESSION['email'];
$virus = $_SESSION['virus'];
// Determine the test result based on the survey responses
$sql = "SELECT * FROM attendee_login WHERE email='$email'";
$result = mysqli_query($con, $sql); 

if(mysqli_num_rows($result) === 1)
{
    $row = mysqli_fetch_assoc($result);
    if($row['virus'] == "covid")
    {
        if ($q1 == 'no' && $q2 == 'no' && $q3 == 'no' && $q4 == 'no' && $q5 == 'no' && 
        $q6 == 'no' && $q7 == 'no' && $q8 == 'no' && $q9 == 'no' && $q10 == 'no') 
        {            
            $sql = "INSERT INTO test_results (email, result, virus) VALUES ('$email', 'passed', '$virus')";
            if (mysqli_query($con, $sql)) 
            {
                echo "New record created successfully";
            } 
            else 
            {
                echo "Error: " . $sql . "<br>" . mysqli_error($con);
            }
            mysqli_close($con);
            unset($_SESSION['id']);
            unset($_SESSION['email']);
            unset($_SESSION['virus']);
            header("Location: pass.html");
            exit();
        } 
        else 
        {
            $sql = "INSERT INTO test_results (email, result) VALUES ('$email', 'failed')";
            if (mysqli_query($con, $sql)) 
            {
                echo "New record created successfully";
            } 
            else 
            {
                echo "Error: " . $sql . "<br>" . mysqli_error($con);
            }
            mysqli_close($con);
            unset($_SESSION['id']);
            unset($_SESSION['email']);
            header("Location: fail.html");
            exit();
        }
    }
    else if($row['virus'] == "flu")
    {
        if ($q1 == 'no' && $q2 == 'yes' && $q3 == 'yes' && $q4 == 'yes' && $q5 == 'yes' && 
        $q6 == 'yes' && $q7 == 'yes' && $q8 == 'yes' && $q9 == 'yes' && $q10 == 'yes') 
        {
            $sql = "INSERT INTO test_results (email, result, virus) VALUES ('$email', 'failed', '$virus')";
            if (mysqli_query($con, $sql)) 
            {
                echo "New record created successfully";
            } 
            else 
            {
                echo "Error: " . $sql . "<br>" . mysqli_error($con);
            }
            mysqli_close($con);
            unset($_SESSION['id']);
            unset($_SESSION['email']);
            unset($_SESSION['virus']);
            header("Location: fail.html");
            exit();
        } 
        else 
        {
            $sql = "INSERT INTO test_results (email, result, virus) VALUES ('$email', 'passed', '$virus')";
            if (mysqli_query($con, $sql)) 
            {
                echo "New record created successfully";
            } 
            else 
            {
                echo "Error: " . $sql . "<br>" . mysqli_error($con);
            }
            mysqli_close($con);
            unset($_SESSION['id']);
            unset($_SESSION['email']);
            unset($_SESSION['virus']);
            header("Location: pass.html");
            exit();
        }

    }
    else if($row['virus'] == "chickenpox")
    {
        if ($q1 == 'yes' && $q2 == 'no' && $q3 == 'yes' && $q4 == 'yes' && $q5 == 'yes' && 
        $q6 == 'yes' && $q7 == 'yes' && $q8 == 'yes' && $q9 == 'yes' && $q10 == 'yes') 
        {
            $sql = "INSERT INTO test_results (email, result, virus) VALUES ('$email', 'failed', '$virus')";
            if (mysqli_query($con, $sql)) 
            {
                echo "New record created successfully";
            } 
            else 
            {
                echo "Error: " . $sql . "<br>" . mysqli_error($con);
            }
            mysqli_close($con);
            unset($_SESSION['id']);
            unset($_SESSION['email']);
            unset($_SESSION['virus']);
            header("Location: fail.html");
            exit();
        } 
        else 
        {
            $sql = "INSERT INTO test_results (email, result, virus) VALUES ('$email', 'passed', '$virus')";
            if (mysqli_query($con, $sql)) 
            {
                echo "New record created successfully";
            } 
            else 
            {
                echo "Error: " . $sql . "<br>" . mysqli_error($con);
            }
            mysqli_close($con);
            unset($_SESSION['id']);
            unset($_SESSION['email']);
            unset($_SESSION['virus']);
            header("Location: pass.html");
            exit();
        }
    }
    else if($row['virus'] == "tuberculosis")
    {
        if ($q1 == 'yes' && $q2 == 'yes' && $q3 == 'no' && $q4 == 'yes' && $q5 == 'yes' && 
        $q6 == 'yes' && $q7 == 'yes' && $q8 == 'yes' && $q9 == 'yes' && $q10 == 'yes') 
        {
            $sql = "INSERT INTO test_results (email, result, virus) VALUES ('$email', 'failed', '$virus')";
            if (mysqli_query($con, $sql)) 
            {
                echo "New record created successfully";
            } 
            else 
            {
                echo "Error: " . $sql . "<br>" . mysqli_error($con);
            }
            mysqli_close($con);
            unset($_SESSION['id']);
            unset($_SESSION['email']);
            unset($_SESSION['virus']);
            header("Location: fail.html");
            exit();
        } 
        else 
        {
            $sql = "INSERT INTO test_results (email, result, virus) VALUES ('$email', 'passed', '$virus')";
            if (mysqli_query($con, $sql)) 
            {
                echo "New record created successfully";
            } 
            else 
            {
                echo "Error: " . $sql . "<br>" . mysqli_error($con);
            }
            mysqli_close($con);
            unset($_SESSION['id']);
            unset($_SESSION['email']);
            unset($_SESSION['virus']);
            header("Location: pass.html");
            exit();
        }
    }
    else if($row['virus'] == "mpox")
    {
        if ($q1 == 'yes' && $q2 == 'yes' && $q3 == 'yes' && $q4 == 'no' && $q5 == 'yes' && 
        $q6 == 'yes' && $q7 == 'yes' && $q8 == 'yes' && $q9 == 'yes' && $q10 == 'yes') 
        {
            $sql = "INSERT INTO test_results (email, result, virus) VALUES ('$email', 'failed', '$virus')";
            if (mysqli_query($con, $sql)) 
            {
                echo "New record created successfully";
            } 
            else 
            {
                echo "Error: " . $sql . "<br>" . mysqli_error($con);
            }
            mysqli_close($con);
            unset($_SESSION['id']);
            unset($_SESSION['email']);
            unset($_SESSION['virus']);
            header("Location: fail.html");
            exit();
        } 
        else 
        {
            $sql = "INSERT INTO test_results (email, result, virus) VALUES ('$email', 'passed', '$virus')";
            if (mysqli_query($con, $sql)) 
            {
                echo "New record created successfully";
            } 
            else 
            {
                echo "Error: " . $sql . "<br>" . mysqli_error($con);
            }
            mysqli_close($con);
            unset($_SESSION['id']);
            unset($_SESSION['email']);
            unset($_SESSION['virus']);
            header("Location: pass.html");
            exit();
        }
    }
    
}


?>