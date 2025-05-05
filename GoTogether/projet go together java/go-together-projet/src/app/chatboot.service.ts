import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import environment from '../../environment/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChatbootService {
  private requestUrl = `https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=${environment.gemini_API_key}`;

  constructor(private http: HttpClient) {}

  askAI(query: string): Observable<any> {
    const body = {
      contents: [{
        parts: [{ text: query }]
      }]
    };

    return this.http.post(this.requestUrl, body);
  }
}