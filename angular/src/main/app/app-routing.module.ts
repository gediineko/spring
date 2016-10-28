import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AdminDashboardComponent} from "./admin/admin-dashboard.component";
import {AdminFormComponent} from "./admin/admin-form.component";
import {AdminListComponent} from "./admin/admin-list.component";
import {LoginComponent} from "./login/login.component";
import {PersonListComponent} from "./person/person-list.component";
import {PersonFormComponent} from "./person/person-form.component";
import {RoleListComponent} from "./role/role-list.component";
import {RoleFormComponent} from "./role/role-form.component";
import {PersonViewFormComponent} from "./person/person-view-form.component";
import {PersonUpdateFormComponent} from "./person/person-update-form.component";
import {RoleAddFormComponent} from "./role/role-add-form.component";

const routes:  Routes = [
    {
        path: '',
        component: LoginComponent
    },
    {
        path: 'admin',
        component: AdminDashboardComponent
    },
    {
        path: 'admin/list',
        component: AdminListComponent
    },
    {
        path: 'admin/form',
        component: AdminFormComponent
    },
    {
        path: 'admin/form/:id',
        component: AdminFormComponent
    },
    {
        path: 'user',
        component: PersonListComponent
    },
    {
        path: 'user/form',
        component: PersonFormComponent
    },
    {
        path: 'user/view/:id',
        component: PersonViewFormComponent
    },
    {
        path: 'user/:id',
        component: PersonUpdateFormComponent
    },
    {
        path: 'role',
        component: RoleListComponent
    },
    {
        path: 'role/form/:id',
        component: RoleFormComponent
    },
    {
        path: 'role/form',
        component: RoleAddFormComponent
    }

];

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ]
})

export class AppRoutingModule {}