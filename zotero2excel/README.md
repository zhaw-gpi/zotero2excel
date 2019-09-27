# README

Zwischenstand am 27.9.:
- Fortschritte SCHEMA2CLASS:
  - Charsets.java automatisch erzeugt, allerdings musste von Hand noch @Entity und @Id hinzugefügt werden => Template anzupassen
  - Hierfür Telosys genutzt und zwar wie folgt (Anleitungen aus https://github.com/telosys-tools-bricks/telosys-cli/wiki und http://telosys.blogspot.com/2019/07/create-database-model-from-sqlite-db.html befolgt):
    - Telosys VS-Code-Extension installiert
    - Telosys CLI installiert und in Path hinzugefügt
    - Im Root-Verzeichnis des Projekts tt eingegeben, um CLI zu starten
    - > h . // Zum Setzen des Home-Verzeichnisses
    - > init // Für Projekt-Initialisierung (Telosys Ordner erstellen)
    - databases.dbcf erweitert mit SQLITE-DB-Konfiguration
    - > cdb // Testen, ob Connection zu DB funktioniert
    - > ndbm // Neues Datenmodell von Datenbank erzeugen
    - > lgh // Um alle Bundles (mit Templates für Code-Generierung aus Model) im Telosys-Github-Repo anzuzeigen
    - > ib basic // um das Bundle 'Basic-Templates-Samples-T300' herunterzuladen
    - > b basic // Um dieses Bundle als relevant für die Code-Generierung zu setzen
    - telosys-tools.cfg anpassen (ROOT_PKG und ENTITY_PKG), damit (theoretisch) die Klassen in den richtigen Packages erzeugt werden (offenbar muss auch noch das Template angepasst werden)
    - > lt // Um alle Templates im Bundle anzuzeigen
    - > gen * java_bean // Um das Template java_bean auf alle Tabellen im Model anzuwenden und Java-Klassen zu generieren
  - Es gibt auch Spring-Bundles, aber trotzdem ist in keinem der auf Github vorhandenen Bundles ein Template für korrekte @Entity-Klassen => selbst solche erstellen basierend auf dem bestehende Template java_bean.vm im Basic-Templates-Samples-T300-Folder
  - Zudem könnte man auch gleich Repository-Klassen erstellen basierend auf dem Template XxxRepository_java.vm im java7-persistence-spring-data-jpa-Bundle
  - Gemäss http://telosys.blogspot.com/2019/07/create-database-model-from-sqlite-db.html ist es bei SQLite nicht möglich, automatisch die PK und FK zu setzen (hab's nicht getestet) => vermutlich müssen dann die relevanten generierten Klassen selbst noch erweitert werden um die entsprechenden Properties
- Fortschritte SQLITE-ZUGRIFF:
  - Wenn man alle Tabellen bis auf charsets löscht aus der SQLite-Datenbank (hierzu die untenstehenden SQL-Statements nutzen), dann funktioniert der Entity-Manager und entsprechend kann man Daten aus der Tabelle lesen und in sie schreiben
  - Macht man dies nicht, kann wiederum der EntityManager nicht gebuildet werden wegen einer NestedException (NoSuchElementException)
- Fortschritte EXPORT2EXCEL:
  - Mit Apache POI wird im ExcelWriter eine Excel-Datei erzeugt, welche alle Charsets in formatierter Form ausgibt als XLSX-Datei im Projektverzeichnis


DROP TABLE IF EXISTS "retractedItems";
DROP TABLE IF EXISTS "publicationsItems";
DROP TABLE IF EXISTS "feeds";
DROP TABLE IF EXISTS "syncQueue";
DROP TABLE IF EXISTS "feedItems";
DROP TABLE IF EXISTS "libraries";
DROP TABLE IF EXISTS "customBaseFieldMappings";
DROP TABLE IF EXISTS "highlights";
DROP TABLE IF EXISTS "annotations";
DROP TABLE IF EXISTS "storageDeleteLog";
DROP TABLE IF EXISTS "syncDeleteLog";
DROP TABLE IF EXISTS "fulltextItemWords";
DROP TABLE IF EXISTS "fulltextItems";
DROP TABLE IF EXISTS "groupItems";
DROP TABLE IF EXISTS "groups";
DROP TABLE IF EXISTS "itemRelations";
DROP TABLE IF EXISTS "collectionRelations";
DROP TABLE IF EXISTS "relationPredicates";
DROP TABLE IF EXISTS "deletedItems";
DROP TABLE IF EXISTS "savedSearchConditions";
DROP TABLE IF EXISTS "collectionItems";
DROP TABLE IF EXISTS "itemAttachments";
DROP TABLE IF EXISTS "itemNotes";
DROP TABLE IF EXISTS "itemData";
DROP TABLE IF EXISTS "syncedSettings";
DROP TABLE IF EXISTS "itemTags";
DROP TABLE IF EXISTS "tags";
DROP TABLE IF EXISTS "savedSearches";
DROP TABLE IF EXISTS "itemCreators";
DROP TABLE IF EXISTS "creators";
DROP TABLE IF EXISTS "items";
DROP TABLE IF EXISTS "collections";
DROP TABLE IF EXISTS "translatorCache";
DROP TABLE IF EXISTS "syncCache";
DROP TABLE IF EXISTS "transactionLog";
DROP TABLE IF EXISTS "transactions";
DROP TABLE IF EXISTS "transactionSets";
DROP TABLE IF EXISTS "syncObjectTypes";
DROP TABLE IF EXISTS "itemTypeCreatorTypes";
DROP TABLE IF EXISTS "creatorTypes";
DROP TABLE IF EXISTS "fileTypeMimeTypes";
DROP TABLE IF EXISTS "fileTypes";
DROP TABLE IF EXISTS "baseFieldMappingsCombined";
DROP TABLE IF EXISTS "baseFieldMappings";
DROP TABLE IF EXISTS "itemTypeFieldsCombined";
DROP TABLE IF EXISTS "itemTypeFields";
DROP TABLE IF EXISTS "fieldsCombined";
DROP TABLE IF EXISTS "fields";
DROP TABLE IF EXISTS "fieldFormats";
DROP TABLE IF EXISTS "itemTypesCombined";
DROP TABLE IF EXISTS "itemTypes";
DROP TABLE IF EXISTS "zoteroDummyTable";
DROP TABLE IF EXISTS "customItemTypeFields";
DROP TABLE IF EXISTS "customFields";
DROP TABLE IF EXISTS "customItemTypes";
DROP TABLE IF EXISTS "proxyHosts";
DROP TABLE IF EXISTS "proxies";
DROP TABLE IF EXISTS "fulltextWords";
DROP TABLE IF EXISTS "users";
DROP TABLE IF EXISTS "itemDataValues";
DROP TABLE IF EXISTS "settings";
DROP TABLE IF EXISTS "version";