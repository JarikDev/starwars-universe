package cmd.starwars.universe.model.enums;

import lombok.Getter;

@Getter
public enum Heroes {
    JEDI_MASTER_YODA("Yoda", UnitClasses.JEDI_MASTER),
    JEDI_MASTER_MACE_WINDU("Mace Windu", UnitClasses.JEDI_MASTER),
    JEDI_MASTER_OBI_WAN_KENOBI("Obi-Wan Kenobi", UnitClasses.JEDI_MASTER),
    JEDI_ANAKIN_SKYWALKER("Jedi Anakin Skywalker", UnitClasses.JEDI_KNIGHT),
    JEDI_A_SHARAD_HETT("Jedi A'Sharad Hett", UnitClasses.JEDI_KNIGHT),
    JEDI_PADAWAN_AHSOKA_TANO("Jedi Padawan Ahsoka Tano", UnitClasses.JEDI_PADAWAN),
    JEDI_MASTER_KIT_FISTO("Jedi Master Kit Fisto", UnitClasses.JEDI_MASTER),
    JEDI_MASTER_EVEN_PIELL("Jedi Master Even Piell", UnitClasses.JEDI_MASTER),
    JEDI_MASTER_KI_ADI_MUNDI("Jedi Master Ki-Adi-Mundi", UnitClasses.JEDI_MASTER),
    JEDI_MASTER_SHAAK_TI("Jedi Master Shaak Ti", UnitClasses.JEDI_MASTER),
    JEDI_MASTER_AAYLA_SECURA("Jedi Master Aayla Secura", UnitClasses.JEDI_MASTER),
    JEDI_MASTER_TIPLEE("Jedi Master Tiplee", UnitClasses.JEDI_MASTER),
    JEDI_MASTER_LUMINARA_UNDULI("Jedi Master Luminara Unduli", UnitClasses.JEDI_MASTER),
    JEDI_PADAWAN_BARRISS_OFFEE("Jedi Padawan Barriss Offee", UnitClasses.JEDI_PADAWAN),
    JEDI_MASTER_QUINLAN_VOS("Jedi Master Quinlan Vos", UnitClasses.JEDI_MASTER),
    JEDI_MASTER_DEPA_BILLABA("Jedi Master Depa Billaba", UnitClasses.JEDI_MASTER),
    JEDI_MASTER_RAHM_KOTA("Jedi Master Rahm Kota", UnitClasses.JEDI_MASTER),
    CLONE_TROOPER_CAPTAIN_REX("Clone Trooper Captain Rex", UnitClasses.CLONE_COMMANDO),
    CLONE_TROOPER_COMMANDER_CODY("Clone Trooper Commander Cody", UnitClasses.CLONE_COMMANDO),
    CLONE_TROOPER_COMMANDER_WOLFFE("Clone Trooper Commander Wolffe", UnitClasses.CLONE_COMMANDO),
    CLONE_TROOPER_COMMANDER_GREE("Clone Trooper Commander Gree", UnitClasses.CLONE_COMMANDO),
    CLONE_TROOPER_COMMANDER_BLY("Clone Trooper Commander Bly", UnitClasses.CLONE_COMMANDO),
    CLONE_TROOPER_FIVES("Clone Trooper Fives", UnitClasses.CLONE_COMMANDO),
    CLONE_TROOPER_ECHO("Clone Trooper Echo", UnitClasses.CLONE_COMMANDO),
    CLONE_TROOPER_HEVY("Clone Trooper Hevy", UnitClasses.CLONE_COMMANDO),
    CLONE_TROOPER_99("Clone Trooper 99", UnitClasses.CLONE_COMMANDO),
    CLONE_TROOPER_HARDCASE("Clone Trooper Hardcase", UnitClasses.CLONE_COMMANDO),
    PADME_AMIDALA("Padme Amidala", UnitClasses.DIPLOMAT),
    CHAM_SYNDULLA("Cham Syndulla", UnitClasses.DIPLOMAT),

