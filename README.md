# Job_hub_demo

A cél egy álláskereső alkalmazás létrehozása.
A feladatot Java 11 (előzetes informáci >8 volt) nyelven, Spring framework segítségével valósítsa meg. Az adatbázishoz
célszerű inmemory adatbázist használni vagy file alapú megoldást, melynek tartalmaznia kell már meglévő adatokat is!
Inmemory database esetén kezdeti adatfeltöltést is tartalmazzon a megoldás.
Követelmények:

1. Az alkalmazás biztosítson lehetőséget kliensalkalmazások regisztrációjára (POST /client). A kliens átadja a nevét (
   validáció: max 100 karakter), e-mail címét (validáció: érvényes email cím formátum, bármilyen regexp használatával,
   valamint egyediség ellenőrzése). A responseban a szerver egy api kulcsot ad vissza UUID formátumban.
   A kliensapp regisztrációjához elég a „szabványosnak“ látszó e-mail cím, semmilyen biztonsági (vagy létezőség)
   vizsgálat nem kell? (bejelentkezés/ e-mail hook/ csak admin/ ...)  
   A kliensapp nevének egyediségét nem kell vizsgálni?
   Még nem dolgoztam API key-jel, így megtanulandó.
2. Az alkalmazás biztosítson lehetőséget állások létrehozására (POST /position). A kliens átadja az állás megnevezését (
   validáció: max 50 karakter), a munkavégzés földrajzi helyét (validáció: max 50 karakter). A szerver első lépésben
   ellenőrzi az api kulcs érvényességét. Nem érvényes api kulcs esetén hibaüzenettel tér vissza. A szerver mentse el az
   állást, majd térjen vissza egy URL-lel a responseban, hogy milyen oldalon érhető el a pozició.
   A megnevezés lehet üres is? (vagy minimális hossz?)
   A location lehet üres is?   
   Hol/ki definiálja/adja át az állás „leírását“ vagy az azt tartalmazó link-et?
   Milyen egyéb adatot kell még tárolni az állásról?
   ID?
   A visszaadott URL egy távoli link vagy egy szintén átadott tartalom (HTML?, JSON?, XML?, PDF? ...) alapján
   létrehozott webpage-re mutat a saját szerveren?
3. Az alkalmazás biztosítson lehetőséget állások keresésére (GET /position/search). A kliens átadja a keresett
   keywordöt (pl.: "finance", validáció: max 50 karakter) valamint a lokációt (pl.: "london", validáció: max 50
   karakter). A szerver első lépésben ellenőrzi az api kulcs érvényességét. Nem érvényes api kulcs esetén hibaüzenettel
   tér vissza.
   Érvényes api kulcs esetén az átadott adatokkal bekérdez az adatbázisban tárolt állások.
   Gondolom az előző mondat egy nyers fordítás :) és ilyesmit jelent: Érvényes api kulcs esetén a tárolt adatok
   Milyen reláció van a keyword-location páros tagjai között (ÉS/VAGY)?
   A keyword és/vagy location lehet üres is?  (Az üres location csak a szintén üres location-t vagy bármelyiket jelenti?
   Találatnak számít a részleges egyezés is pl: ha az állás megnevezése: “Java backend developer” és a keresésben a
   feltétel annyi, hogy “developer” akkor az találat. Ha a keresés sikerrel járt a kliens számára egy URL listával kell
   visszatérni a hírdetésekhez tartozó URL-el.
   Csak szavakat vagy részleges szó keresést várunk el? Pl: developer keresésre a developers is válasz?
   A visszaadott URL egy távoli link vagy a tárolt tartalom a saját szerveren?
4. A keresési eredmények megnyitásához pedig szükséges implementálni egy GET (/position/id) kérést.
   A position nem egyértelmű azonosító, hiszen nem kellett vizsgálni az egyediséget, tehát a kérésben a position listát
   is eredényezhet.
   Az ID-t a tároláskor kell generálni és valahol visszaadott értéknek kellene lennie. (Az URL tartalmazza?)
   Milyen hiba, ha a position és az id nem ugyanazon állásra mutatnak?
   A visszaadott URL egy távoli link vagy egy szintén átadott tartalom (HTML?, JSON?, XML?, PDF? ...) alapján
   létrehozott webpage-re mutat a saját szerveren?
   A szerver validációs hibák esetén egységes hibatípussal térjen vissza, részletezve, hogy milyen mezőkkel milyen
   validációs hiba történt.
   Pl: ValidationException:  { [ { field: “....“, error: “...“} ... ] }
   Az API réteget válassza el az adatelérési rétegtől.
   Célszerűnek tartom az üzleti logikától elválasztani a commonucation/UI réteget is (hexagonal architecture) nem csak a
   perzisztálót.
   Az alkalmazáshoz swagger-ui használata nem kötelező, de ajánlott.
   Korábbi kérdésemben ez ilyen tool/library-król szerettem volna információt kapni. Nem dolgoztam még swagger-rel,
   tehát meg kell tanulnom.
   A fejlesztés után soroljon fel továbbfejlesztési lehetőségeket ezzel a projekttel kapcsolatban, hogy teljes mértékben
   production ready alkalmazás legyen és az üzemeltetés is elfogadja tőlünk ezt az alkalmazást.
   Az üzemeltetés részére nem a konfigurációs/futtatási dokumentáció (következő mondatban) elengedhetetlen és az itt
   vázolt információ pedig a support/sales területeknek?
   Készítsen rövid leírást az alkalmazásról, hogyan és milyen eszközökkel lehet bekonfigurálni és futtatni.
