<html>
    <head>
        <style>

            .weekend{color: #FE0000;} .currentDay {color: #00FE00;} td{ width: 30px;}

        </style>
    </head>
    <body>
        <a href="/"><input type="submit" value="To dashboard"></a>

<form action="/calendar">
    Select month:
    <select name="Month">
        <option value="January">January</option>
        <option value="February">February</option>
        <option value="March">March</option>
        <option value="April">April</option>
        <option value="May">May</option>
        <option value="June">June</option>
        <option value="July">July</option>
        <option value="August">August</option>
        <option value="September">September</option>
        <option value="October">October</option>
        <option value="November">November</option>
        <option value="December">December</option>
    </select> <br><br>
    Select year
        <select name="Year">
            <option value="2014">2014</option>
            <option value="2015">2015</option>
            <option value="2016">2016</option>
            <option value="2017">2017</option>
            <option value="2018">2018</option>
        </select> <br><br>

    Select first day of week:
    <select name="FirstDayOfWeek">
        <option value="Sunday">Sunday</option>
        <option value="Monday">Monday</option>
        <option value="Tuesday">Tuesday</option>
        <option value="Wednesday">Wednesday</option>
        <option value="Thursday">Thursday</option>
        <option value="Friday">Friday</option>
        <option value="Saturday">Saturday</option>
    </select> <br>
    <input type="submit" class="button" value="generate">

</form>

      ${calendar}
    </body>
</html>