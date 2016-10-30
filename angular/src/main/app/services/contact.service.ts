import {Injectable} from "@angular/core";
import {Headers, Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';

import {Contact} from "../mock-data-source/contact";

@Injectable()
export class ContactService {
    private contactUrl = 'app/contact.json';
    private headers = new Headers({'Content-Type': 'application/json'});

    private handleError(error: any): Promise<any> {
        console.error('An error occurred!', error);
        return Promise.reject(error.message || error);
    }

    constructor(private http: Http) {

    }

    getContactList(): Promise<Contact[]> {
        return this.http.get(this.contactUrl)
            .toPromise()
            .then(response => response.json().data as Contact[])
            .catch(this.handleError);
    }

    getPersonContact(personId: number): Promise<Contact> {
        return this.getContactList()
            .then(contact => contact.find(contact => contact.personId === personId));
    }
}