import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AdminDashboardComponent } from './admin/admin-dashboard.component';
import { AdminFormComponent } from './admin/admin-form.component';
import { AdminListComponent } from './admin/admin-list.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { PersonListComponent } from './person/person-list.component';
import { RoleListComponent } from './role/role-list.component';
import { PersonFormComponent } from "./person/person-form.component";

@NgModule({
    imports: [
        AppRoutingModule,
        BrowserModule,
        FormsModule,
        HttpModule
    ],
    declarations: [
        AppComponent,
        LoginComponent,
        AdminDashboardComponent,
        AdminFormComponent,
        AdminListComponent,
        PersonListComponent,
        PersonFormComponent,
        RoleListComponent
    ],
    providers: [

    ],
    bootstrap: [
        AppComponent
    ]
})

export class AppModule { }