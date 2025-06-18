package cmd.starwars.universe.model.enums;

import lombok.Getter;

@Getter
public enum Planets {
    CORUSCANT("Coruscant"),
    CENTAX_1("Centax-1"),
    HESPERIDIUM("Hesperidium"),
    ALDERAAN("Alderaan"),
    DELAYA("Delaya"),
    CORELLIA("Corellia"),
    DRALL("Drall"),
    TALUS_AND_TRALUS("Talus & Tralus"),
    KUAT("Kuat"),
    KUAT_IV("Kuat IV"),
    CHANDRILA("Chandrila"),
    BRENTAAL_IV("Brentaal IV"),
    ANAXES("Anaxes"),
    NABOO("Naboo"),
    RORI("Rori"),
    OHMA_D_UN("Ohma-D'un"),
    TATOOINE("Tatooine"),
    GEONOSIS("Geonosis"),
    KASHYYYK("Kashyyyk"),
    TRANDOSHA("Trandosha"),
    ENDOR("CorusEndorcant"),
    KEF_BIR("Kef Bir"),
    BESPIN("Bespin"),
    HOTH("Hoth"),
    DAGOBAH("Dagobah"),
    UTAPAU("Utapau"),
    FELUCIA("Felucia"),
    MYGEETO("Mygeeto"),
    MANDALORE("Mandalore"),
    CONCORDIA("Concordia"),
    DATHOMIR("Dathomir"),
    KAMINO("Kamino"),
    MUSTAFAR("Mustafar"),
    JAKKU("Jakku"),
    EXEGOL("Exegol"),
    SCARIF("Scarif"),
    LOTHAL("Lothal"),
    ORD_MANTELL("Ord Mantell"),
    MIMBAN("Mimban"),
    MALACHOR_V("Malachor V"),
    RYLOTH("Ryloth"),
    ILUM("Ilum"),
    AHCH_TO("Ahch-To"),
    CSILLA("Csilla"),
    PERIDEA("Peridea"),
    ZYGERRIA("Zygerria"),
    NAL_HUTTA("Nal Hutta"),
    NAR_SHADDAA("Nar Shaddaa"),
    KORRIBAN("Korriban"),
    DROMUND_KAAS("Dromund Kaas"),
    BYSS("Byss"),
    YAVIN_PRIME("Yavin Prime"),
    YAVIN_IV("Yavin IV"),
    ONDERON("Onderon"),
    TELOS_IV("Telos IV");

    private final String name;

    Planets(String name) {
        this.name = name;
    }
}
