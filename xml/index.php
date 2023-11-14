<!DOCTYPE html>
<html>

<head>
    <title>food</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <h1>food</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>quantity</th>
            <th>price</th>
            
        </tr>
        <?php
        $xml = simplexml_load_file('food.xml');


        if ($xml) {
            foreach ($xml->food as $s) {
                echo "<tr>";
                echo "<td>" . $s->name . "</td>";
                echo "<td>" . $s->quantity . "</td>";
                echo "<td>" . $s->price . "</td>";


                echo "</tr>";
            }
        } else {
            echo "<tr><td colspan='3'>Failed to load the XML file.</td></tr>";
        }
        ?>
    </table>
</body>

</html>