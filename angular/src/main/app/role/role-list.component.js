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
var role_service_1 = require("../services/role.service");
var RoleListComponent = (function () {
    function RoleListComponent(roleService, router) {
        this.roleService = roleService;
        this.router = router;
    }
    RoleListComponent.prototype.ngOnInit = function () {
        this.getRoleList();
    };
    RoleListComponent.prototype.getRoleList = function () {
        var _this = this;
        this.roleService.getRoleList()
            .then(function (roleList) { return _this.roleList = roleList; });
    };
    RoleListComponent.prototype.gotoView = function () {
        this.router.navigate(['/role/form', this.selectedRole.id]);
    };
    RoleListComponent.prototype.onSelect = function (role) {
        this.selectedRole = role;
    };
    RoleListComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'role-list',
            templateUrl: 'role-list.component.html'
        }), 
        __metadata('design:paramtypes', [role_service_1.RoleService, router_1.Router])
    ], RoleListComponent);
    return RoleListComponent;
}());
exports.RoleListComponent = RoleListComponent;
//# sourceMappingURL=role-list.component.js.map