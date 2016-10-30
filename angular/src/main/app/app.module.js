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
var platform_browser_1 = require("@angular/platform-browser");
var forms_1 = require("@angular/forms");
var http_1 = require("@angular/http");
var core_1 = require("@angular/core");
var app_routing_module_1 = require("./app-routing.module");
var admin_dashboard_component_1 = require("./admin/admin-dashboard.component");
var admin_form_component_1 = require("./admin/admin-form.component");
var admin_list_component_1 = require("./admin/admin-list.component");
var app_component_1 = require("./app.component");
var contact_component_1 = require("./contact/contact.component");
var login_component_1 = require("./login/login.component");
var person_list_component_1 = require("./person/person-list.component");
var role_list_component_1 = require("./role/role-list.component");
var person_form_component_1 = require("./person/person-form.component");
var role_form_component_1 = require("./role/role-form.component");
var person_service_1 = require("./services/person.service");
var role_service_1 = require("./services/role.service");
var angular_in_memory_web_api_1 = require("angular-in-memory-web-api");
var in_memory_data_service_1 = require("./services/in-memory-data.service");
var person_role_list_component_1 = require("./role/person-role-list.component");
var person_view_form_component_1 = require("./person/person-view-form.component");
var person_update_form_component_1 = require("./person/person-update-form.component");
var role_add_form_component_1 = require("./role/role-add-form.component");
var person_add_contactrole_component_1 = require("./person/person-add-contactrole.component");
var contact_service_1 = require("./services/contact.service");
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            imports: [
                app_routing_module_1.AppRoutingModule,
                platform_browser_1.BrowserModule,
                forms_1.FormsModule,
                http_1.HttpModule,
                angular_in_memory_web_api_1.InMemoryWebApiModule.forRoot(in_memory_data_service_1.InMemoryDataService),
                forms_1.ReactiveFormsModule
            ],
            declarations: [
                app_component_1.AppComponent,
                login_component_1.LoginComponent,
                admin_dashboard_component_1.AdminDashboardComponent,
                admin_form_component_1.AdminFormComponent,
                admin_list_component_1.AdminListComponent,
                contact_component_1.ContactComponent,
                person_role_list_component_1.PersonRoleListComponent,
                person_form_component_1.PersonFormComponent,
                person_list_component_1.PersonListComponent,
                person_view_form_component_1.PersonViewFormComponent,
                person_update_form_component_1.PersonUpdateFormComponent,
                person_add_contactrole_component_1.PersonAddContactRoleComponent,
                role_form_component_1.RoleFormComponent,
                role_list_component_1.RoleListComponent,
                role_add_form_component_1.RoleAddFormComponent
            ],
            providers: [
                person_service_1.PersonService,
                role_service_1.RoleService,
                contact_service_1.ContactService
            ],
            bootstrap: [
                app_component_1.AppComponent
            ]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map