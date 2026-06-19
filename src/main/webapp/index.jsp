<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculatrice</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>

<h2>Calculatrice Numérique</h2>

<form action="calculatorServelet" method="post">
    <input type="text" name="nbr1" placeholder="Nombre 1" required>
    <select name="operation">
        <option value="addition">+ Addition</option>
        <option value="soustraction">− Soustraction</option>
        <option value="multiplication">× Multiplication</option>
        <option value="division">÷ Division</option>
        <option value="puissance">^ Puissance</option>
        <option value="racine">√ Racine carrée</option>
        <option value="factorielle">! Factorielle</option>
    </select>
    <input type="text" name="nbr2" placeholder="Nombre 2">
    <button type="submit">Calculer</button>
</form>

<%
    String error = (String) request.getAttribute("error");
    Object res   = request.getAttribute("resultat");
    if (error != null) {
%>
    <p style="color:red;"><%= error %></p>
<% } else if (res != null) { %>
    <p>Résultat : <strong><%= res %></strong></p>
<% } %>

</body>
</html>