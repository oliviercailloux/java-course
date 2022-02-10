## Contexte PR
Cette PR fait suite à la PR #13  où un premier [diagramme de classe](https://github.com/oliviercailloux-org/dep-git-Teach_spreadsheets/blob/aa577d62458cd96fd0fb82600d8162c87e6ca0ad/Doc/Images/class_Online_Write.png) avait été fais  concernant l'écriture en ligne.  
On a donc retravaillé ce diagramme en prenant en compte  vos  précédentes remarques , ce qui à été codé en java pour la classe [XlsxSummarizer](https://github.com/oliviercailloux-org/dep-git-Teach_spreadsheets/blob/Java_Canva_Summarizer_it1/src/main/java/io/github/oliviercailloux/teach_spreadsheets/online/write/XlsSummarizer.java) (voir PR #16) ; la classe [AssignmentPerTeacher](https://github.com/oliviercailloux-org/dep-git-Teach_spreadsheets/blob/Java_Implementation_AssignmentPerTeacher-it1/src/main/java/io/github/oliviercailloux/teach_spreadsheets/online/write/AssignmentPerTeacher.java) (PR #17) et vos remarque sur la classe [WorksheetWriter](https://github.com/oliviercailloux-org/dep-git-Teach_spreadsheets/blob/Java_Implementation_Authentification_WriterLib-it1/src/main/java/io/github/oliviercailloux/teach_spreadsheets/online/write/WorksheetWriter.java)  (PR #15).  Voir ci-dessous le diagramme créer (["class_Online_Write"](https://discordapp.com/channels/@me/781179444278460417/838585249247658004)) et la [doc](https://discordapp.com/channels/@me/781179444278460417/838586977741438997) associée :

![image](https://user-images.githubusercontent.com/49473908/116834982-d2954300-abc0-11eb-8299-8aa081755541.png)

Pour recontextualiser ce qu'est un CoursePref, CourseAssginement, Course ... voir  [ le diagramme  des classes de base](https://github.com/oliviercailloux-org/dep-git-Teach_spreadsheets/tree/Diagram_Class_Online_Write-it4/Doc#base-classes)

## Détails PR

- Nous avons gardé le nom XlsxSummarizer  car les fichier excel en ligne sur office 365 sont bien au format Xlsx. (depuis la version de 2007 il s'agit de l'extension utilisée par Microsoft Office). Si vous pensez qu'il y aurai un nom plus adéquat on le modifiera.

- On a gardé la possibilité de pouvoir écrire dans la feuille avec l'adresse de la cellule (malgrés votre remarque [ici](https://github.com/oliviercailloux-org/dep-git-Teach_spreadsheets/pull/15/files#r616086045)  on avais préféré utiliser cette méthode pour bien montrer que l'on parcourait la colonne C) . Lors de programmation de  méthodes plus complexe où l'on devra parcourir plusieurs colonnes on privilégiera la méthode qui prend une ligne et une colonne en paramètre. (Si vous trouvez cela vraiment gênant on l'enlèvera).

- Désormais pour créer une feuille on prendra en paramètre le workbook (du type IWorkbookRequestBuilder de Microsoft)  qui acceuillera la feuille créer et la fonction renverra cette feuille. Et pour écrire dans une feuille on la prendra en paramètre (worksheet  du type IWorkbookWorksheetRequetBuilder de Microsoft). Cf : Nouvelle implémentation de WorksheetWriter (à la fin de la PR).

- Comme vous pouvez le voir, on ne représente plus sur ce diagramme le IGraphServiceClient car il n'est plus directement utilisé par la classe WorksheetWriter,  ce sera le rôle du Controler de  l'instancier de créer les différentes  feuilles vides et de les donner aux classes XslxSummarizer et AssginementPerTeacher pour qu'elles travaillent avec ces feuilles. 

En effet dans les précédentes PR de la 1ère itération de Java  les  classes programmées utilisaient le GraphServiceClient car elles en avaient besoin pour appeler les méthodes de WorksheetWriter. Elles devront donc être modifiées pour pouvoir fonctionner avec notre nouvelle implémentation de WorksheetWriter. On peut voir sur notre diagramme que par exemple XlsxSummarizer n'a plus besoin d'avoir en attribut fileId , worksheetName et graphClient mais à la place un attribut workSheet de type IWorkbookWorksheetRequetBuilder qui correspondra à la feuille vide donnée par le Controller où il faudra écrire. Idem pour AssignmentPerTeacher les fonctions n'ont plus besoin de prendre en paramètre les abribus précisés ci-dessus (modification à faire [ici ](https://github.com/oliviercailloux-org/dep-git-Teach_spreadsheets/blob/d7312805e808da4da2a912cf8f89407afc264ab1/src/main/java/io/github/oliviercailloux/teach_spreadsheets/online/write/AssignmentPerTeacher.java#L149) et  [là](https://github.com/oliviercailloux-org/dep-git-Teach_spreadsheets/blob/d7312805e808da4da2a912cf8f89407afc264ab1/src/main/java/io/github/oliviercailloux/teach_spreadsheets/online/write/AssignmentPerTeacher.java#L79) entre autres).

## Nouvelle implémentation de WorksheetWriter 
On à repris  la classe WorksheetWriter concernant l'écriture de la feuille en ligne comme conseillé [ici](https://github.com/oliviercailloux-org/dep-git-Teach_spreadsheets/pull/15#pullrequestreview-639150248) et [là](https://github.com/oliviercailloux-org/dep-git-Teach_spreadsheets/pull/15#discussion_r616084574) et également pour la création de la feuille. **Tout cela sera à implémenter lors de la prochaine itération de java.**

### Pour écrire dans une feuille :
#### Before
![image](https://user-images.githubusercontent.com/49473908/116831685-154f1f00-abb1-11eb-86ff-e5421ea659c5.png)

#### After 
![image](https://user-images.githubusercontent.com/49473908/116831998-13865b00-abb3-11eb-8953-b7981e425034.png)

### Pour créer une feuille : 
#### Before
![image](https://user-images.githubusercontent.com/49473908/116832241-4e3cc300-abb4-11eb-9485-7b5f4745d4a8.png)

#### After 
On renvoie désormais la feuille créée dans laquelle on pourra écrire
![image](https://user-images.githubusercontent.com/49473908/116832253-5eed3900-abb4-11eb-9585-fbb8c6c35fde.png)

### Exemple d'utilisation :
Ce qui change par rapport à l'ancienne utilisation est entouré en rouge.
![image](https://user-images.githubusercontent.com/49473908/116832545-97414700-abb5-11eb-8443-e6cfe8ba9c77.png)



