package com.rouclec.securityjwt.Mappers;

public interface Mapper<A,B> {
    B mapTo(A a);

    A MapFrom(B b);
}
