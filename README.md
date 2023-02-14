# Ducklings
Spring boot jdbc sql

Syftet med inlämningsuppgiften är att visa att du har förmågan att implementera CRUD operationerna via en spring boot backend. Observera att du förväntas använda databaslösningar i uppgiften.

Avgränsningar: Vidare så förväntas du använda JDBC, övriga API lösningar som JPA/Hibernate tillåts ej.
Uppdragsbeskrivning
Budget Ducklings inc. vill skapa ett gränssnitt för sina medarbetare där de kan registrera kvitton för betalningar som hanteras av företaget. Dessa betalningar kan vara resor till och från jobbet, lunchmöten, övertidsarbete och övrigt. Alla medarbetare tilldelas ett konto av företaget som används vid inloggning till gränssnittet.
Uppgiftskrav
Gränssnittet måste bestå av följande fyra sidor.

Home page -  används för att logga in som medarbetare
Invoice page - visar samtliga betalningar som har registrerats av medarbetaren
Payment page - Används för att registrera nya betalningar
Edit page - Används för att ändra på betalningar och/eller för att ta bort en betalning.


Varje betalning motsvara fem följande egenskaper där samtliga egenskaper kan skapas och ändras av medarbetaren.


Titel - Namn på betalningen.
Datum - När betalningen utfördes.
Beskrivning - Kort beskrivning av betalningen.
Kategori - motsvarar kategorierna som beskrivs under uppdragsbeskrivningen.
Pris - Motsvarar priset på betalningen.
