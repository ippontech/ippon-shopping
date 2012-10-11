Ippon Shopping
================

Présentation
------------

Konnichiwa !

Bienvenue dans Ippon Shopping ! Nous sommes une boutique vendant essentiellement des articles de sport. Le but de ce
projet est de faire fonctionner le "caddie" dans lequel les clients vont pouvoir stocker leurs achats.

Ce jeu se déroule en 3 étapes, les fonctionnalités du caddie devenant de plus en plus complexes à chaque fois.

Attention :
- Vous ne devez pas modifier les tests, sous peine de subir un hansoku make !
- Les étapes sont incrémentales : à la fin de la dernière étape, l'ensemble des tests doivent fonctionner

Hajime !

Méthodologie
------------

Le but de ce jeu est de développer une application en utilisant la méthodologie "Behavior-Driven Development".

Nous utiliserons pour cela l'outil Cucumber :

- Cucumber : https://github.com/cucumber/cucumber
- Version Java de Cucumber : https://github.com/cucumber/cucumber-jvm

Vous pouvez valider les "featues" à implémenter de deux manières, selon votre préférence :

- En utilisant Maven : en plus de la sortie console, un rapport graphique sera produit dans target/cucumber-html-report/index.html
- En exécutant depuis votre IDE le test JUnit : fr.ippon.examples.shopping.RunCucumberTest

De plus, il existe des plugins permettant d'afficher ces scénarios dans votre IDE de manière plus "jolie" (c'est le cas
par défaut avec Intellij IDEA, en particulier).

Etape 1 : Codons les fonctionnalités simples
--------------------------------------------

Un certain nombre de cas fonctionnels ont été listés dans le fichier "basic_shopping.feature" : à vous de coder les classes
qui les feront fonctionner !

Etape 2 : La taxe sur la valeur ajoutée
---------------------------------------

Les sommes calculées jusqu'à présent étaient en "hors taxe", or nous allons évidemment facturer la TVA à nos clients.

De nouveaux cas fonctionnels ont été listés dans le fichier "value_added_tax.feature", à vous de les réaliser.

Etape 3 : C'est Noël !
---------------------------------------

Pour Noël nous allons lancer une offre spéciale : le code que vous devez écrire est détaillé dans "xmas_offer.feature".

Etape 4 : Refactoring
---------------------------------------

Vous avez sans doute codé quelques fonctionnalités assez rapidement : il est temps maintenant de faire une étape de
refactoring.

Copyright 2012 [Ippon Technologies](http://www.ippon.fr)

