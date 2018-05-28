import { TestBed, inject } from '@angular/core/testing';

import { MortierService } from './mortier.service';

describe('MortierService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MortierService]
    });
  });

  it('should be created', inject([MortierService], (service: MortierService) => {
    expect(service).toBeTruthy();
  }));
});
