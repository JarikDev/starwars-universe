package cmd.starwars.universe.model.enums;

import lombok.Getter;

import java.util.List;

@Getter
public enum StarSystems {
    CORUSCANT_SYSTEM("Coruscant System", List.of(Planets.CORUSCANT, Planets.CENTAX_1, Planets.HESPERIDIUM)),
    ALDERAAN_SYSTEM("Alderaan System", List.of(Planets.ALDERAAN, Planets.DELAYA)),
    CORELLIA_SYSTEM("Corellia System", List.of(Planets.CORELLIA, Planets.DRALL, Planets.TALUS_AND_TRALUS)),
    KUAT_SYSTEM("Kuat System", List.of(Planets.KUAT, Planets.KUAT_IV)),
    CHANDRILA_SYSTEM("Chandrila System", List.of(Planets.CHANDRILA)),
    BRENTAAL_SYSTEM("Brentaal System", List.of(Planets.BRENTAAL_IV)),
    ANAXES_SYSTEM("Anaxes System", List.of(Planets.ANAXES)),
    NABOO_SYSTEM("Naboo System", List.of(Planets.NABOO, Planets.RORI, Planets.OHMA_D_UN)),
    TATOOINE_SYSTEM("Tatooine System", List.of(Planets.TATOOINE)),
    KASHYYYK_SYSTEM("Kashyyyk System", List.of(Planets.KASHYYYK, Planets.TRANDOSHA)),
    ENDOR_SYSTEM("Endor System", List.of(Planets.ENDOR, Planets.KEF_BIR)),
    BESPIN_SYSTEM("Bespin System", List.of(Planets.BESPIN)),
    HOTH_SYSTEM("Hoth System", List.of(Planets.HOTH)),
    DAGOBAH_SYSTEM("Dagobah System", List.of(Planets.DAGOBAH)),
    GEONOSIS_SYSTEM("Geonosis System", List.of(Planets.GEONOSIS)),
    UTAPAU_SYSTEM("Utapau System", List.of(Planets.UTAPAU)),
    FELUCIA_SYSTEM("Felucia System", List.of(Planets.FELUCIA)),
    MYGEETO_SYSTEM("Mygeeto System", List.of(Planets.MYGEETO)),
    MANDALORE_SYSTEM("Mandalore System", List.of(Planets.MANDALORE, Planets.CONCORDIA)),
    DATHOMIR_SYSTEM("Dathomir System", List.of(Planets.DATHOMIR)),
    KAMINO_SYSTEM("Kamino System", List.of(Planets.KAMINO)),
    MUSTAFAR_SYSTEM("Mustafar System", List.of(Planets.MUSTAFAR)),
    JAKKU_SYSTEM("Jakku System", List.of(Planets.JAKKU)),
    EXEGOL_SYSTEM("Exegol System", List.of(Planets.EXEGOL)),
    SCARIF_SYSTEM("Scarif System", List.of(Planets.SCARIF)),
    LOTHAL_SYSTEM("Lothal System", List.of(Planets.LOTHAL)),
    ORD_MANTELL_SYSTEM("Ord Mantell System", List.of(Planets.ORD_MANTELL)),
    MIMBAN_SYSTEM("Mimban System", List.of(Planets.MIMBAN)),
    MALACHOR_SYSTEM("Malachor System", List.of(Planets.MALACHOR_V)),
    RYLOTH_SYSTEM("Ryloth System", List.of(Planets.RYLOTH)),
    ILUM_SYSTEM("Ilum System", List.of(Planets.ILUM)),
    AHCH_TO_SYSTEM("Ahch-To System", List.of(Planets.AHCH_TO)),
    CSILLA_SYSTEM("Csilla System", List.of(Planets.CSILLA)),
    PERIDEA_SYSTEM("Peridea System", List.of(Planets.PERIDEA)),
    ZYGERRIA_SYSTEM("Zygerria System", List.of(Planets.ZYGERRIA)),
    NAL_HUTTA_SYSTEM("Nal Hutta System", List.of(Planets.NAL_HUTTA, Planets.NAR_SHADDAA)),
    KORRIBAN_SYSTEM("Korriban System", List.of(Planets.KORRIBAN)),
    DROMUND_KAAS_SYSTEM("Dromund Kaas System", List.of(Planets.DROMUND_KAAS)),
    BYSS_SYSTEM("Byss System", List.of(Planets.BYSS)),
    YAVIN_SYSTEM("Yavin System", List.of(Planets.YAVIN_PRIME, Planets.YAVIN_IV)),
    ONDERON_SYSTEM("Onderon System", List.of(Planets.ONDERON)),
    TELOS_SYSTEM("Telos System", List.of(Planets.TELOS_IV));

    private final String name;
    private final List<Planets> planets;

    StarSystems(String name, List<Planets> planets) {
        this.name = name;
        this.planets = planets;
    }
}
