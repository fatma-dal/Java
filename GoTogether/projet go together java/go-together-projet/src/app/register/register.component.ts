import { Component } from '@angular/core';
import { AuthService } from '../auth-service/auth.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  email: string = '';
  password: string = '';
  confirmPassword: string = '';
  username: string = '';
  constructor(private authService: AuthService) { }
  register() {
    if (this.password !== this.confirmPassword) {
      alert("Passwords do not match!");
      return;
    }
    this.authService.signup({ 
      email: this.email, 
      password: this.password, 
      username: this.username, 
      confirmPassword: this.confirmPassword 
    }).subscribe(
      (response) => {
        console.log(response);
        alert("Registration successful!");
      },
      (error) => {
        console.error(error);
        alert("Registration failed!");
      }
    );
  }
}
