import {Component, OnInit} from "@angular/core";
import {Person} from "../mock-data-source/person";
import {Params, ActivatedRoute} from "@angular/router";
import {PersonService} from "../services/person.service";

@Component({
    moduleId: module.id,
    selector: 'person-add-contactrole',
    templateUrl: 'person-add-contactrole.component.html'
})

export class PersonAddContactRoleComponent implements OnInit {

    person: Person;

    constructor(
        private personService: PersonService,
        private route: ActivatedRoute
    ) {}

    ngOnInit(): void {
        this.route.params.forEach((params: Params) => {
            let id = +params['id'];
            this.personService.getPerson(id)
                .then(person => this.person = person);
        });
    }
}