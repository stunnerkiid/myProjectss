var xS = 30;
var yS = 250;

var white = color(255, 255, 255);
var lightBlue = color(155, 210, 250);
var marune = color(150, 75, 75);

background (white);

var smiley = function(xS, yS){  

    fill(224, 215, 49);
    ellipse (xS, yS, 50, 50);
    fill(0, 0, 0);
    ellipse (xS -10, yS - 10, 10, 10);
    ellipse (xS + 10, yS - 10, 10, 10);
    fill(224, 215, 49);
    ellipse (xS, yS, 50, 50);
    fill(0, 0, 0);
    ellipse (xS - 10, yS - 10, 10, 10);
    ellipse (xS + 10, yS - 10, 10, 10);
    noFill();
    strokeWeight(4);
    arc (xS, yS + 5, 25, 25, 1, 180);
};

var number = random(1,4);
var integer = round(number);

var lengthOfRect = 360; var lor = lengthOfRect;
var x = 10; var xA = x + 20; var rXa = x + 10; var rXb = x + lengthOfRect;

var rectSpacing = 40; var rS = rectSpacing;

var y = 20; var yA = y + 60; var yB = yA + rS; var yC = yB + rS; var yD = yC + rS; var yE = yD + rS;

var rYa = yA - 20; var rYb = rYa + rS; var rYc = rYb + rS; var rYd = rYc + rS; var rYe = rYd + rS;

var rectHeight = 30; var rH = rectHeight;

fill(0, 0, 0);
textSize(15);
text("Which scientist is correctly matched to the experiment for",x ,y);
text("which they are known ?",x ,y + 20);

var textA = "A) Robert Millikan         Cathode ray tube with magnets";
var textB = "B) Ernest Rutherford                     Gold foil experiment";
var textC = "C) J. J. Thomson                     Alpha rays with paraffin";
var textD = "D) Sir James Chadwick                     Cathode ray tube";
var textE = "E) Michael Faraday                   Oil droplets with xRays";

var tA = "Try again";

text (textA, xA, yA);
text (textB, xA, yB);
text (textC, xA, yC);
text (textD, xA, yD);
text (textE, xA, yE);

noFill();
    var rectA = function() {
    rect(rXa, rYa, rXb, rH);
    };

    var rectB = function() {
    rect(rXa, rYb, rXb, rH);
    };
    
    var rectC = function() {
    rect(rXa, rYc, rXb, rH);
    };
    // D = 2
    var rectD = function() {
    rect(rXa, rYd, rXb, rH);
    };
    
    var rectE = function() {
    rect(rXa, rYe, rXb, rH);
    };

        noFill();
        strokeWeight(1);
        rectA();
        rectB();
        rectC();
        rectD();
        rectE();
    
var draw = function() {
    // B is correct
    if (mouseIsPressed && mouseX > rXa && mouseX < rXb && mouseY > rYb && mouseY < rYb + rH) {
        fill(11, 117, 11); text("Correct!", 65, 305);
        fill(lightBlue); strokeWeight(1); rectB();
        smiley(30, 300);
        text (textB, xA, yB);
        }
        
   //A
   if (mouseIsPressed  && mouseX > rXa && mouseX < rXb && mouseY > rYa && mouseY < rYa + rH) {
        text(tA, 20, 275);
        fill(lightBlue); strokeWeight(1); rectA();
        fill(0, 0, 0); text(textA, xA, yA);
        }
    
    // B is correct
    //if (mouseIsPressed && mouseX > rXa && mouseX < rXb && mouseY > rYb && mouseY < rYb + rH) {
        //fill(11, 117, 11); text("Correct!", 65, 305);
        //fill(lightBlue); strokeWeight(1); rectB();
        //smiley(30, 300);
        //text (textB, xA, yB);
        //}
    
   //C
   if (mouseIsPressed  && mouseX > rXa && mouseX < rXb && mouseY > rYc && mouseY < rYc + rH) {
        text("Try again", 20, 275);
        fill(lightBlue); strokeWeight(1); rectC();
        fill(0, 0, 0);
        text (textC, xA, yC);
        }
   //D
   if (mouseIsPressed  && mouseX > rXa && mouseX < rXb && mouseY > rYd && mouseY < rYd + rH) {
        text("Try again", 20, 275);
        fill(lightBlue); strokeWeight(1); rectD();
        fill(0, 0, 0);
        text (textD, xA, yD);
        }
   
   //E
   if (mouseIsPressed  && mouseX > rXa && mouseX < rXb && mouseY > rYe && mouseY < rYe + rH) {
        text("Try again", 20, 275);
        fill(lightBlue); strokeWeight(1); rectE();
        fill(0, 0, 0);
        text (textE, xA, yE);
        }
    
};