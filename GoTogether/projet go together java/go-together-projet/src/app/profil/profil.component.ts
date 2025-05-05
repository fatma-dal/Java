// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-profil',
//   imports: [],
//   templateUrl: './profil.component.html',
//   styleUrl: './profil.component.css'
// })
// export class ProfilComponent {

// }
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-profil',
  imports: [RouterLink],
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent {
  // Variable pour stocker l'image de profil
  profileImage: string | ArrayBuffer | null = null;

  // Fonction pour gérer le fichier sélectionné
  onFileSelected(event: any): void {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.profileImage = reader.result;
      };
      reader.readAsDataURL(file);
    }
  }
}
