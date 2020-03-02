
  #include <AFMotor.h>
  
  int URECHO = 21;         // PWM Output 0-25000US,Every 50US represent 1cm
  int URTRIG = 20; // PWM trigger pin
  
  int forward = 31;
  int backward = 33;
  int left = 35;
  int right = 37;
  int none = 39;
  
  
     // variable to store the value coming from the sensor

  AF_DCMotor motor1(1);
  AF_DCMotor motor2(2);
  void setup()
  {
    //Serial initialization
    Serial.begin(9600);                        // Sets the baud rate to 9600
    pinMode(URTRIG,OUTPUT);                    // A low pull on pin COMP/TRIG
    digitalWrite(URTRIG,HIGH);                 // Set to HIGH
    pinMode(URECHO, INPUT);  // Sending Enable PWM mode command
  
    pinMode(forward, INPUT);
    pinMode(backward, INPUT);
    pinMode(left, INPUT);
    pinMode(right, INPUT);
    delay(500);
    Serial.println("Sensor On");
  
    motor1.setSpeed(255);
    motor2.setSpeed(255);

    motor1.run(FORWARD);
     motor2.run(FORWARD);
    
   }
  void loop()
  {
  
   
    if(digitalRead(forward) == HIGH) {

      digitalWrite(backward, LOW);
      digitalWrite(left, LOW);
      digitalWrite(right, LOW);
      motor1.run(FORWARD);
      motor2.run(FORWARD);
      Serial.print("foward");
    }
  
    else if(digitalRead(backward) == HIGH) {

      digitalWrite(forward, LOW);
      digitalWrite(left, LOW);
      digitalWrite(right, LOW);
      motor1.run(BACKWARD);
      motor2.run(BACKWARD);
      Serial.print("backward");
    }
    
    else if(digitalRead(left) == HIGH) {

      digitalWrite(backward, LOW);
      digitalWrite(forward, LOW);
      digitalWrite(right, LOW);
      motor1.run(FORWARD);
      motor2.run(BACKWARD);
      Serial.print("left");
    }
  
    else if(digitalRead(right) == HIGH) {
      motor1.run(BACKWARD);
      motor2.run(FORWARD);
      Serial.print("right");
    }
  
    else if(digitalRead(none) == HIGH) {

      digitalWrite(forward, LOW);
      digitalWrite(backward, LOW);
      digitalWrite(left, LOW);
      motor1.run(RELEASE);
      motor2.run(RELEASE);
      Serial.print("none");
    }
  }
  
