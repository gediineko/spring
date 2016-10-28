import {Injectable} from "@angular/core";
import {Headers, Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';

import {Contact} from "../mock-data-source/contact";

@Injectable()
export class ContactService {
    private contacrUrl = 'app/contact.json';
    private headers = new Headers({'Content-Type': 'application/json'});

    private handleError(error: any): Promise<any> {
        console.error('An error occurred!', error);
        return Promise.reject(error.message || error);
    }

    constructor(private http: Http) {
    }
}