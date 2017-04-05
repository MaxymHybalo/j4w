<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Guest Page</title>
    </head>
    <style>
        *{
            font-family: Arial;
        }

        h1 {
            color: cadetblue;
        }

        h2{
            color: cornflowerblue;
        }

        h1,.form-container,table{
            margin-left: 20em;
            margin-top: 0.5em;
        }

        table{
            min-width: 600px;
            border: solid;
        }

        tr {
            padding: 5px;
        }

        thead{
            background-color: aliceblue;

        }

    </style>
    <body>
        <h1>Guest Page</h1>
        <div class="form-container">
        <h2>New Guest</h2>
            <form action="/" method="post">
                <label>Name:</label>
                <input type="text" name="name"/>
                <br>
                <label>Message</label>
                <br>
                <textarea name="message"cols="30" rows="10"></textarea>
                <br>
                <label>Mark:</label>
                <select name="rating">
                    <c:forEach begin="1" end="10" varStatus="loop">
                        <option value="${loop.index}">${loop.index}</option>
                    </c:forEach>
                </select>
                <br>
                <input type="submit" value="Submit"/>
            </form>
        </div>
        <div class="table">
            <table>
                <thead>
                <tr>
                    <td>#</td>
                    <td>Name</td>
                    <td>Message</td>
                    <td>Mark</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${guests}" var="guest">
                    <tr>
                        <td>${guest.id}</td>
                        <td>${guest.name}</td>
                        <td>${guest.message}</td>
                        <td>${guest.rating}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
