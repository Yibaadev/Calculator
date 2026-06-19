<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculatrice</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>

<div class="container">

    <div class="logo">🧮</div>
    <h1>Calculatrice</h1>
    <p class="subtitle">Effectuez vos calculs rapidement</p>

    <form action="calculatorServelet" method="post">

        <div class="form-group">
            <label for="nbr1">Nombre 1</label>
            <input type="number" id="nbr1" name="nbr1" placeholder="Entrez le nombre 1" required>
        </div>

        <div class="form-group">
            <label for="operation">Opération</label>
            <select id="operation" name="operation">
                <option value="addition">+ Addition</option>
                <option value="substraction">− Soustraction</option>
                <option value="multiplication">× Multiplication</option>
                <option value="division">÷ Division</option>
                <option value="power">^ Puissance</option>
                <option value="squaReoot">√ Racine carrée</option>
                <option value="factorial">! Factorielle</option>
            </select>
        </div>

        <div class="form-group">
            <label for="nbr2">
                Nombre 2
                <span class="nb2-badge" id="badge">Requis selon l'opération</span>
            </label>
            <input type="number" id="nbr2" name="nbr2" placeholder="Entrez le nombre 2">
        </div>

        <button type="submit" class="btn-calculer">Calculer</button>

    </form>

    <%
        String resultat = (String) request.getAttribute("resultat");
        if (resultat != null) {
            boolean isError = resultat.startsWith("Erreur");
    %>
        <hr class="divider">
        <div class="resultat <%= isError ? "erreur" : "succes" %>">
            <%= isError ? "⚠️ " : "✅ " %><%= resultat %>
        </div>
    <% } %>

</div>

</body>
</html>