import {Component, OnInit} from "@angular/core";
import {RoleService} from "../services/role.service";
import {Role} from "../mock-data-source/role";
import {Input} from "@angular/core/src/metadata/directives";

@Component({
    moduleId: module.id,
    selector: 'person-role-list',
    templateUrl: 'person-role-list.component.html'
})

export class PersonRoleListComponent implements OnInit {

    // @Input()
    // roleId: number;

    personRoleList: Role[];

    constructor(
       private roleService: RoleService
    ) {}

    ngOnInit(): void {

    }

    getPersonRoleList(): void {
        // this.roleService.getRoleList()
        //     .then(personRoleList =>
        //         this.personRoleList = personRoleList.filter(r => r.id === this.roleId));
    }
}