    ASAJJ_VENTRESS("Asajj Ventress", UnitClasses.SITH),
    MANDALORIAN_BO_KATAN_KRYZE("Mandalorian Bo-Katan Kryze", UnitClasses.MANDALORIAN),
    PIRATE_HONDO_OHNAKA("Pirate Hondo Ohnaka", UnitClasses.PIRATE),
    LUX_BONTERI("Lux Bonteri", UnitClasses.SEPARATIST_POLITICIAN),
    COUNT_DOOKU_DARTH_TYRANUS("Count Dooku Darth Tyranus", UnitClasses.SITH),
    SENATOR_MINA_BONTERI("Senator Mina Bonteri", UnitClasses.SEPARATIST_POLITICIAN),
    PASSEL_ARGENTE("Passel Argente", UnitClasses.SEPARATIST_POLITICIAN),
    TIKKES("Tikkes", UnitClasses.SEPARATIST_POLITICIAN),
    GENERAL_KALANI("General Kalani", UnitClasses.SEPARATIST_GENERAL),
    SORA_BULQ("Sora Bulq", UnitClasses.SITH),
    DARCA_NYL("Darca Nyl", UnitClasses.SITH),
    KERN("Kern", UnitClasses.INSURGENT),
    VIEN_NAI("Vien'nai", UnitClasses.INSURGENT),
    CAD_BANE("Cad Bane", UnitClasses.MERCENARY),
    EMBO("Embo", UnitClasses.MERCENARY),
    ;

    private final String name;
    private final UnitClasses unitClass;

    Heroes(String name, UnitClasses unitClass) {
        this.name = name;
        this.unitClass = unitClass;
    }
}


