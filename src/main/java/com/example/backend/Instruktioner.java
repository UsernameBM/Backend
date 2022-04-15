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
 */
