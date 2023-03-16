import { TestBed } from '@angular/core/testing';

import { TokeResolverResolver } from './toke-resolver.resolver';

describe('TokeResolverResolver', () => {
  let resolver: TokeResolverResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(TokeResolverResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
