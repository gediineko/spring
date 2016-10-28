import { Component } from '@angular/core';
import {Params, ActivatedRoute} from "@angular/router";
import {Role} from "../mock-data-source/role";
import {RoleService} from "../services/role.service";
import {Location} from "@angular/common";

@Component({
    moduleId: module.id,
    selector: 'admin-form',
    templateUrl: 'admin-form.component.html'
})

export class AdminFormComponent {
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