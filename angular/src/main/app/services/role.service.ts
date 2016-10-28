import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';

import {Role} from '../mock-data-source/role';

@Injectable()
export class RoleService {
    private roleUrl = 'app/role.json';
    private headers = new Headers({'Content-Type': 'application/json'});

    private handleError(error: any): Promise<any> {
        console.error('An error occured!', error);
        return Promise.reject(error.message || error);
    }

    constructor(private http: Http) {
    }

    getRoleList(): Promise<Role[]> {
        return this.http.get(this.roleUrl)
            .toPromise()
            .then(response => response.json().data as Role[])
            .catch(this.handleError);
    }

    getRole(id: number): Promise<Role> {
        return this.getRoleList()
            .then(role => role.find(role=> role.id === id));
    }

    update(role: Role): Promise<Role> {
        const url = `${this.roleUrl}/${role.id}`;
        return this.http
            .put(url, JSON.stringify(role), {headers: this.headers})
            .toPromise()
            .then(() => role)
            .catch(this.handleError);
    }
}