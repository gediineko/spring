"use strict";
var InMemoryDataService = (function () {
    function InMemoryDataService() {
    }
    InMemoryDataService.prototype.createDb = function () {
        var person = [
            {
                id: 1,
                username: 'kpmittens',
                titleName: 'Ms.',
                firstName: 'Katy',
                middleName: 'Paws',
                lastName: 'Mittens',
                suffix: 'IV',
                street: '2000 Furball St.',
                barangay: 'Fishtail',
                city: 'Yarn Ville',
                zipCode: 11163,
                gwa: 2,
                currentlyEmployed: true,
            },
            {
                id: 2,
                username: 'scwagtails',
                titleName: 'Mr.',
                firstName: 'Snow',
                middleName: '',
                lastName: 'Wagtails',
                suffix: 'III',
                street: '2108 Catnip St.',
                barangay: 'Fishtail',
                city: 'Yarn Ville',
                zipCode: 11164,
                gwa: 5,
                currentlyEmployed: true,
            }
        ];
        var role = [
            {
                id: 1,
                roleType: 'ADMIN',
                roleName: 'Captain Kitty'
            },
            {
                id: 2,
                roleType: 'USER',
                roleName: 'Mice Catcher'
            },
            {
                id: 3,
                roleType: 'USER',
                roleName: 'Purr master'
            }
        ];
        var roletype = [
            {
                name: 'USER'
            },
            {
                name: 'ADMIN'
            }
        ];
        var contact = [
            {
                id: 1,
                personId: 1,
                contactType: 'Landline',
                contactInfo: '763-2341'
            },
            {
                id: 2,
                personId: 1,
                contactType: 'Email',
                contactInfo: 'kpmittens@cadoodle.com'
            },
            {
                id: 3,
                personId: 2,
                contactType: 'Email',
                contactInfo: 'scwagtails.cadoodle.com'
            }
        ];
        return { person: person, role: role, roletype: roletype, contact: contact };
    };
    return InMemoryDataService;
}());
exports.InMemoryDataService = InMemoryDataService;
//# sourceMappingURL=in-memory-data.service.js.map