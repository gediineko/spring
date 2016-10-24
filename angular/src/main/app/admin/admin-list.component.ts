import {Component, OnInit} from "@angular/core";
import {Role} from "../mock-data-source/role";
import {RoleService} from "../services/role.service";
@Component({
    moduleId: module.id,
    selector: 'admin-list',
    templateUrl: 'admin-list.component.html'
})

export class AdminListComponent implements OnInit {
    adminList: Role[];

    constructor(private roleService: RoleService) {
    }

    ngOnInit(): void {
        this.getAdminList();
    }

    getAdminList(): void {
        this.roleService.getRoleList()
    .then(adminList => this.adminList = adminList.filter(a => a.roleType === 'ADMIN'));
    }

}