/**
 * 1. Yoda Grand Master of the Jedi Order
 * 2. Mace Windu - Jedi Master, Council member
 * 3. Obi-Wan Kenobi - General, mentor to Anakin
 * 4. Anakin Skywalker - Jedi Knight, later Darth Vader
 * 5. Ahsoka Tano - Anakin's Padawan (left Order in 19 BBY)
 * 6. Plo Koon - Jedi Master, Wolfpack leader
 * 7. Kit Fisto - Jedi Master, aquatic combat specialist
 * 8. Ki-Adi-Mundi - Jedi Master, Cerean strategist
 * 9. Shaak Ti - Jedi Master, Kamino overseer
 * 10. Aayla Secura - Twi'lek Jedi General
 * 11. Luminara Unduli - Jedi Master, Barriss Offee's mentor
 * 12. Barriss Offee - Jedi Padawan (later bombed the Jedi Temple)
 * 13. Quinlan Vos - Jedi Master, undercover operative
 * 14. Depa Billaba - Jedi Master, Kanan Jarrus's mentor 15. Coleman Kcaj - Jedi Master (Survived Order 66)
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Clone Troopers (Republic Army)
 * 16. Captain Rex - Anakin's ARC trooper
 * 17. Commander Cody - Obi-Wan's second-in-command
 * 18. Commander Wolffe - Plo Koon's trooper
 * 19. Commander Gree - Ki-Adi-Mundi's trooper (Order 66 participant)
 * 20. Commander Bly - Aayla Secura's trooper (Order 66 participant)
 * 21. Fives - ARC trooper (discovered Order 66 conspiracy)
 * 22. Echo - ARC trooper, later part of the Bad Batch
 * 23. Hevy - Sacrificed himself on Rishi Moon
 * 24. 99 - Clone janitor turned hero (Battle of Kamino)
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Senators & Politicians
 * 25. Padmé Amidala - Senator of Naboo, secret wife of Anakin 26. Bail Organa - Senator of Alderaan, early Rebel sympathizer 27. Mon Mothma - Senator of Chandrila, future Rebel leader 28. Satine Kryze - Duchess of Mandalore (pacifist ruler)
 * Other Key Heroes
 * 29. Asajj Ventress - Former Sith assassin turned bounty hunter (later aided Jedi)
 * 30. Bo-Katan Kryze - Mandalorian rebel (later leader of Mandalore)
 * 31. Hondo Ohnaka - Pirate with shifting loyalties (helped Jedi occasionally)
 * 32. Lux Bonteri - Separatist-turned-Rebel sympathizer
 * 33. Cham Syndulla - Twi'lek freedom fighter (Hera's father)
 * Legends-Only Heroes (Non-Canon)
 * 34. Starkiller (Galen Marek) - Secret apprentice (The Force Unleashed)
 * 35. Rahm Kota - Jedi General who distrusted clones
 * 36. A'Sharad Hett - Tusken Jedi (later becue Darth Krayt)
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Heroic Sacrifices:
 * Jedi Master Even Piell - Died freeing prisoners from the Citadel
 * Clone Trooper Hardcase - Sacrificed himself at Umbara
 * Jedi Master Tiplee - Killed by Darth Maul on Dathomir
 * <p>
 * SEPARATISTS
 * <p>
 * Political Leaders & Idealists
 * 1. Count Dooku (Darth Tyranus)
 * Former Jedi who genuinely believed the Republic was corrupt (though manipulated by Sidious).
 * Advocated for planetary sovereignty against Republic centralization.
 * 2. Senator Mina Bonteri (Raxus)
 * Pacifist Separatist senator who sought peace negotiations with Padmé Amidala.
 * Assassinated by hardliners for her anti-war stance.
 * 3. Passel Argente (Corporate Alliance)
 * Pushed for trade independence from Republic regulations.
 * 4. Tikkes (Quarren Isolation League)
 * Fought for Quarren independence from Mon Cala's Mon Calamari rulers.
 * <p>
 * <p>
 * <p>
 * Military Commanders & Warriors
 * 5. General Kalani (Tactical Droid)
 * ⚫ Brilliant strategist who questioned Grievous' leadership.
 * ⚫ Later allied with Rebels against the Empire (Star Wars Rebels).
 * 6. Admiral Trench
 * Veteran Harch admiral who outmaneuvered Republic forces multiple times.
 * Respected even by Anakin Skywalker for his tactical genius.
 * 7. Commando Droids
 * Elite BX-series droids with near-clone-level combat skills (e.g., "K-222" in The Clone Wars S7).
 * <p>
 * <p>
 * <p>
 * <p>
 * Freedom Fighters & Anti-Republic Rebels
 * 8. Lux Bonteri
 * Son of Mina Bonteri; initially Separatist, later joined Saw Gerrera's rebels.
 * Allied with Ahsoka Tano to expose Dooku's lies.
 * 9. King Sanjay Rash (Umbara)
 * Resisted Republic occupation; saw clones as invaders.
 * Umbara's toxic atmosphere made it a Separatist stronghold.
 * 10. Riff Tamson (Mon Cala)
 * Quarren general who fought to overthrow King Lee-Char's pro-Republic rule.
 * Viewed as a liberator by some Quarren.
 * <p>
 * <p>
 * <p>
 * <p>
 * Mercenaries & Anti-Heroes
 * 11. Asajj Ventress
 * ⚫ Former Sith assassin who turned against Dooku.
 * Protected innocents (e.g., rescued Jedi younglings in Dark Disciple).
 * 12. Cad Bane
 * ⚫ Ruthless but honorable bounty hunter who often worked for the Separatists. Opposed Jedi hypocrisy (e.g., in The Clone Wars S4 hostage arc).
 * 13. Embo
 * Independent mercenary with a moral code; aided refugees during the war.
 * <p>
 * <p>
 * <p>
 * <p>
 * Legends-Only Separatist Heroes
 * 14. Sora Bulq
 * Jedi Master who defected to the Separatists, believing in their cause.
 * Trained Morgukai warriors (Clone Wars comics).
 * 15. Darca Nyl (Ord Cestus)
 * Jedi who joined the Separatists to protect his planet from Republic exploitation.
 * 16. Kern & Vien'nai
 * Geonosian sisters who led a rebellion against Republic occupation (Republic comics).
 */
