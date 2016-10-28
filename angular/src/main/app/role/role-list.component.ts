import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {Role} from "../mock-data-source/role";
import {RoleService} from "../services/role.service";

@Component({
    moduleId: module.id,
    selector: 'role-list',
    templateUrl: 'role-list.component.html'
})

export class RoleListComponent implements OnInit {
    roleList: Role[];

    constructor(private roleService: RoleService,
                private router: Router) {
    }

    ngOnInit(): void {
        this.getRoleList();
    }

    getRoleList(): void {
        this.roleService.getRoleList()
            .then(roleList => this.roleList = roleList);
    }


}