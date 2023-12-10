<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10.12.2023
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible"
          content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <title>
        Statistics
    </title>
    <style>
        /* Styling the Body element i.e. Color,
        Font, Alignment */
        body {
            background-color: #05c46b;
            font-family: Verdana;
            text-align: center;
        }
        /* Styling the Form (Color, Padding, Shadow) */
        form {
            background-color: #fff;
            max-width: 500px;
            margin: 50px auto;
            padding: 30px 20px;
            box-shadow: 2px 5px 10px rgba(0, 0, 0, 0.5);
        }
        /* Styling form-control Class */
        .form-control {
            text-align: left;
            margin-bottom: 25px;
        }
        /* Styling form-control Label */
        .form-control label {
            display: block;
            margin-bottom: 10px;
        }
        /* Styling form-control input,
        select, textarea */
        .form-control input,
        .form-control select,
        .form-control textarea {
            border: 1px solid #777;
            border-radius: 2px;
            font-family: inherit;
            padding: 10px;
            display: block;
            width: 95%;
        }
        /* Styling form-control Radio
        button and Checkbox */
        .form-control input[type="radio"],
        .form-control input[type="checkbox"] {
            display: inline-block;
            width: auto;
        }
        /* Styling Button */
        button {
            background-color: #05c46b;
            border: 1px solid #777;
            border-radius: 2px;
            font-family: inherit;
            font-size: 21px;
            display: block;
            width: 100%;
            margin-top: 50px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<h1>Please fill current Form</h1>
<!-- Create Form -->
<form action="stat" method="post">
    <!-- Details -->
    <div class="form-control">
        <label for="name" id="label-name">
            Name
        </label>
        <!-- Input Type Text -->
        <input type="text"
               id="name" name="name"
               placeholder="Enter your name" />
    </div>
    <div class="form-control">
        <label for="email" id="label-email" >
            Email
        </label>
        <!-- Input Type Email-->
        <input type="email"
               id="email"
               placeholder="Enter your email" name="email"/>
    </div>
    <div class="form-control">
        <label for="age" id="label-age">
            Age
        </label>
        <!-- Input Type Text -->
        <input type="text"
               id="age"
               placeholder="Enter your age" name="age"/>
    </div>
    <div class="form-control">
        <label for="role" id="label-role">
            Which option best describes you?
        </label>
        <!-- Dropdown options -->
        <select name="role" id="role">
            <option value="student">Student</option>
            <option value="intern">Intern</option>
            <option value="professional">
                Professional
            </option>
            <option value="other">Other</option>
        </select>
    </div>
    <div class="form-control">
        <label>
            Would you recommend ItStep
            to a friend?
        </label>
        <!-- Input Type Radio Button -->
        <label for="recommend-1">
            <input type="radio"
                   id="recommend-1"
                   name="recommend-1">Yes</input>
        </label>
        <label for="recommend-2">
            <input type="radio"
                   id="recommend-2"
                   name="recommend-2">No</input>
        </label>
        <label for="recommend-3">
            <input type="radio"
                   id="recommend-3"
                   name="recommend-3">Maybe</input>
        </label>
    </div>
    <div class="form-control">
        <label>Languages and Frameworks known
            <small>(Check all that apply)</small>
        </label>
        <!-- Input Type Checkbox -->
        <label id="inp-1">
            <input type="checkbox"
                   name="inpC">C </label>
        <label id="inp-2">
            <input type="checkbox"
                   name="inpC++">C++</label>
        <label id="inp-3">
            <input type="checkbox"
                   name="inpC#">C#</label>
        <label id="inp-4">
            <input type="checkbox"
                   name="inpJava">Java</label>
        <label id="inp-5">
            <input type="checkbox"
                   name="inpPython">Python</label>
        <label id="inp-6">
            <input type="checkbox"
                   name="inpJavaScript">JavaScript</label>
        <label id="inp-7">
            <input type="checkbox"
                   name="inpReact">React</label>
        <label id="inp-8">
            <input type="checkbox"
                   name="inpAngular">Angular</label>
        <label id="inp-9">
            <input type="checkbox"
                   name="inpDjango">Django</label>
        <label id="inp-10">
            <input type="checkbox"
                   name="inpSpring">Spring</label>
    </div>
    <div class="form-control">
        <label for="comment">
            Any comments or suggestions
        </label>
        <!-- multi-line text input control -->
        <textarea name="comment" id="comment"
                  placeholder="Enter your comment here">
</textarea>
    </div>
    <!-- Multi-line Text Input Control -->
    <button type="submit" value="submit">
        Submit
    </button>
</form>
</body>
</html>
