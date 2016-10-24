import {InMemoryDbService} from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService {
    createDb() {
        let person = [
            {
                id: 1,
                username: 'kpmittens',
                titleName: 'Ms.',
                firstName: 'Katy',
                middleName: 'Paws',
                lastName: 'Mittens',
                birthdate: '01/01/2000',
                street: '2000 Furball St.',
                barangay: 'Fishtail',
                city: 'Yarn Ville',
                zipCode: 11163,
                gwa: 1.25,
                currentlyEmployed: true,
                dateHired: '10/24/2016'
            },
            {
                id: 2,
                username: 'scwagtails',
                titleName: 'Mr.',
                firstName: 'Snow',
                middleName: 'Claws',
                lastName: 'Wagtails',
                birthdate: '01/01/1996',
                street: '2108 Catnip St.',
                barangay: 'Fishtail',
                city: 'Yarn Ville',
                zipCode: 11164,
                gwa: 1.50,
                currentlyEmployed: true,
                dateHired: '08/26/2016'
            }
        ];

        let role = [
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

        let contact = [
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

        return {person, role, contact};
    }
}