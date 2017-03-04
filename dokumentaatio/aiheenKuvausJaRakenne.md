**Aihe:** Muistipeli. Toteutetaan muistipeli, jota voi pelata kaksi pelaajaa samalla päätteellä.
Pelin menusta voi säätää vaikeusastetta (1, 2 tai 3) ja montako pelaajaa (1 tai 2) peliä pelaa. Pelaajan vuorot lasketaan ja oikean parin löydettäessä vuoroaan saa jatkaa. Yksinpelissä on tarkoitus saada mahdollisimman vähillä vuoroilla löydettyä kaikki kuvaparit. Kaksinpelissä voittaja on se, joka löytää eniten pareja.

**Rakennekuvaus:** Ohjelma on jaettu kahteen tärkeään luokkaan: Lauta ja Tietokanta. Lauta vastaa ohjelman logiikasta ja kommunikoi käyttöliittymän kanssa ja Tietokannan. Tietokanta taas vastaa Kortti- ja Pelaajaolioiden luomisesta, tallentamisesta ja muokkaamisesta.

**Käyttäjät:** Pelaaja 1 ja Pelaaja 2.

**Kaikkien käyttäjien toiminnot:**

- Vaikeustason valinta
- Pelaajien määrän valinta
- pelin pelaaminen valitsemalla kaksi ruutua pelikentältä

**Luokkakaavio**

![Muistipelin luokkakaavio](https://github.com/CG89/Muistipeli/blob/master/dokumentaatio/MuistipeliLuokkakaavio.png?raw=true)
![Pelaajamäärän valinta -sekvenssikaavio](https://github.com/CG89/Muistipeli/blob/master/dokumentaatio/PelaajamaaranValintaSekvenssikaavio.png?raw=true)
![Vaikeusasteen valinta -sekvenssikaavio](https://github.com/CG89/Muistipeli/blob/master/dokumentaatio/VaikeusasteenValintaSekvenssikaavio.png?raw=true)
![Kortin kääntäminen -sekvenssikaavio](https://github.com/CG89/Muistipeli/blob/master/dokumentaatio/KortinKaantoSekvenssikaavio.png?raw=true)
