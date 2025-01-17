# Übung 1

## Formen von Tests

* **Unit-Tests**  
  Testen einzelne Funktionen oder Methoden, um sicherzustellen, dass jede Komponente isoliert korrekt funktioniert.

* **Integrationstests**  
  Überprüfen das Zusammenspiel verschiedener Module, um zu garantieren, dass sie zusammen wie erwartet funktionieren.

* **Systemtests**  
  Testen das gesamte System in einer realistischen Umgebung, um sicherzustellen, dass es die funktionalen und nicht-funktionalen Anforderungen erfüllt.


## SW Fehler & Mangeln

* **SW-Fehler:**  
  Ein Fehler in der Software, der zu unerwartetem Verhalten führt. Beispiel: Eine Banking-App rechnet Zinsen falsch, was zu falschen Kontoständen führt.

* **SW-Mangel:**  
  Ein Mangel liegt vor, wenn die Software nicht den Anforderungen oder Erwartungen entspricht. Beispiel: Eine App ist nicht benutzerfreundlich und erfordert viele unnötige Schritte, um eine einfache Aufgabe zu erledigen.

* **Beispiel für hohen Schaden bei einem SW-Fehler:**  
  Ein Softwarefehler in der Steuerung eines Flugzeugsystems führt zu einem Absturz, was sowohl Menschenleben als auch erhebliche finanzielle Schäden verursachen kann.

## Testing & Bug fixing
Siehe [PriceCalculator](./PriceCalculator.java). Der Fehler beim code stück war das ein If check nie ausgeführt werden kann. Es handelt sich um diesen:
```
if (extras >= 3)
  addon_discount = 10;
else if (extras >= 5)
  addon_discount = 15;
```

Man muss nur den If-Checks umdrehen und der Bug ist behoben.