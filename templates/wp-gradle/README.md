Note per lo sviluppo ed il deploy
=================================

Project data
------------

Wordpress version: **${wordpressVersion}**

Template base dir: **${wpTmplPath}**

SASS base dir: **${wpTmplPath}/sass**

La configurazione della versione di wordpress è nel file: **wordpress.properties**

La configurazione del server FTP è nel file: **ftp.properties**

GIT
---

Il file .gitignore è automaticamente configurato per esclusione di tutti i files della working directory ad eccezione di:

* build.gradle
* gradlew
* gradlew.bat
* gradle/
* wordpress.properties
* ${wpTmplPath}

Fare riferimento ai commenti presenti nel file **.gitignore** per variare le politiche di inclusione/esclusione secondo le proprie esigenze.

Si raccomanda di non includere il file **ftp.properties** perché contenente dati sensibili.

Tasks
-----

**Per installare una copia locale di wordpress:**

	./gradlew installWordpress

questo task scarica wordpress ${wordpressVersion} nella working directory rendendo il progetto eseguibile con MAMP.

**Per lanciare il daemon di compass:**

	./gradlew watch

I sorgenti sass sono in: **${wpTmplPath}/sass**

I file css vengono generati in: **${wpTmplPath}/styles**

**Per eseguire il deploy sul server FTP:**

	./gradlew publishSite

Questo task copia tutto il contenuto della cartella **${wpTmplPath}/** sul perorso remoto **${hostingServer}/${hostingHome}/${wpTmplPath}/**

Verificare che i dati contenuti nel file **ftp.properties** siano corretti.

Credits
-------

* [Peter Ledbrook](https://github.com/pledbrook) - Lazybones project
* [Rob Fletcher](https://github.com/robfletcher) - Gradle compass plugin
* [David Carr](https://bitbucket.org/davidmc24) - Gradle site plugin
* [Michel Krämer](https://github.com/michel-kraemer) - Gradle download plugin
* [Joe Bartlett](https://gist.github.com/jdbartlett/444295) - .gitignore file
