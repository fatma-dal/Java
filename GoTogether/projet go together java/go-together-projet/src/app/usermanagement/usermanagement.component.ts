// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-usermanagement',
//   imports: [],
//   templateUrl: './usermanagement.component.html',
//   styleUrl: './usermanagement.component.css'
// })
// export class UsermanagementComponent {

// }
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-usermanagement',
  imports: [CommonModule, FormsModule],
  templateUrl: './usermanagement.component.html',
  styleUrls: ['./usermanagement.component.css']
})
export class UsermanagementComponent {
  searchQuery: string = ''; // Variable liée au champ de recherche
  users = [
    { name: 'John Doe', email: 'john.doe@example.com', type: 'Driver', status: 'Active' },
    { name: 'Jane Smith', email: 'jane.smith@example.com', type: 'Passenger', status: 'Inactive' },
    { name: 'Mark Johnson', email: 'mark.johnson@example.com', type: 'Driver', status: 'Active' }
    // Tu peux ajouter ici plus d'utilisateurs
  ];
  filteredUsers = this.users; 

  // Méthode appelée à chaque changement dans le champ de recherche
  onSearchChange() {
    if (this.searchQuery.trim()) {
      this.filteredUsers = this.users.filter(user =>
        user.name.toLowerCase().includes(this.searchQuery.toLowerCase())
      );
    } else {
      this.filteredUsers = this.users; // Si la recherche est vide, afficher tous les utilisateurs
    }
  }
}

