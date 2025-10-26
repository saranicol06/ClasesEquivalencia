package edu.unisabana.tyvs.service;

import edu.unisabana.tyvs.model.*;

import java.util.HashSet;
import java.util.Set;

public class Registry {

    private final Set<Integer> registeredIds = new HashSet<>();
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 120;

    public RegisterResult registerVoter(Person p) {
        if (p == null) return RegisterResult.INVALID;
        if (p.getId() <= 0) return RegisterResult.INVALID;
        if (!p.isAlive()) return RegisterResult.DEAD;
        if (p.getAge() < 0 || p.getAge() > MAX_AGE) return RegisterResult.INVALID_AGE;
        if (p.getAge() < MIN_AGE) return RegisterResult.UNDERAGE;
        if (registeredIds.contains(p.getId())) return RegisterResult.DUPLICATED;
        if (p.getAge()<18){
            return RegisterResult.UNDERAGE;
        }

        registeredIds.add(p.getId());
        return RegisterResult.VALID;
    }
}
