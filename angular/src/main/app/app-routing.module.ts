import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AdminDashboardComponent } from "./admin/admin-dashboard.component";
import { AdminFormComponent } from "./admin/admin-form.component";
import { AdminListComponent } from "./admin/admin-list.component";
import { LoginComponent } from './login/login.component';
import { PersonListComponent } from './person/person-list.component';
import { RoleListComponent } from './role/role-list.component';

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
        path: 'admin/add',
        component: AdminFormComponent
    },
    {
        path: 'user',
        component: PersonListComponent
    },
    {
        path: 'role',
        component: RoleListComponent
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