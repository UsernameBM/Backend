/* Hej Bill!

Här kommer vi använda oss av våra metoder som finns i backend för att kunna förklara hur vi tänkte att göra i frontend
Majoriteten av våra metoder fanns redan klart, det fattades enbart bara 2 metoder till så att backend skulle ha
dem viktigaste faktorerna som en biograf ska ha!

Vi börjar med inloggningen

2 knappar. Att logga in eller registrera sig. Vi har använt oss av tokens så varje gång vi loggar in,
anropas "/authorize"- metoden(som är kopplat till vår login knapp) med den metoden
så kommer vi kunna se i vår "customer"-tabell om en kund finns i databasen och matchar värderna som finns
i kolumnen password & user_name. Samma logik används för personal inloggningen. //behöver skriva mer tror jag

När vi ska registrera en ny användare så använder vi oss av metoden "/insertCustomer" då i frontend så ska vi få
5 stycken textfält där man matar in Förnamn, Efternamn, Användarnamn, Lösenord och Upprepa lösenord.
Vi matar alltså in parametrarna för att kunna insert en ny customer i vår databas med hjälp av textfälterna.
I vår frontend har vi även gjort så att lösenorden måste matcha varandra (Lösenord och Upprepa lösenords textfälterna)
så att det ens ska vara möjligt att kunna skicka värderna till databasen. Vi har även gjort en till metod som körs för
att se om användarnamnet är redan upptaget eller inte. Metoden heter, "/verifyCustomerUsername" där vi tar alla värden
från customer-tabellen och endast jämför med user_name, ifall användarnamnet redan finns i vår databas så får vi
"Customer exist" annars om det inte finns så insertas värdena i tabellen utan problem!. Allt jämförs och körs när vi
trycker på "registera"-knappen som finns i vår frontend och om allt stämmer så kommer vi få fram en text ruta som
står "Användare har registrerats. Gå tillbaka för att logga in!".

När man lyckas att logga in som costumer så kommer vi hamna i customer sidan där man har tillgång till
3 tabs "Vår biograf", "Boka biljett" och "Mina Sidor". I "Vår biograf"-delen så ska det visa alla filmer som finns
tillgängliga att kolla på. Tanken var att ha en TableView (JavaFX) som skulle visa alla filmer som fanns i databasen
med hjälp av vår endpoint "/getAllMovieById" (den ska egentligen heta "/getAllMovie") som då anropar alla värden som
finns i movie-tabellen (MySQL) i en ArrayList. Sen har vi "Boka biljett"-delen, där man ska kunna välja film, boka
plats/platser, välja datum och pris. Det gör vi med endpoint "/insertTicket". Till sist har vi "Mina sidor", där
customern som har loggat in kan se sina personliga uppgifter med hjälp av "/getCustomer"-metoden med hjälp från
Web tokens. Man kan även uppdatera sina personliga uppgifter med "/updateCustomer" samt så kan man radera sin biljett
med hjälp av "/deleteTicket".

Ifall man loggar in som personal i personal-inloggningen så hamnar vi vid "admin-sidan" där man har tillgång till
"Filmvisningar", "Lägg till/ta bort filmer", "Lägg till ny personal", "Mina sidor" och tillslut "schema". I filmvisning
så ska man både kunna se och göra filmvisningar genom att använda 2 olika endpoints. Den första är "/addScreening" där
man fyller i parametrarna till vilken salong, film och datum för att sedan kunna se det i TableView (JavaFX). Men för
att kunna visa värderna som finns i tabellen så anropar vi "/getAllScreening" (här uppstod det problem). Sen har vi
"Lägg till/ta bort filmer"- delen där vi kan infoga in filmer i databasen med hjälp av "/insertMovie" och även kunna
ta bort filmer med metoden "/deleteMovie". Efter det så kommer vi till "Lägg till ny personal"-delen som liknar mycket
"registering"-delen i customer-delen (vi använder inprincip samma logik här). "Mina sidor"-delen(personal) är också
nästan som customers "Mina sidor", så vi använder samma logik där. "Schema"-delen så hade vi tänkt att använda
metoden "/insertSchedule" för att kunna infoga scheman. Vi har även en TableView (JavaFX) som ska visa värderna
som finns i DB tabellen, personalschedule, men vi fick samma fel som TableViewn i "Filmvisningar". (För att få alla
värden från personalschedule-tabellen så anropar vi "/getAllPersonalSchedule"). Man kan även ta bort scheman genom
använda "/deleteSchedule"-metoden.

Här nere så kan du testa alla metoder:)
//infoga eran kod här, helst i ordning!
 */
/**
 * Här nere så kan du testa alla metoder:)
 *
 * PERSONALSCHEDULE:
 * ________________________________________________________________________________________
 * Används för lägga till schema för personal i databasen!
 *
 * http://localhost:8080/insertPersonalSchedule?idSalon=1&idUser=1&Counter=ja&Kitchen=nej&date=2022-04-29,09:00-15:30
 *
 * Används för att ta bort schema för personal!
 *http://localhost:8080/deleteSchedule?id=1
 *
 * Används för att visa alla schema som finns i databasen!
 * http://localhost:8080/getAllPersonalSchedule
 *
 * SALON:
 * ________________________________________________________________________________________
 * Används för att lägga till en Sal i databasen!
 * http://localhost:8080/addSalon?seats=80&row=5&cinema_name=kista
 *
 * Används för att se hur många platser/rader en specifik sal har på en bio!
 * http://localhost:8080/requestSalon?id=1
 *
 * Används för att se alla existerande salar
 * http://localhost:8080/getAllSalons
 *
 * SCREENING:
 * _________________________________________________________________
 * Används för att lägga till en visning i databasen!
 * http://localhost:8080/addScreening?time=17:00&movieId=1&idSalon=1
 *
 * Används för att se en specifik visning från databasen!
 * http://localhost:8080/requestScreening?id=1
 *
 * Används för att se alla tillgängliga visningar!
 * http://localhost:8080/getAllScreening
 *infoga eran kod här, helst i ordning!
 */