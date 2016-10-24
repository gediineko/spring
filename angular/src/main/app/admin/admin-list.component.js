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
var role_service_1 = require("../services/role.service");
var AdminListComponent = (function () {
    function AdminListComponent(roleService) {
        this.roleService = roleService;
    }
    AdminListComponent.prototype.ngOnInit = function () {
        this.getAdminList();
    };
    AdminListComponent.prototype.getAdminList = function () {
        var _this = this;
        this.roleService.getRoleList()
            .then(function (adminList) { return _this.adminList = adminList.filter(function (a) { return a.roleType === 'ADMIN'; }); });
    };
    AdminListComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'admin-list',
            templateUrl: 'admin-list.component.html'
        }), 
        __metadata('design:paramtypes', [role_service_1.RoleService])
    ], AdminListComponent);
    return AdminListComponent;
}());
exports.AdminListComponent = AdminListComponent;
//# sourceMappingURL=admin-list.component.js.map