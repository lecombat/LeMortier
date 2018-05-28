import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MortierComponent } from './mortier.component';

describe('MortierComponent', () => {
  let component: MortierComponent;
  let fixture: ComponentFixture<MortierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MortierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MortierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
