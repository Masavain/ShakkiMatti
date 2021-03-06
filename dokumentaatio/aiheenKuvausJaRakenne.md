# ShakkiMatti

**Aihe:** ShakkiMatti on kahden pelaajan shakkipeli hienolla (tai ei niin hienolla) graafisella käyttöliittymällä.

**Käyttäjät:** Shakki on kahden pelaajan peli, jossa pelaajat vaihtavat vuoroa siirtojen välissä.

**toiminnot:** Pelaaja voi vuorollaan siirtää yhtä nappulaa, tai syödä vastustajan nappulan mahdollisella siirroolla. Siirto tapahtuu valitsemalla ensin hiirellä oman värinen nappula, jonka jälkeen mahdolliset siirrot värjäytyvät keltaisilla reunuksilla. Siirto lukitaan valitsemalla hiirellä ruutu, johon halutaan liikkua. Jos pelaajan nappula siirron jälkeen uhkaa vastapelaajan kuningasta, ilmoittaa peli tällöin vastustajan olevan shakissa.

**luokkakaavio** 


![luokkakaavio](https://github.com/Masavain/ShakkiMatti/blob/master/dokumentaatio/luokkakaavio.jpg)

Shakkilautaa kuvaa luokka Pelilauta, jossa on Nappula-olioista koostuva 8x8 taulukko. Taulukossa arvot null ovat tyhjiä ruutuja. Nappula taas on abstrakti luokka, jolla on alaluokat Sotilas, Kuningas, Kuningatar, Lahetti, Ratsu ja Torni. Näistä kukin kuvaa omanlaista shakkinappulaansa. Jokaisella nappula-oliolla on arvo Pelaaja (Enum) joka edustaa siis Pelaajan (ja myös siis nappulan) väriä. Näiden lisäksi Pelilautaa kontrolloi Päälogiikka-luokka, jossa tapahtuu myös kirjanpito siitä, kumman pelaajan vuoro on, onko pelaajan kuningas shakattuna ja jonka kautta kaikki pelaajien siirrot tehdään.


**sekvenssikaaviot**

![siirto](https://github.com/Masavain/ShakkiMatti/blob/master/dokumentaatio/siirtoSekvenssi.png)

![shakki](https://github.com/Masavain/ShakkiMatti/blob/master/dokumentaatio/shakkiSekvenssi.png)


