import {Component, OnInit} from "@angular/core";
import {Role} from "../mock-data-source/role";
import {RoleService} from "../services/role.service";
import {Router} from "@angular/router";
@Component({
    moduleId: module.id,
    selector: 'admin-list',
    templateUrl: 'admin-list.component.html'
})

export class AdminListComponent implements OnInit {
    adminList: Role[];
    selectedAdmin: Role;

    constructor(
        private roleService: RoleService,
        private router: Router
    ) {
    }

    ngOnInit(): void {
        this.getAdminList();
    }

    getAdminList(): void {
        this.roleService.getRoleList()
    .then(adminList => this.adminList = adminList.filter(a => a.roleType === 'ADMIN'));
    }

    gotoView(): void {
        this.router.navigate(['/admin/form', this.selectedAdmin.id]);
    }

    onSelect(admin: Role): void {
        this.selectedAdmin = admin;
    }

    delete(admin: Role): void {
        this.roleService.deleteRole(admin.id)
            .then(() => {
                this.adminList= this.adminList.filter(a => a !== admin);
                if (this.selectedAdmin === admin) {
                    this.selectedAdmin = null;
                }
            });
    }

}