void setup() {
  Serial.begin(9600);
  pinMode(2,INPUT);
  pinMode(A0,INPUT);
}

void loop() {
  int analogValue = analogRead(A0);
  int digitalValue = digitalRead(2);
  Serial.println(analogValue);
  Serial.println(digitalValue);
  delay(100);
}
