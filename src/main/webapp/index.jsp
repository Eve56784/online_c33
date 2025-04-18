<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="w-50 mx-auto">
        <h1 class="mb-4 text-center">SuperUser Control Panel</h1>

        <div class="card mb-4">
            <div class="card-header">
                Create a User
            </div>
            <div class="card-body">
                <form action="http://localhost:8080/postgresql_war/create" method="post">
                    <div class="mb-3">
                        <label for="loginCreate" class="form-label">Login</label>
                        <input type="text" class="form-control" id="loginCreate" name="login" required>
                    </div>
                    <div class="mb-3">
                        <label for="usernameCreate" class="form-label">Username</label>
                        <input type="text" class="form-control" id="usernameCreate" name="username" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Create User</button>
                </form>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">
                Change User Login
            </div>
            <div class="card-body">
                <form action="http://localhost:8080/postgresql_war/change-login" method="post">
                    <div class="mb-3">
                        <label for="idChange" class="form-label">User ID</label>
                        <input type="text" class="form-control" id="idChange" name="id" required>
                    </div>
                    <div class="mb-3">
                        <label for="newLogin" class="form-label">New Login</label>
                        <input type="text" class="form-control" id="newLogin" name="login" required>
                    </div>
                    <button type="submit" class="btn btn-warning">Change Login</button>
                </form>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">
                Delete a User
            </div>
            <div class="card-body">
                <form action="http://localhost:8080/postgresql_war/delete" method="get">
                    <div class="mb-3">
                        <label for="idDelete" class="form-label">User ID</label>
                        <input type="text" class="form-control" id="idDelete" name="id" required>
                    </div>
                    <button type="submit" class="btn btn-danger">Delete User</button>
                </form>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">
                Get User by ID
            </div>
            <div class="card-body">
                <form action="http://localhost:8080/postgresql_war/get" method="get">
                    <div class="mb-3">
                        <label for="idGet" class="form-label">User ID</label>
                        <input type="text" class="form-control" id="idGet" name="id" required>
                    </div>
                    <button type="submit" class="btn btn-info">Get User</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
