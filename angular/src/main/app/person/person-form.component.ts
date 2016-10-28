import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import {Person} from "../mock-data-source/person";
import {PersonService} from "../services/person.service";

@Component({
    moduleId: module.id,
    selector: 'person-form',
    templateUrl: 'person-form.component.html'
})

export class PersonFormComponent implements OnInit {

    newPerson: Person;

    constructor(
        private personService: PersonService,
        private route: ActivatedRoute,
        private location: Location
    ) { }

    goBack(): void {
        this.location.back();
    }

    ngOnInit(): void {
    }

    onSubmit(newPerson: Person): void {
        this.newPerson.username = newPerson.username;
        this.newPerson.titleName = newPerson.titleName;
        this.newPerson.firstName = newPerson.firstName;
        this.newPerson.middleName = newPerson.middleName;
        this.newPerson.lastName = newPerson.lastName;
        this.newPerson.street = newPerson.street;
        this.newPerson.barangay = newPerson.barangay;
        this.newPerson.city = newPerson.city;
        this.newPerson.zipCode = newPerson.zipCode;
        this.newPerson.gwa = newPerson.gwa;
        this.newPerson.currentlyEmployed = newPerson.currentlyEmployed;
        this.personService.createPerson(newPerson);
    }
}