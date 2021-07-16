## **Moziüzemeltető program**

#### **`Java verzió: 11`**
#### **`Tomcat verzió: 9.0.33`**
#### **`IntelliJ IDEA Ultimate 2020`**

Operációs rendszer: Windows 10 de teszteltem Ubunt 18-on is.


### **Telepítés:**

A projekt megnyitása után a mozi-core modulban az src > main > resources mappában a db.properties fájlban
az adatbázis elérési útvonalát át kell irni egy tetszöleges mappa abszolút elérési utvonalára
ahova létre fogja hozni a program a db fájlt.

A Maven fülön a root modulba (mozi) kell nyomni egy clean-t majd az install-al telepíteni kell.

A mozi-fx első futtatásakor léterjön az adatbázis és a szükséges adattáblák így először mindenképp a javaFX alkalmazást kell futtatni.

### **A tomcat beállításai a run/debug configurationsnél:**
**a Deployment fülön az Application context üresre volt állítva.**

Azért kellett üresre állítanom mert a ${ pageContext.request.contextPath } nálam nem jól értékelődött ki.

HTTP port: 9002 (az alapértelmezett 8080 nálam már foglalt volt.)

URL: http://localhost:9002/

## Funkciók:

1. mozi-core modul:
- Adatok tárolása
- Sql injection védelem
- Adatbázis lekérdezések (DAO osztályokban interfészekkel)
- Bean osztályok

2. mozi-fx
- Filmek: listázás, hozzáadás, törlés, szerksztés
- Termek: listázás, hozzáadás, törlés
- Vetítések: listázás, hozzáadás, törlés, szerksztés
- foglalások: listázás, törlés, keresés név, terem és film alapján.
- css stíluslapot használ
- base64 es kódolással képfeltöltés

3. mozi-web
- Vetített filmek listázása
- film keresése filmcím részlet alapján
- Film azatai és a hozzá tartozó vetítések listázása
- terem székeinek és azok állapotának kirajzolása
- foglalás az adott széket jelképezö nyezetre való kattintással
- foglalás helyének módosítása
- foglalás törlése (csak akkor lehetséges ha a vetítésig több mint 24 óra van)
- session használata

Megjegyzés: nincs ahgyományos értelembe vett bejelentkezés egy személyt
és annak foglaláait a foglalásokr megadott név azonosítókód párossal azonosít így a jegy késöbbi
megváltoztatásához vagy törléshez be kell lépni a vetítésre ugyanazzal a névvel és azonosítóval.
