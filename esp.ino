#include <ESP8266WiFi.h>

const char* ssid = "wifi";
const char* password = "bish1234";
 
int forward =  16;
int backward = 5;
int left =  4;
int right = 0;
int none = 2;

WiFiServer server(80);
 
void setup() {
  Serial.begin(9600);
  delay(10);
 
  pinMode(forward, OUTPUT);
  digitalWrite(forward, LOW);

  pinMode(backward, OUTPUT);
  digitalWrite(backward, LOW);

  pinMode(left, OUTPUT);
  digitalWrite(left, LOW);

  pinMode(right, OUTPUT);
  digitalWrite(right, LOW);

  pinMode(right, OUTPUT);
  digitalWrite(right, LOW);
 
  // Connect to WiFi network
  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);
 
  WiFi.begin(ssid, password);
 
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected");
 
  // Start the server
  server.begin();
  Serial.println("Server started");
 
  // Print the IP address
  Serial.print("Use this URL to connect: ");
  Serial.print("http://");
  Serial.print(WiFi.localIP());
  Serial.println("/");
 
}
 
void loop() {
  // Check if a client has connected
  WiFiClient client = server.available();
  if (!client) {
    return;
  }
 
  // Wait until the client sends some data
  Serial.println("new client");
  while(!client.available()){
    delay(1);
  }
 
  // Read the first line of the request
  String request = client.readStringUntil('\r');
  Serial.println(request);
  client.flush();
 
  // Match the request
 
  
  if (request.indexOf("/FORWARD") != -1)  {
    digitalWrite(forward, HIGH);
    digitalWrite(backward, LOW);
    digitalWrite(left, LOW);
    digitalWrite(right, LOW);
    digitalWrite(none, LOW);
    Serial.println("forward");
  }
  if (request.indexOf("/BACKWARD") != -1)  {
    digitalWrite(forward, LOW);
    digitalWrite(backward, HIGH);
    digitalWrite(left, LOW);
    digitalWrite(right, LOW);
    digitalWrite(none, LOW);
  Serial.println("backward");
  }
  if (request.indexOf("/LEFT") != -1)  {
    digitalWrite(forward, LOW);
    digitalWrite(backward, LOW);
    digitalWrite(left, HIGH);
    digitalWrite(right, LOW);
    digitalWrite(none, LOW);
    Serial.println("left");
  }
  if (request.indexOf("/RIGHT") != -1)  {
    digitalWrite(forward, LOW);
    digitalWrite(backward, LOW);
    digitalWrite(left, LOW);
    digitalWrite(right, HIGH);
    digitalWrite(none, LOW);
    Serial.println("right");
  }

  if (request.indexOf("/STOP") != -1)  {
    digitalWrite(forward, LOW);
    digitalWrite(backward, LOW);
    digitalWrite(left, LOW);
    digitalWrite(right, LOW);
    digitalWrite(none, HIGH);
    Serial.println("right");
  }

  client.println("HTTP/1.1 200 OK");
  client.println("Content-Type: text/html");
  client.println(""); //  do not forget this one
  client.println("<!DOCTYPE HTML>");
  client.println("<html>");
 
  client.print("Led is now: ");
 
  if(digitalRead(forward) == HIGH) {
    client.print("foward");
  }

  if(digitalRead(backward) == HIGH) {
    client.print("backward");
  }
  
  if(digitalRead(left) == HIGH) {
    client.print("left");
  }

  if(digitalRead(right) == HIGH) {
    client.print("right");
  }

  if(digitalRead(none) == HIGH) {
    client.print("none");
  }
  
  client.println("<br><br>");
  client.println("<a href=\"/FORWARD\"\"><button>FORWARD </button></a>");
  client.println("<a href=\"/BACKWARD\"\"><button>BACKWARD </button></a><br />");  
  client.println("<a href=\"/LEFT\"\"><button>LEFT </button></a><br />");
  client.println("<a href=\"/RIGHT\"\"><button>RIGHT </button></a><br />");   
  client.println("<a href=\"/STOP\"\"><button>STOP </button></a><br />");   
  client.println("</html>");
 
  delay(1);
  Serial.println("Client disonnected");
  Serial.println("");
 
}
