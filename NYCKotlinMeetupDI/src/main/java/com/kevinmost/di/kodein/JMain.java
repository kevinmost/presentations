package com.kevinmost.di.kodein;

import com.kevinmost.di.shared.persistence.StringRepository;

import static com.github.salomonbrys.kodein.TypesKt.TT;

// Just to show that Kodein dependencies can be accessed from Java
public class JMain {
    private final StringRepository repo = MainKt.getKodein().Instance(
            // This syntax is weird, but creates a TypeToken internally, so that you can use
            // generic class bindings from Java (where generics are erased)
            TT(StringRepository.class),
            null
    );

    private JMain() {
        repo.save("Called from Java!");
        for (String line : repo.loadAll()) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        new JMain();
    }
}
