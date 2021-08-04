import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';
import { Claim } from './claim';
import { ClaimService } from './claim.service';

describe('ClaimService', () => {
  let service: ClaimService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ClaimService]
    });
    service = TestBed.inject(ClaimService);
  });

  it('can load instance', () => {
    expect(service).toBeTruthy();
  });

  describe('claimStatus', () => {
    it('makes expected calls', () => {
      const httpTestingController = TestBed.inject(HttpTestingController);
      const claimStub: Claim = <any>{};
      sessionStorage.setItem('token',JSON.stringify({
        "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyNzgzOTIxMywiaWF0IjoxNjI3ODM4MzEzfQ.Fwrx_YWV8NxDZ58pvA7SQvVjCn7h2cjxpeB8TY-tXcY",
        "valid": true
    }));
      service.claimStatus(claimStub).subscribe(res => {
        expect(res).toEqual(claimStub);
      });
      const req = httpTestingController.expectOne('HTTP_ROUTE_GOES_HERE');
      expect(req.request.method).toEqual('GET');
      req.flush(claimStub);
      httpTestingController.verify();
    });
  });
});
