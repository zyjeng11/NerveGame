
<%@ page contentType="text/html" pageEncoding="utf-8"
         import="java.util.*,bean.*,java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Question</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <link rel="stylesheet" href="./nervegame.css">
    </head>
    <body>
        <p>${question.question}</p>

        <div id="myDIV">
            <span class="anser-zone" data-ans=""></span>
            <span class="anser-zone" data-ans=""></span>
            <span class="anser-zone" data-ans=""></span>
            <span class="anser-zone" data-ans=""></span>
            <span class="anser-zone" data-ans=""></span>
            <span class="anser-zone" data-ans=""></span>
            <span class="anser-zone" data-ans=""></span>
        </div> 

        <div id="buttons">
            <span data-cho="A">皮膚</span>
            <span data-cho="B">鼻子</span>
            <span data-cho="C">眼睛</span>
            <span data-cho="D">耳朵</span>
            <span data-cho="E">感覺神經元</span> 
            <span data-cho="F">脊髓</span>
            <span data-cho="G">大腦</span>
            <span data-cho="H">運動神經元</span>
            <span data-cho="I">肌肉</span>
            <span data-cho="J">唾腺</span>
            <span data-cho="K">腦幹</span>
            <span data-cho=""></span> 
        </div>

        <div id="rightAns">答對了</div>
        <div id="wrongAns">答錯了，再試試看</div>
        <button id="bt">對答案</button>
        
        <a href="question?row=${next}" id="next">下一題</a>   

        <script>
            $("#next").hide();
            $("#rightAns").hide();
            $("#wrongAns").hide();
            var answer = ["${question.answer1}", "${question.answer2}", "${question.answer3}", "${question.answer4}", 
            "${question.answer5}", "${question.answer6}", "${question.answer7}"];

//選取答案框
            $("#myDIV span").click(function () {
                $("#myDIV span").removeClass("selected");
                $(this).addClass("selected");
            });

            $("#buttons span").click(function () {
                var but = $(this).html();
                var da = $(this).attr("data-cho");
                $(".selected").html(but).attr("data-ans", da);
                $(".selected").removeClass("selected");
            });

//對答案
            $("#bt").click(function () {
                var myAns = [];
                for (var i = 0; i < 7; i++) {
                    myAns[i] = $(".anser-zone").eq(i).attr("data-ans");
                }
                var result = check(myAns);
                if (result == true) {
                    $("#wrongAns").hide();
                    $("#rightAns").show();
                    $("#next").show();
                    $("#bt").hide();
                } else {
                    $("#rightAns").hide();
                    $("#wrongAns").show();
                }
            });

//把答案內容轉成array
            function disp(divs) {
                var a = [];
                for (var i = 0; i < divs.length; i++) {
                    a.push(divs[i].innerHTML);
                }
                return a;
            }
            //答案判斷
            function check(myAns) {
                var isCorrect = true;
                for (var i = 0; i < myAns.length; i++) {
                    if (myAns[i] !== answer[i]) {
                        isCorrect = false;
                        break;
                    }
                }
                return isCorrect;
            }

        </script>

    </body>
</html>
