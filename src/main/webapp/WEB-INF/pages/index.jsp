<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      lang="en">
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid rgba(0, 255, 255, 55);
        }
    </style>
</head>
<body>
<h2>Start page, chose action</h2>
<div>
    <div>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Status</th>
                <th>Days remaining</th>
            </tr>
            </thead>
            <tbody>
            <tr th:each="user, iterStat : ${userList}">
                <td th:text="${user.id}"></td>
                <td th:text="${user.firstName}"></td>
                <td th:text="${user.lastName}"></td>
                <td th:text="${user.isActive}"></td>
                <td th:text="${user.daysRemained}"></td>
            </tr>

            </tbody>
        </table>
    </div>

    <br>
    <input type="button" value="Add user" onclick="window.location.href = 'addUser'">
</div>
</body>
</html>

