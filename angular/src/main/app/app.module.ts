import {BrowserModule} from "@angular/platform-browser";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {NgModule} from "@angular/core";
import {AppRoutingModule} from "./app-routing.module";
import {AdminDashboardComponent} from "./admin/admin-dashboard.component";
import {AdminFormComponent} from "./admin/admin-form.component";
import {AdminListComponent} from "./admin/admin-list.component";
import {AppComponent} from "./app.component";
import {ContactComponent} from "./contact/contact.component";
import {LoginComponent} from "./login/login.component";
import {PersonListComponent} from "./person/person-list.component";
import {RoleListComponent} from "./role/role-list.component";
import {PersonFormComponent} from "./person/person-form.component";
import {RoleFormComponent} from "./role/role-form.component";
import {PersonService} from "./services/person.service";
import {RoleService} from "./services/role.service";
import {InMemoryWebApiModule} from "angular-in-memory-web-api";
import {InMemoryDataService} from "./services/in-memory-data.service";
import {PersonRoleListComponent} from "./role/person-role-list.component";
import {PersonViewFormComponent} from "./person/person-view-form.component";
import {PersonUpdateFormComponent} from "./person/person-update-form.component";

@NgModule({
    imports: [
        AppRoutingModule,
        BrowserModule,
        FormsModule,
        HttpModule,
        InMemoryWebApiModule.forRoot(InMemoryDataService),
        ReactiveFormsModule
    ],
    declarations: [
        AppComponent,
        LoginComponent,
        AdminDashboardComponent,
        AdminFormComponent,
        AdminListComponent,
        ContactComponent,
        PersonRoleListComponent,
        PersonFormComponent,
        PersonListComponent,
        PersonViewFormComponent,
        PersonUpdateFormComponent,
        RoleFormComponent,
        RoleListComponent
    ],
    providers: [
        PersonService,
        RoleService
    ],
    bootstrap: [
        AppComponent
    ]
})

export class AppModule {
}