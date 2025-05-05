import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ChatbootComponent } from './chatboot/chatboot.component';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet,ChatbootComponent,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'go-together-projet';
  ChatbootComponent: any;

  isLandingPage(): boolean{
    return ["/landing-page", "/login", "/register"].includes(location.pathname);
  }

  
}
