import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';  // <-- AJOUTE ÇA
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-searchtrajet',
  standalone: true, // <-- Très important
  imports: [CommonModule, FormsModule, RouterLink], // <-- AJOUTE CommonModule ici
  templateUrl: './searchtrajet.component.html',
  styleUrls: ['./searchtrajet.component.css']
})
export class SearchtrajetComponent {
  departure: string = '';
  destination: string = '';
  date: string = '';

  allTrips = [
  { departure: 'Tunis', destination: 'Sousse', date: '2025-04-21', time: '09:00', seats: 4, price: 20, driver: 'Ahmed', rating: 4.7, trips: 55 },
  { departure: 'Sfax', destination: 'Monastir', date: '2025-04-22', time: '08:30', seats: 2, price: 18, driver: 'Yasmine', rating: 4.9, trips: 60 },
  { departure: 'Gabès', destination: 'Djerba', date: '2025-04-23', time: '14:00', seats: 3, price: 25, driver: 'Karim', rating: 4.5, trips: 48 },
  { departure: 'Bizerte', destination: 'Tunis', date: '2025-04-24', time: '07:00', seats: 5, price: 15, driver: 'Sami', rating: 4.8, trips: 72 },
  { departure: 'Kairouan', destination: 'Mahdia', date: '2025-04-25', time: '10:30', seats: 2, price: 22, driver: 'Amira', rating: 4.6, trips: 39 },
  { departure: 'Nabeul', destination: 'Hammamet', date: '2025-04-26', time: '12:00', seats: 4, price: 10, driver: 'Nour', rating: 4.9, trips: 85 },
  { departure: 'Sousse', destination: 'Tunis', date: '2025-04-27', time: '16:30', seats: 3, price: 20, driver: 'Omar', rating: 4.4, trips: 33 },
  { departure: 'Monastir', destination: 'Sfax', date: '2025-04-28', time: '09:15', seats: 2, price: 18, driver: 'Layla', rating: 5.0, trips: 91 },
  { departure: 'Djerba', destination: 'Gabès', date: '2025-04-29', time: '15:45', seats: 5, price: 28, driver: 'Houssem', rating: 4.3, trips: 40 },
  { departure: 'Tunis', destination: 'Bizerte', date: '2025-04-30', time: '08:00', seats: 3, price: 17, driver: 'Mariem', rating: 4.7, trips: 58 },

    // Ajoute d'autres trajets ici
  ];

  filteredTrips = [...this.allTrips];

  filterTrips() {
    this.filteredTrips = this.allTrips.filter(trip => {
      const matchesDeparture = this.departure ? trip.departure.toLowerCase().includes(this.departure.toLowerCase()) : true;
      const matchesDestination = this.destination ? trip.destination.toLowerCase().includes(this.destination.toLowerCase()) : true;
      const matchesDate = this.date ? trip.date === this.date : true;
      return matchesDeparture && matchesDestination && matchesDate;
    });
  }
  cities: string[] = [
    'Tunis', 'Sousse', 'Sfax', 'Monastir', 'Gabès', 'Djerba', 'Bizerte', 
    'Kairouan', 'Mahdia', 'Nabeul', 'Hammamet', 'Tozeur', 'Kebili', 'Zarzis', 
    'Gafsa', 'Beja', 'Le Kef', 'Jendouba', 'Siliana', 'Kasserine', 'Sidi Bouzid',
    'Medenine', 'Mahres', 'Mateur', 'Béjaïa', 'Tataouine', 'Dahmani', 'El Kef',
  ];
  
}
