import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';
import { Submit } from './submit';
import { SubmitService } from './submit.service';

describe('SubmitService', () => {
  let service: SubmitService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [SubmitService]
    });
    service = TestBed.inject(SubmitService);
  });

  it('can load instance', () => {
    expect(service).toBeTruthy();
  });

  describe('submitClaim', () => {
    it('makes expected calls', () => {
      const httpTestingController = TestBed.inject(HttpTestingController);
      const submitStub: Submit = <any>{};
      sessionStorage.setItem('token',JSON.stringify({
        "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyNzgzOTIxMywiaWF0IjoxNjI3ODM4MzEzfQ.Fwrx_YWV8NxDZ58pvA7SQvVjCn7h2cjxpeB8TY-tXcY",
        "valid": true
    }));
      service.submitClaim(submitStub).subscribe(res => {
        expect(res).toEqual(submitStub);
      });
      const req = httpTestingController.expectOne('HTTP_ROUTE_GOES_HERE');
      expect(req.request.method).toEqual('POST');
      req.flush(submitStub);
      httpTestingController.verify();
    });
  });
});
