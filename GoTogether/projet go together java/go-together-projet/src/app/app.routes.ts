import { Routes } from '@angular/router';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProfilComponent } from './profil/profil.component';
import { ProposetrajetComponent } from './proposetrajet/proposetrajet.component';
import { SearchtrajetComponent } from './searchtrajet/searchtrajet.component';
import { TrajetDetailsComponent } from './trajet-details/trajet-details.component';
import { TrafficDashboardComponent } from './traffic-dashboard/traffic-dashboard.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { VerificationComponent } from './verification/verification.component';
import { UsermanagementComponent } from './usermanagement/usermanagement.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { ChatbootComponent } from './chatboot/chatboot.component';
import { DashboardComponent } from './dashboard/dashboard.component';

export const routes: Routes = [

    {
        path:"userdashboard",
        redirectTo:"userdashboard/searchtrajet",
        pathMatch:"full"
    },
    {
        path:"admindashboard",
        redirectTo:"admindashboard/dashboard",
        pathMatch:"full"
    },
    {path:"",component:LandingPageComponent},
    {path:"login",component:LoginComponent},
    {path:"register",component:RegisterComponent},
      
    {path:"details",component:TrajetDetailsComponent },
    {path:"traffic",component:TrafficDashboardComponent },
    {path: "admindashboard", component: AdmindashboardComponent, children: [
        { path:"driver-verification", component: VerificationComponent  },
        { path:"usermanagement", component:UsermanagementComponent  },
        { path:"dashboard", component:DashboardComponent  },]
    },
    {path: "userdashboard", component: UserdashboardComponent, children: [
        {path:"searchtrajet",component:SearchtrajetComponent },
        {path:"proposetrajet",component:ProposetrajetComponent },
        {path:"profil",component:ProfilComponent},
        {path:"details",component:TrajetDetailsComponent },
        {path:"chatboot",component: ChatbootComponent}, 
    ]}

];
