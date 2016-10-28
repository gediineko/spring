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
var person_service_1 = require("../services/person.service");
var PersonListComponent = (function () {
    function PersonListComponent(personService, router) {
        this.personService = personService;
        this.router = router;
    }
    PersonListComponent.prototype.ngOnInit = function () {
        this.getPersonList();
    };
    PersonListComponent.prototype.getPersonList = function () {
        var _this = this;
        this.personService.getPersonList()
            .then(function (personList) { return _this.personList = personList; });
    };
    PersonListComponent.prototype.gotoView = function () {
        this.router.navigate(['/user/view', this.selectedPerson.id]);
    };
    PersonListComponent.prototype.onSelect = function (person) {
        this.selectedPerson = person;
    };
    PersonListComponent.prototype.delete = function (person) {
        var _this = this;
        this.personService.deletePerson(person.id)
            .then(function () {
            _this.personList = _this.personList.filter(function (p) { return p !== person; });
            if (_this.selectedPerson === person) {
                _this.selectedPerson = null;
            }
        });
    };
    PersonListComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'person-list',
            templateUrl: 'person-list.component.html'
        }), 
        __metadata('design:paramtypes', [person_service_1.PersonService, router_1.Router])
    ], PersonListComponent);
    return PersonListComponent;
}());
exports.PersonListComponent = PersonListComponent;
//# sourceMappingURL=person-list.component.js.map