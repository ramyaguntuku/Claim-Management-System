import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';
import { User } from './user';
import { RegistrationService } from './registration.service';

describe('RegistrationService', () => {
  let service: RegistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [RegistrationService]
    });
    service = TestBed.inject(RegistrationService);
  });

  it('can load instance', () => {
    expect(service).toBeTruthy();
  });

  describe('loginUserFormRemote', () => {
    it('makes expected calls', () => {
      const httpTestingController = TestBed.inject(HttpTestingController);
      const userStub: User = <any>{};
      service.loginUserFormRemote(userStub).subscribe(res => {
        expect(res).toEqual(userStub);
      });
      const req = httpTestingController.expectOne(
        'http://localhost:8089/authorization/login'
      );
      expect(req.request.method).toEqual('POST');
      req.flush(userStub);
      httpTestingController.verify();
    });
  });
});
