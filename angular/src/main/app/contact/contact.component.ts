import {Component, OnInit} from "@angular/core";
import {ContactService} from "../services/contact.service";
import {Contact} from "../mock-data-source/contact";
import {Person} from "../mock-data-source/person";
import {Input} from "@angular/core/src/metadata/directives";
import {Params, ActivatedRoute} from "@angular/router";
import {PersonService} from "../services/person.service";

@Component({
    moduleId: module.id,
    selector: 'contact-info-list',
    templateUrl: 'contact.component.html'
})

export class ContactComponent implements OnInit {

    person: Person;

    contactList: Contact[];

    constructor(
        private contactService: ContactService,
        private personService: PersonService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit(): void {
        this.getContactList();
    }

    getContactList(): void {
        this.contactService.getContactList()
            .then(contactList => this.contactList = contactList
                .filter(c => c.personId === 1));
    }
}