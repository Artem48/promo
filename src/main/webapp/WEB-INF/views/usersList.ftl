<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
    <h1>Users List</h1>
    <table>
        <head>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>email</th>
                <th>age</th>
            </tr>
        </head>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
        </tr>
    </#list>
    </table>
</body>
</html>