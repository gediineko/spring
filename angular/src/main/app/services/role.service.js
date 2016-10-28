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
var http_1 = require('@angular/http');
require('rxjs/add/operator/toPromise');
var RoleService = (function () {
    function RoleService(http) {
        this.http = http;
        this.roleUrl = 'app/role.json';
        this.headers = new http_1.Headers({ 'Content-Type': 'application/json' });
    }
    RoleService.prototype.handleError = function (error) {
        console.error('An error occured!', error);
        return Promise.reject(error.message || error);
    };
    RoleService.prototype.getRoleList = function () {
        return this.http.get(this.roleUrl)
            .toPromise()
            .then(function (response) { return response.json().data; })
            .catch(this.handleError);
    };
    RoleService.prototype.getRole = function (id) {
        return this.getRoleList()
            .then(function (role) { return role.find(function (role) { return role.id === id; }); });
    };
    RoleService.prototype.update = function (role) {
        var url = this.roleUrl + "/" + role.id;
        return this.http
            .put(url, JSON.stringify(role), { headers: this.headers })
            .toPromise()
            .then(function () { return role; })
            .catch(this.handleError);
    };
    RoleService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], RoleService);
    return RoleService;
}());
exports.RoleService = RoleService;
//# sourceMappingURL=role.service.js.map