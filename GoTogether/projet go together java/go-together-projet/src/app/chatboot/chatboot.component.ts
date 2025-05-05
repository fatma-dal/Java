import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ChatbootService } from '../chatboot.service';

@Component({
  selector: 'app-chatboot',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './chatboot.component.html',
  styleUrls: ['./chatboot.component.css']
})
export class ChatbootComponent {
  isChatOpen = false;
  userMessage = '';
  messages: { sender: string, text: string }[] = [
    { sender: 'AI', text: 'Hello! How can I help you today?' }
  ];

  constructor(private chatbootService: ChatbootService) {}

  toggleChat() {
    this.isChatOpen = !this.isChatOpen;
  }

  sendMessage() {
    if (this.userMessage.trim()) {
      this.messages.push({ sender: 'Vous', text: this.userMessage });
      const query = this.userMessage;
      this.userMessage = '';

      this.chatbootService.askAI(query).subscribe({
        next: (res: any) => {
          const response = res?.candidates?.[0]?.content?.parts?.[0]?.text ?? 'Pas de réponse';
          this.messages.push({ sender: 'AI', text: response });
        },
        error: () => {
          this.messages.push({ sender: 'AI', text: 'Erreur de communication avec le serveur.' });
        }
      });
    }
  }
}