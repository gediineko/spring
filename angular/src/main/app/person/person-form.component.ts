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

    person: Person;

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

    onSubmit(): void {

    }
}