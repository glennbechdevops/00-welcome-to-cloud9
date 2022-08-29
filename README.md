
# LAB - bli kjent med AWS og Cloud 9

## Litt om eksempel-appen

Målet med laben er å gjøre dere kjent med AWS Cloud9 - et utviklingsverktøy vi skal bruke i lab-øvelsene. 
Dette repositoryet inneholder en Spring Boot eksempel app. Appen ble brukt som eksamensoppgave i 2021.

En norsk bank har brukt flere år og hundretalls milioner på å utvikle et moderne kjernesystem for bank og et "fremoverlent" API som nesten tilfredsstiller Directive (EU) 2015/2366 of the European Parliament and of the Council on Payment Services in the Internal Market, published 25 November 2016 også kjent som PSD.
Dette er en viktig satsning innen området "Open Banking" for den nye nordiske banken BedreBank.
Arkitekturmessig består systemet av to komponenter.

* Et API, implementert ved hjelp av Spring Boot. Koden for applikasjonen ligger i dette repoet.
* Et kjernesystem som utfører transaksjoner med andre banker, avregner mot Norges bank osv. Dere kan late som metodekall 
som gjøres mot klassen ```ReallyShakyBankingCoreSystemService```, kommuniserer med dette systemet.

## Før dere starter

- Dere trenger en GitHub Konto
- Lag en _fork_ av dette repositoriet inn i din egen GitHub konto

![Alt text](img/fork.png  "a title")

### Sjekk ut Cloud 9 miljøet ditt i AWS og bli kjent med det

* URL for innlogging er https://244530008913.signin.aws.amazon.com/console
* Brukernavnet og passordet er gitt i klasserommet

* Fra hovedmenyen, søk etter tjenesten "cloud9"
* Velg "my environments" fra venstremenyen 
* Hvis du ikke ser noe å trykke på som har ditt navn, pass på at du er i rett region (gitt i klasserommet)
* Hvis du velger "9" ikonet på øverst til venstre i hovedmenyen vil du se "AWS Explorer". Naviger gjerne litt rundt I AWS Miljøet for å bli kjent.
* Blir kjent med IDEet-

![Alt text](img/cloud9.png  "a title")

Start en ny terminal i Cloud 9 ved å trykke (+) symbolet på tabbene
![Alt text](img/newtab.png  "a title")

Kjør denne kommandoen for å verifisere at Java 11 er installert

```shell
java -version
```
Du skal få 
```
openjdk 11.0.14.1 2022-02-08 LTS
OpenJDK Runtime Environment Corretto-11.0.14.10.1 (build 11.0.14.1+10-LTS)
OpenJDK 64-Bit Server VM Corretto-11.0.14.10.1 (build 11.0.14.1+10-LTS, mixed mode)
```

### Installer Maven i Cloud 9 

Kopier disse kommandoene inn i Cloud9 terminalen. De vil installere Maven. 
```shell
sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y apache-maven
```

### Lage en klone av din Fork (av dette repoet) inn i ditt Cloud 9 miljø

Lag en klone

```shell
git clone https://github.com/≤github bruker>/00-welcome-to-cloud9.git
```

* Forsøk å kjøre applikasjonen 
```shell
cd 00-welcome-to-cloud9
mvn spring-boot:run
```

Start en ny terminal i Cloud 9 ved å trykke (+) symbolet på tabbene
![Alt text](img/newtab.png  "a title")

Du kan teste applikasjonen med "CURL" fra Cloud 9.

```
curl -X POST \
http://localhost:8080/account/1/transfer/2 \
-H 'Content-Type: application/json' \
-H 'Postman-Token: e674b4f3-6e48-41a0-9e6f-de155a4baf02' \
-H 'cache-control: no-cache' \
-d '{
"amount": 1500
}'
```

Husk at dette er applikasjonen "Shakybank", en 500 Internal server error er svært vanlig :-)
```json
{
  "timestamp": "2022-04-04T21:34:45.542+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "",
  "path": "/account/1/transfer/2"
}
```
Når du ikke får noe output fra terminalen etter CURL kommandoen har requesten gått bra. 

## Done !

* Du har logget på- og fått tilgang til AWS.
* Du har nå blitt kjent med Labmiljøet vi skal bruke videre i kurset 
* Du har lært at du kan bruke _curl_ for å teste APIer 
* Du er blitt kjent med "shakybank" APIet
