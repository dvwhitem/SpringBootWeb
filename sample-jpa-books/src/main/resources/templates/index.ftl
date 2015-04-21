<!DOCTYPE html>

<html lang="en">

<body>
<table>
    <thead>
    <tr>
        <td>Title</td>
        <td>Authors</td>
    </tr>
    </thead>
    <tbody>
    <#list books as book>
    <tr>
        <td>${book.title}</td>
        <td>
            <#list book.authors as author>
                <div>${author.name}</div>
            </#list>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>