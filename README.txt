Le programme est composé de 4 fichiers .java:

- ChatServer.java
- ChatClient.java
- ServerSocketManager.java 
- ClientSocketManager.java

Ainsi que de 2 fichiers .class:

- ServerSocketManager.class
- ClientSocketManager.class

Pour executer le programme , il faut tout d'abord executer la classe ChatServer, puis la classe ChatClient.
Apres avoir executé la classe Chatclient, une fenêtre "Chatter" s'ouvrira. 
Vous devrez appuyer sur le bouton connect afin de vous connecter au server. 
Lorsque le bouton "connecte" est pressé, le programme demandera l’adresse IP du serveur, 
le nom de la personne qui rejoint le forum/chat, (utilisé pour identifier tous les participants), 
et le numéro de port (4444 si le port par défaut est utilisé dans le serveur). 
Assurez-vous que les fichiers
ClientSocketManater.class et ServerSocketManater.class sont bien présents dans le même répertoire. 

Vous devrez remplir les fenetres suivantes comme suit : 
Enter IP of chat server --> localhost
Enter your name --> Mettez un nom quelquonque 
Enter port number --> 4444

Tout autre numéro de port valide peut être utilisé. Par défaut, le numéro de port est 4444.  
Apres cette étape, vous pourrez ecrire un message sur le petit rectangle blanc en haut de la fenetre, 
puis l'envoyer en cliquant sur le bouton send Message.
La classe ChatClient encodera le message,puis l'enverra au server pour le decoder.

Le message reçu décodé s'affichera sur la console du chatServer. La fenetre "Chatter affichera le message encodé de l'utilisateur,
suivi de l'echo contenant le même message encodé venant du serveur, pour s'assurer que le message a correctement été encodé puis décodé.



--------------------------------------------------

 
