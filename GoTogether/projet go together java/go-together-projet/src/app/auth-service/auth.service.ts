import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }
  login({ email, password }: { email: string, password: string }) {
    return this.http.post("http://localhost:8080/api/users/auth/login", { email, password });
  }
  signup({ email, password, username,confirmPassword }: { email: string, password: string, username: string,confirmPassword: string }) {
    return this.http.post("http://localhost:8080/api/users/auth/signup", { email, password, username,confirmPassword });
  }
}
