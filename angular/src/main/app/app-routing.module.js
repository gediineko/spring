"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var admin_dashboard_component_1 = require("./admin/admin-dashboard.component");
var admin_form_component_1 = require("./admin/admin-form.component");
var admin_list_component_1 = require("./admin/admin-list.component");
var login_component_1 = require("./login/login.component");
var person_list_component_1 = require("./person/person-list.component");
var person_form_component_1 = require("./person/person-form.component");
var role_list_component_1 = require("./role/role-list.component");
var role_form_component_1 = require("./role/role-form.component");
var person_view_form_component_1 = require("./person/person-view-form.component");
var person_update_form_component_1 = require("./person/person-update-form.component");
var routes = [
    {
        path: '',
        component: login_component_1.LoginComponent
    },
    {
        path: 'admin',
        component: admin_dashboard_component_1.AdminDashboardComponent
    },
    {
        path: 'admin/list',
        component: admin_list_component_1.AdminListComponent
    },
    {
        path: 'admin/form',
        component: admin_form_component_1.AdminFormComponent
    },
    {
        path: 'user',
        component: person_list_component_1.PersonListComponent
    },
    {
        path: 'user/form',
        component: person_form_component_1.PersonFormComponent
    },
    {
        path: 'user/:id',
        component: person_view_form_component_1.PersonViewFormComponent
    },
    {
        path: 'user/:id',
        component: person_update_form_component_1.PersonUpdateFormComponent
    },
    {
        path: 'role',
        component: role_list_component_1.RoleListComponent
    },
    {
        path: 'role/form/:id',
        component: role_form_component_1.RoleFormComponent
    }
];
var AppRoutingModule = (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        core_1.NgModule({
            imports: [
                router_1.RouterModule.forRoot(routes)
            ],
            exports: [
                router_1.RouterModule
            ]
        }), 
        __metadata('design:paramtypes', [])
    ], AppRoutingModule);
    return AppRoutingModule;
}());
exports.AppRoutingModule = AppRoutingModule;
//# sourceMappingURL=app-routing.module.js.map