import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';

import {Person} from '../mock-data-source/person';

@Injectable()
export class PersonService {
    private personUrl = 'app/person.json';
    private headers = new Headers({'Content-Type': 'application/json'});

    private handleError(error: any): Promise<any> {
        console.error('An error occurred!', error);
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

    getPersonCount(): number {
        return Object.keys(this.personUrl).length;
    }

    createPerson(newPerson: Person): Promise<Person> {
        return this.http
            .post(this.personUrl, JSON.stringify({newPerson: newPerson}), {headers: this.headers})
            .toPromise()
            .then(res => res.json().data)
            .catch(this.handleError);
    }

    deletePerson(id: number): Promise<void> {
        const url = `${this.personUrl}/${id}`;
        return this.http.delete(url, {headers: this.headers})
            .toPromise()
            .then(() => null)
            .catch(this.handleError);
    }

    update(person: Person): Promise<Person> {
        const url = `${this.personUrl}/${person.id}`;
        return this.http
            .put(url, JSON.stringify(person), {headers: this.headers})
            .toPromise()
            .then(() => person)
            .catch(this.handleError);
    }
}