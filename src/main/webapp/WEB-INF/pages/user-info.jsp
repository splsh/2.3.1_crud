<!DOCTYPE html>
<html>
<head>
    <title>HTML Form Example</title>
    <style>
        label {
            display: inline-block;
            width: 150px;
            text-align: right;
        }
        input[type="text"] {
            width: 200px;
        }
    </style>
</head>
<body>
<h2> User info</h2>

<form action="saveUser" method="get">
    <label for="firstName">Name:</label><input type="text" name="firstName" id="firstName" /><br>
    <label for="lastName">Surname:</label><input type="text" name="lastName" id="lastName" /><br>
    <label for="active">Status:</label><input type="text" name="active" id="active" /><br>
    <label for="daysRemained">Remained days:</label><input type="text" name="daysRemained" id="daysRemained" /><br>
    <input type="submit" value="Save" />
</form>

</body>
</html>