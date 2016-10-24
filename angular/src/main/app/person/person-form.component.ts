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

export class PersonFormComponent {

    @Input()
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
        this.route.params.forEach((params: Params) => {
            let id = +params['id'];
            this.personService.getPerson(id)
                .then(person => this.person = person);
        });
    }
}