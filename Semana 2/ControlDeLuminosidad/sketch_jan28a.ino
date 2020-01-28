int luminosidad =0; 

void setup() {
  Serial.begin(9600);
  pinMode(3, OUTPUT);
  pinMode(A0, INPUT);
}

void loop() {
  luminosidad ++;
  if(luminosidad >= 256){
   luminosidad = 0;
    }
  analogWrite(3, luminosidad);
  delay(10);
}
