import { Component } from '@angular/core';
import {Router, ActivatedRoute, Params} from "@angular/router";
import {RoleService} from "../services/role.service";
import {Role} from "../mock-data-source/role";
import {Location} from "@angular/common";

@Component({
    moduleId: module.id,
    selector: 'role-form',
    templateUrl: 'role-form.component.html'
})

export class RoleFormComponent {

    role: Role;

    constructor(
        private route: ActivatedRoute,
        private roleService: RoleService,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.route.params.forEach((params: Params) => {
            let id = +params['id'];
            this.roleService.getRole(id)
                .then(role => this.role = role);
        });
    }

    goBack(): void {
        this.location.back();
    }

    save(): void {
        this.roleService.update(this.role)
            .then(() => this.goBack());
    }

}