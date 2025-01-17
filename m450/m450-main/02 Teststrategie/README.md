# Übung 1
Beschreibung einer Verkaufssoftware

### Abstrakte Testfälle

Die abstrakten Testfälle verwenden logische Operatoren, um die verschiedenen Rabattregeln zu testen.

| Testfall-ID | Bedingung (Kaufpreis)    | Erwarteter Rabatt |
|-------------|--------------------------|-------------------|
| AT1         | Kaufpreis < 15'000 CHF    | 0%                |
| AT2         | 15'000 CHF ≤ Kaufpreis < 20'000 CHF | 5%     |
| AT3         | 20'000 CHF ≤ Kaufpreis < 25'000 CHF | 7%     |
| AT4         | Kaufpreis ≥ 25'000 CHF    | 8,5%              |

### Konkrete Testfälle

Hier werden spezifische Werte für die Testfälle verwendet, um die Rabattregeln zu testen.

| Testfall-ID | Kaufpreis (CHF) | Erwarteter Rabatt |
|-------------|-----------------|-------------------|
| KT1         | 14'999           | 0%                |
| KT2         | 15'000           | 5%                |
| KT3         | 19'999           | 5%                |
| KT4         | 20'000           | 7%                |
| KT5         | 24'999           | 7%                |
| KT6         | 25'000           | 8,5%              |
| KT7         | 30'000           | 8,5%              |

Mit diesen Tabellen können Sie die Verkaufssoftware umfassend testen, sowohl in abstrakten als auch in konkreten Szenarien.

# Übung 2
eine Webseite zum Thema Autovermietung

Hier ist eine Tabelle mit den fünf wichtigsten funktionalen Black-Box-Tests für die Autovermietungsplattform Autoscout24.ch. Diese Tests konzentrieren sich auf Kernfunktionen, die für den Betrieb entscheidend sind.

### Markdown Tabelle:

```markdown
| ID  | Beschreibung                                       | Erwartetes Resultat                                                | Effektives Resultat                   | Status   | Mögliche Ursache
|-----|---------------------------------------------------|--------------------------------------------------------------------|---------------------------------------|----------|---------------------------------------------|
| 1   | Benutzer kann sich registrieren                   | Nach Eingabe aller erforderlichen Daten wird der Benutzer registriert und erhält eine Bestätigungs-E-Mail. | Registrierung erfolgreich, E-Mail erhalten | Erfolgreich | -                                             |
| 2   | Fahrzeugsuche nach Standort und Datum             | Nach Eingabe von Standort und Datum werden verfügbare Fahrzeuge angezeigt. | Liste der verfügbaren Fahrzeuge angezeigt | Erfolgreich | -                                             |
| 3   | Buchung eines Fahrzeugs                            | Nach Auswahl eines Fahrzeugs und Eingabe der erforderlichen Daten wird die Buchung bestätigt und eine Bestätigungs-E-Mail gesendet. | Buchung bestätigt, E-Mail erhalten | Erfolgreich | -                                             |
| 4   | Zahlung mit Kreditkarte                           | Nach Eingabe der Kreditkartendaten wird die Zahlung erfolgreich verarbeitet und eine Bestätigungs-E-Mail gesendet. | Zahlung erfolgreich, E-Mail erhalten | Erfolgreich | -                                             |
| 5   | Stornierung einer bestehenden Buchung             | Nach Eingabe der Buchungsnummer kann der Benutzer die Buchung stornieren und erhält eine Bestätigungs-E-Mail. | Stornierung erfolgreich, E-Mail erhalten | Erfolgreich | -                                             |
```

# Übung 3

# Testfälle für die Software `ch.tbz.bank.software`

## 1. Black-Box-Testfälle

| Testfall-ID | Testfallbeschreibung                                                                 | Erwartetes Ergebnis                                     |
|-------------|--------------------------------------------------------------------------------------|--------------------------------------------------------|
| BB-01       | Kontoerstellung mit gültigen Werten (Name: "Rockefeller", Währung: USD, Betrag: 1500) | Konto wird erfolgreich erstellt                         |
| BB-02       | Kontoerstellung mit negativem Betrag (Name: "Doe", Währung: EUR, Betrag: -500)       | Kontoerstellung schlägt fehl                            |
| BB-03       | Kontoerstellung ohne Namen (Name: "", Währung: USD, Betrag: 1000)                    | Kontoerstellung schlägt fehl                            |
| BB-04       | Abrufen der Anzahl der Konten                                                        | Korrekte Anzahl von Konten wird zurückgegeben           |
| BB-05       | Auswahl eines existierenden Kontos zur Bearbeitung                                   | Konto wird erfolgreich ausgewählt                       |
| BB-06       | Auswahl eines nicht existierenden Kontos (z.B. Konto 999)                            | Fehlermeldung wird ausgegeben                           |
| BB-07       | Beenden der Anwendung durch Auswahl der Kontonummer 0                                | Anwendung wird beendet                                  |

## 2. White-Box-Testfälle

| Testfall-ID | Methode                    | Testfallbeschreibung                                                                  | Erwartetes Ergebnis                                     |
|-------------|----------------------------|---------------------------------------------------------------------------------------|--------------------------------------------------------|
| WB-01       | `Bank.createAccount()`      | Testen der Kontoerstellung mit einem positiven Betrag                                 | Konto wird erfolgreich erstellt                         |
| WB-02       | `Bank.createAccount()`      | Testen der Kontoerstellung mit einem negativen Betrag                                 | Kontoerstellung schlägt fehl                            |
| WB-03       | `Bank.getNumberOfAccounts()`| Abrufen der Anzahl der Konten nach mehreren Kontoerstellungen                         | Korrekte Anzahl von Konten wird zurückgegeben           |
| WB-04       | `Counter.chooseAccount()`   | Testen der Auswahl eines Kontos innerhalb des gültigen Bereichs                       | Konto wird erfolgreich ausgewählt                       |
| WB-05       | `Counter.editAccount()`     | Testen der Bearbeitung eines Kontos (z.B. Einzahlung, Auszahlung)                     | Konto wird korrekt bearbeitet                           |
| WB-06       | `Counter.chooseAccount()`   | Testen der Auswahl eines Kontos außerhalb des gültigen Bereichs                       | Fehlermeldung wird ausgegeben                           |

## 3. Verbesserungsvorschläge und Best Practices

- **Code-Kommentare:** Detailliertere Kommentare in komplexen Methoden könnten hilfreich sein.
- **Fehlerbehandlung:** Validierung von Eingaben hinzufügen (z.B. negativer Betrag, leere Namen).
- **Eingabevalidierung:** Methode zur Validierung von Eingaben hinzufügen, um fehlerhafte oder unzulässige Eingaben abzufangen.
- **Modularisierung:** Weiteres Modularisieren von Methoden zur Verbesserung der Wiederverwendbarkeit und Lesbarkeit.
- **Testabdeckung:** Automatisierte Tests (z.B. mit JUnit) schreiben, um die Testabdeckung zu erhöhen.
