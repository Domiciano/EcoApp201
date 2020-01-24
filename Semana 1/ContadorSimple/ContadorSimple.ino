int contador = 0;

void setup() {
  Serial.begin(9600);
  pinMode(2,OUTPUT);
  pinMode(3,OUTPUT);
  pinMode(4,OUTPUT);
  pinMode(7,INPUT);
}

void loop() {

  int value = digitalRead(7);
  if(value == HIGH){
    contador++;
  }
  
  digitalWrite(2,HIGH);
  digitalWrite(3,HIGH);
  digitalWrite(4,HIGH);
  Serial.println(contador);
  delay(100);
  

}
