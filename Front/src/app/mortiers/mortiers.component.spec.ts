import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MortiersComponent } from './mortiers.component';

describe('MortiersComponent', () => {
  let component: MortiersComponent;
  let fixture: ComponentFixture<MortiersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MortiersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MortiersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
