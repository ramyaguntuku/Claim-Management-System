import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';
import { Member } from './member';
import { MemberService } from './member.service';

describe('MemberService', () => {
  let service: MemberService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [MemberService]
    });
    service = TestBed.inject(MemberService);
  });

  it('can load instance', () => {
    expect(service).toBeTruthy();
  });

  describe('memberForm', () => {
    it('makes expected calls', () => {
      const httpTestingController = TestBed.inject(HttpTestingController);
      const memberStub: Member = <any>{};
      sessionStorage.setItem('token',JSON.stringify({
        "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyNzgzOTIxMywiaWF0IjoxNjI3ODM4MzEzfQ.Fwrx_YWV8NxDZ58pvA7SQvVjCn7h2cjxpeB8TY-tXcY",
        "valid": true
    }));
      service.memberForm(memberStub).subscribe(res => {
   //     expect(res).toEqual(memberStub);
      });
      const req = httpTestingController.expectOne('HTTP_ROUTE_GOES_HERE');
      expect(req.request.method).toEqual('GET');
      req.flush(memberStub);
      httpTestingController.verify();
    });
  });
});
