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
var core_1 = require('@angular/core');
var router_1 = require("@angular/router");
var role_service_1 = require("../services/role.service");
var common_1 = require("@angular/common");
var RoleFormComponent = (function () {
    function RoleFormComponent(route, roleService, location) {
        this.route = route;
        this.roleService = roleService;
        this.location = location;
    }
    RoleFormComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.params.forEach(function (params) {
            var id = +params['id'];
            _this.roleService.getRole(id)
                .then(function (role) { return _this.role = role; });
        });
    };
    RoleFormComponent.prototype.goBack = function () {
        this.location.back();
    };
    RoleFormComponent.prototype.save = function () {
        var _this = this;
        this.roleService.update(this.role)
            .then(function () { return _this.goBack(); });
    };
    RoleFormComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'role-form',
            templateUrl: 'role-form.component.html'
        }), 
        __metadata('design:paramtypes', [router_1.ActivatedRoute, role_service_1.RoleService, common_1.Location])
    ], RoleFormComponent);
    return RoleFormComponent;
}());
exports.RoleFormComponent = RoleFormComponent;
//# sourceMappingURL=role-form.component.js.map