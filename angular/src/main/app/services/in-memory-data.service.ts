import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService {
    createDb() {
        let data = {
            person: [
                {
                    id: 1,
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
                    dateHired: '10/25/2016'
                }
            ]
        }
        return {data};
    }
}