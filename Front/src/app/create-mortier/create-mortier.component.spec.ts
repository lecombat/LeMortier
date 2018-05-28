import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMortierComponent } from './create-mortier.component';

describe('CreateMortierComponent', () => {
  let component: CreateMortierComponent;
  let fixture: ComponentFixture<CreateMortierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateMortierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateMortierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
