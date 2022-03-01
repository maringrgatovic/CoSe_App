# CoSe

Projekt Android aplikacije napravljen za predmet na fakultetu.  
Aplikacija služi za čitanje stripova preko mobitela.  

Nije u potpunosti razrađena za korištenje, već samo za potrebe prolaska predmeta.  


## Početni activity aplikacije:  
Na početnom ekranu vidimo ime aplikacije.  
Imamo gumb (ikona osobe) preko kojeg se korisnik može prijaviti u svoj profil.  
Nakon njih slijede 3 gumba:  
**Recent**  
Preko kojeg korisnik vidi sve stripove koje aplikacija nudi  
  
**Subscribe**  
Preko kojeg se korisniku pokažu svi stripovi kod kojih je on izabrao opciju subscribe  
  
**Search** (nije implementirano)  
Preko kojeg korisnik pretražuje bazu podataka stripova pomoću njihovog naslova  
  
Korisnik također može pritisnuti na bilo koji od stripova kako bi otišao na stranicu odabranog stripa  

![image](https://user-images.githubusercontent.com/56473997/156173590-6a7ae060-bbc5-4c2d-8721-957d6579a15e.png)  
  
## Activity odabranog stripa: 
Kada izaberemo jedan od stripova dobijemo prikaz na kojem su pokazane informacije o tom stripu kao na primjer ime stripa i autor.  
Na gumb Read More možemo pročitati o čemu se u stripu radi.  
Dolje imamo listu epizoda na kojoj biramo jednu koju ćemo čitati.  
![image](https://user-images.githubusercontent.com/56473997/156183344-c987338a-ed6d-42f3-9319-997f03bc0ea2.png)
![image](https://user-images.githubusercontent.com/56473997/156183776-cfc0add8-eac5-413f-9b9d-0e4a073e7a86.png)  

## Activity čitanja stripa:  
Izborom epizode pokrene se sljedeći prikaz na kojem su uzastopno poredane stranice epizode te se scrollanjem prema dolje čita cijeli strip.  
![image](https://user-images.githubusercontent.com/56473997/156184382-84e47d92-6e61-47dc-894e-401f4a11f9dd.png)

