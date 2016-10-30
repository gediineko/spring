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
var contact_service_1 = require("../services/contact.service");
var router_1 = require("@angular/router");
var person_service_1 = require("../services/person.service");
var ContactComponent = (function () {
    function ContactComponent(contactService, personService, route) {
        this.contactService = contactService;
        this.personService = personService;
        this.route = route;
    }
    ContactComponent.prototype.ngOnInit = function () {
        this.getContactList();
    };
    ContactComponent.prototype.getContactList = function () {
        var _this = this;
        this.contactService.getContactList()
            .then(function (contactList) { return _this.contactList = contactList
            .filter(function (c) { return c.personId === 1; }); });
    };
    ContactComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'contact-info-list',
            templateUrl: 'contact.component.html'
        }), 
        __metadata('design:paramtypes', [contact_service_1.ContactService, person_service_1.PersonService, router_1.ActivatedRoute])
    ], ContactComponent);
    return ContactComponent;
}());
exports.ContactComponent = ContactComponent;
//# sourceMappingURL=contact.component.js.map