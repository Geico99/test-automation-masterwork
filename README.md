Masterwork website url: http://test-automation-shop1.greenfox.academy
A mestermunka témája az adott URL-en található "prestashop" elnevezésű webshop tesztelése

Teszteset - Google SpreadSheets: https://docs.google.com/spreadsheets/d/1UHG6rrlVBIwq-19tXDOrEtEhtXXLZlG6cJ0u9gdhJnI/edit?usp=sharing

Futtatási metódus és az automatizált tesztesetekhez szükséges információk:

- A tesztek Java nyelven kerültek megírásra IntelliJ IDEA segítségével Gradle projektben
- A tesztek futtatásához először klónozza ezt a repositoryt
- Nyissa meg a saját gépén a projektet IntelliJ és Gradle segítségével
- Az Allure futtatásához és a riportok megtekintéséhez az alábbi parancsokat szükséges a terminálban futtatni
- 	A teszt elött "gradlew clean test"
- 	A teszt után "greadlew allureReport"
- 	illetve az "gradlew allureServe" vagy "allure serve build/allure-results"
- A parancsok futtatásához szükséges lehet a "./"parancs használata a közvetlen a felsorolt parancsok előtt
