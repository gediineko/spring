import {Component, Input, OnInit} from "@angular/core";
import {Router, ActivatedRoute, Params} from "@angular/router";
import {Person} from "../mock-data-source/person";
import {PersonService} from "../services/person.service";

@Component({
    moduleId: module.id,
    selector: 'person-update-form',
    templateUrl: 'person-update-form.component.html'
})

export class PersonUpdateFormComponent implements OnInit {

    @Input()
    person: Person;

    private isAdd: boolean;
    private isView: boolean;
    private isUpdate: boolean;

    constructor(
        private personService: PersonService,
        private route: ActivatedRoute
    ) { }

    ngOnInit(): void {
        this.route.params.forEach((params: Params) => {
            let id = +params['id'];
            this.personService.getPerson(id)
                .then(person => this.person = person);
        });
    }
}