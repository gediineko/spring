import {Component, OnInit} from "@angular/core";
import {Params, ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";
import {PersonService} from "../services/person.service";
import {Person} from "../mock-data-source/person";

@Component({
    moduleId: module.id,
    selector: 'person-view-form',
    templateUrl: 'person-view-form.component.html'
})

export class PersonViewFormComponent implements OnInit {

    person: Person;

    constructor(
        private route: ActivatedRoute,
        private personService: PersonService,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.route.params.forEach((params: Params) => {
            let id = +params['id'];
            this.personService.getPerson(id)
                .then(person => this.person = person);
        });
    }

    goBack(): void {
        this.location.back();
    }

    save(): void {
        this.personService.update(this.person)
            .then(() => this.goBack());
    }
}