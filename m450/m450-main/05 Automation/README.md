# Load Test

Der Load Test prüft die Belastbarkeit des `/students`-Endpunkts, indem er diesen mehrfach aufruft. 

## Zweck von `@RepeatedTest`

Die JUnit 5-Annotation `@RepeatedTest` wiederholt einen Test eine definierte Anzahl an Malen, z. B. 100-fach, ohne manuelle Schleifen im Code. Dadurch simuliert sie Last auf den Endpunkt und prüft dessen Zuverlässigkeit und Konsistenz unter wiederholtem Zugriff.

### Bewertung:
- **Optimal**: Für schnelle Belastungstests oder das Prüfen einzelner Funktionen bei geringer bis mittlerer Last.
- **Eingeschränkt**: Nicht ideal für gross angelegte Last- oder Stresstests, da es keine parallelen Anfragen ermöglicht und die Wiederholungen sequentiell ablaufen.