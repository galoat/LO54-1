Cette application gere l'inscription aux cours d'une Université Technologique.
Il s'agit d'une application web listant toutes les formations disponibles et
pour chaque formation, les dates des prochaines sessions prévues.
De plus les Sujets Cours, le lieu de cours, ainsi que les Clients sont stocké en Base de donnée.

L'utilisateur peut :
	- filtrer la liste des formations par un mot clé contenu dans le titre de la formation.
	- filtrer la liste des formations par les sessions disponibles à une date donnée.
	- filtrer la liste des formations en fonction du lieu de la session, ce lieu provenant
	d'une liste déroulante.

L'utilisateur peut sélectionner une session et s'y pré-inscrire en indiquant ses
coordonnées personnelles (Nom, Prénom, Adresse, Téléphone, Email).

On considérera qu'une même personne s'inscrivant à 2 sessions est alors présente 2 fois dans la base.


La base de données est la suivante :
	LOCATION
		*ID → Number AUTO (PK)
		*CITY → Char Not Null
	COURSE
		*CODE → Char Not Null (PK)
		*TITLE → Char Not Null
	COURSE_SESSION
		*ID → Number AUTO (PK)
		*START_DATE → Date Not Null
		*END_DATE → Date Not Null
		*COURSE_CODE → Char Not Null (FK)
		*LOCATION_ID → Number Not Null (FK)
	CLIENT
		*ID → Number AUTO (PK)
		*LASTNAME → Char Not Null
		*FIRSTNAME → Char Not Null
		*ADDRESS → Char Not Null
		*PHONE → Char Not Null
		*EMAIL → Char
		*COURSE_SESSION_ID → Number Not Null (FK)

Cette base doit etre implementé en MySQL

Pour l'installer il faut changer le fichier LO54/source/projet/src/main/resources/hibernate.cfg.xml
	si vous voulé que l'applciation gere la creation de la base de donné changé <myxml> <property name="hbm2ddl.auto">validate</property></myxml>par   <property name="hbm2ddl.auto">create</property>'
	l'adresse du serveur MySQL doit étre renseigné entre le balise   '<property name="connection.url"> ************</property> '
	Le nom d'utilisateur root de la Base de donné doit étre renseigné entre les balise : '<property name="connection.username">******</property>'
	Le mot de passe root de la base de donné doit étre renseigné entre les balise :  '<property name="connection.password">************</property>'
