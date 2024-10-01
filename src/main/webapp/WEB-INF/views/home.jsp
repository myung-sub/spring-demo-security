<h1>Home Page</h1>

<form action="/auth/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit">Logout</button>
</form>

<hr>

<form action="/samples" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="text" id="sample" name="sample" placeholder="Enter message">
    <button type="submit" name="submit">Send</button>
</form>