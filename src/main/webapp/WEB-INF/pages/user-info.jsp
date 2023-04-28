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
    <input type="hidden" name="id" th:value="${user.id}"/>
    <label for="firstName">Name:</label><input type="text" name="firstName" id="firstName" th:value="${user.firstName}"/><br>
    <label for="lastName">Surname:</label><input type="text" name="lastName" id="lastName" th:value="${user.lastName}"/><br>
    <label for="active">Status:</label><input type="text" name="active" id="active" th:value="${user.isActive}"/><br>
    <label for="daysRemained">Remained days:</label><input type="text" name="daysRemained" id="daysRemained" th:value="${user.daysRemained}"/><br>
    <input type="submit" value="Ok"/>
</form>

</body>
</html>