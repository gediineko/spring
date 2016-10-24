import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';

import {Person} from '../mock-data-source/person';

@Injectable()
export class PersonService {
    private personUrl = 'app/person.json';
    private headers = new Headers({'Content-Type': 'application/json'});

    private handleError(error: any): Promise<any> {
        console.error('An error occured!', error);
        return Promise.reject(error.message || error);
    }

    constructor(private http: Http) {
    }

    getPersonList(): Promise<Person[]> {
        return this.http.get(this.personUrl)
            .toPromise()
            .then(response => response.json().data as Person[])
            .catch(this.handleError);
    }

    getPerson(id: number): Promise<Person> {
        return this.getPersonList()
            .then(person => person.find(person => person.id === id));
    }
}