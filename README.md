# Arduino-RC-Tank
RC Tank I Made for my Grade 11 Engineering Class (I got 100% :D)

Around early november, the teacher for my Computer Engineering class told us to start thinking about our summative project (final project). 
I went up to him and told him I wanted to make a car that would move by itself and adjust itself accordingly based on what was around it
(using ultrasonic sensors). He then told me about a tank kit that a student bought last year but was never able to finish. It was the same
concept, but just a bit harder. I agreed to build it. I came back the next day with it all assembeled and working. He told me that because
I finisehd it so fast, I should add more to it. I spent the next 3 days adding an ESP-8266 to it in order to have it controlled wirelessly
through wifi. After that I was bored so I made an android app with the buttons so that it could be controlled through that. I wish I could
have made it better (for example adding an autonomy button using the ultrasonic sensor) but I got caught up with other classes and personal
life.

Here I have provided 3 peieces of code. The first one was for the ESP-8266 in order to set it up. The second was for the arduino and the third
was for the android app (made with android studio).

The way it works is:

The arduino has a shield to turn the motors of the tank
The arduino depends on input from different pins in order to control the motors
The ESP-8266 outputs to different pins on the arduino depending on what is clicked through the app or on the website
The tank moves
