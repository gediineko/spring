import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {Person} from "../mock-data-source/person";
import {PersonService} from "../services/person.service";

@Component({
    moduleId: module.id,
    selector: 'person-list',
    templateUrl: 'person-list.component.html'
})

export class PersonListComponent implements OnInit {
    personList: Person[];
    selectedPerson: Person;

    constructor(private personService: PersonService,
                private router: Router) {
    }

    ngOnInit(): void {
        this.getPersonList();
    }

    getPersonList(): void {
        this.personService.getPersonList()
            .then(personList => this.personList = personList);
    }

    gotoView(): void {
        this.router.navigate(['/user', this.selectedPerson.id]);
    }

    onSelect(person: Person): void {
        this.selectedPerson = person;
    }

}