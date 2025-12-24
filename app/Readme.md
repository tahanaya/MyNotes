# 📱 MyNotes - Application Android de Gestion de Notes

Application Android native en Java permettant de gérer des notes personnelles de manière organisée avec système de priorités visuelles.

![Android](https://img.shields.io/badge/Platform-Android-green.svg)
![Java](https://img.shields.io/badge/Language-Java-orange.svg)
![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg)

## 🎯 Fonctionnalités

- ✅ **Affichage de la liste des notes** avec ListView
- ✅ **Ajout de nouvelles notes** via formulaire dédié
- ✅ **Consultation des détails** d'une note
- ✅ **Système de priorités** (Basse, Moyenne, Haute)
- ✅ **Codage couleur visuel** pour identification rapide
- ✅ **Capture photo** avec la caméra intégrée
- ✅ **Sélection de date** avec DatePicker

## 🏗️ Architecture Technique

### Structure des Données
```java
public class Note {
    private String nom;           // Titre de la note
    private String description;   // Contenu détaillé
    private String date;          // Date (format JJ/MM/AAAA)
    private String priorite;      // Basse, Moyenne, ou Haute
    private String photoPath;     // Chemin de la photo (optionnel)
}
```

### Composants Principaux

#### Activities
- **NoteListActivity** : Écran d'accueil avec liste des notes
- **AddNoteActivity** : Formulaire d'ajout de note
- **DetailsNoteActivity** : Affichage détaillé d'une note

#### Adapter Personnalisé
**NoteAdapter** (BaseAdapter) avec pattern ViewHolder :
- Optimisation des performances par recyclage des vues
- Mise en cache des références UI
- Codage couleur dynamique selon la priorité

## 🎨 Interface Utilisateur

### Couleurs des Priorités
- 🔴 **Haute** : Rouge (#FF5252) - Urgent
- 🟠 **Moyenne** : Orange (#FFA726) - Important
- 🟢 **Basse** : Vert (#66BB6A) - Normal

### Layouts
- **item_note.xml** : Item de liste avec bande de couleur
- **activity_note_list.xml** : ListView + FloatingActionButton
- **activity_add_note.xml** : Formulaire avec ScrollView
- **activity_details_note.xml** : Affichage complet de la note

## 🛠️ Technologies Utilisées

- **Langage** : Java
- **SDK Minimum** : API 24 (Android 7.0 Nougat)
- **SDK Compilé** : API 36
- **SDK Cible** : API 35
- **Build System** : Gradle (Kotlin DSL)

### Bibliothèques
```gradle
androidx.appcompat:appcompat:1.6.1
com.google.android.material:material:1.9.0
androidx.core:core:1.12.0
```

## 📦 Installation

### Prérequis
- Android Studio Arctic Fox ou supérieur
- JDK 11 ou supérieur
- Émulateur Android ou appareil physique

### Étapes

1. **Cloner le repository**
```bash
git clone https://github.com/tahanaya/MyNotes.git
```

2. **Ouvrir dans Android Studio**
    - File → Open → Sélectionnez le dossier du projet

3. **Synchroniser Gradle**
    - Cliquez sur "Sync Now" si demandé

4. **Lancer l'application**
    - Sélectionnez un émulateur ou appareil
    - Cliquez sur Run ▶

## 📸 Permissions
```xml
<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
```

## 🚀 Utilisation

### Ajouter une Note
1. Cliquez sur le bouton flottant **+** (FAB bleu)
2. Remplissez le formulaire :
    - **Titre** : Nom de la note
    - **Description** : Contenu détaillé
    - **Date** : Sélection via DatePicker
    - **Priorité** : Choix via Spinner
3. (Optionnel) Prenez une photo avec 📷
4. Cliquez sur **Enregistrer**

### Consulter une Note
- Cliquez sur n'importe quelle note dans la liste
- Les détails complets s'affichent avec la photo si présente
- Bouton **Retour** pour revenir à la liste

## 📐 Architecture de l'Adapter

### Pattern ViewHolder
```java
static class ViewHolder {
    TextView tvNom;
    TextView tvDate;
    View viewPriorite;
}
```

**Avantages :**
- ⚡ Réduit les appels à `findViewById()`
- 🔄 Recycle les vues efficacement
- 📈 Améliore la fluidité du scroll
- 💾 Optimise la consommation mémoire

### Méthode getView()
1. Vérifie si `convertView` est null
2. Si null : inflate le layout + création ViewHolder
3. Sinon : récupération du ViewHolder existant
4. Mise à jour des données
5. Application de la couleur selon priorité

## 📊 Structure du Projet
```
MyNotes/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/mynotes2/
│   │   │   │   ├── models/
│   │   │   │   │   └── Note.java
│   │   │   │   ├── adapters/
│   │   │   │   │   └── NoteAdapter.java
│   │   │   │   ├── NoteListActivity.java
│   │   │   │   ├── AddNoteActivity.java
│   │   │   │   └── DetailsNoteActivity.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_note_list.xml
│   │   │   │   │   ├── activity_add_note.xml
│   │   │   │   │   ├── activity_details_note.xml
│   │   │   │   │   └── item_note.xml
│   │   │   │   └── xml/
│   │   │   │       └── file_paths.xml
│   │   │   └── AndroidManifest.xml
│   └── build.gradle.kts
└── README.md
```

## 🔄 Améliorations Futures

- [ ] Édition de notes existantes
- [ ] Suppression de notes avec confirmation
- [ ] Recherche et filtrage par priorité/date
- [ ] Persistance des données (SQLite ou Room)
- [ ] Export/Import de notes (JSON)
- [ ] Mode sombre
- [ ] Notifications pour notes importantes
- [ ] Tri personnalisé de la liste

## 👨‍💻 Auteur

**Taha**  
Étudiant en 5ème année Génie Informatique  
ENSA Tanger - Spécialité Systèmes d'Information

## 📄 Licence

Projet académique - TP2 Développement Mobile Android  
ENSA Tanger - 2024/2025

## 🙏 Remerciements

- Équipe pédagogique ENSA Tanger
- Documentation Android Developers
- Communauté Stack Overflow

## 📞 Contact

Pour toute question concernant ce projet :
- 📧 Email : votre.email@etu.uae.ac.ma
- 💼 LinkedIn : [Votre profil]
- 🐙 GitHub : [@votre-username]

---

⭐ N'hésitez pas à mettre une étoile si ce projet vous a été utile !
