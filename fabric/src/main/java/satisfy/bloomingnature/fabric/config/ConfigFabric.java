package satisfy.bloomingnature.fabric.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import satisfy.bloomingnature.BloomingNature;

@Config(name = BloomingNature.MOD_ID)
public class ConfigFabric implements ConfigData {
    //Misc
    @ConfigEntry.Category("misc")
    public boolean removeLavaLakes = true;
    @ConfigEntry.Category("misc")
    public boolean removeLavaLakesUnderground = true;
    @ConfigEntry.Category("misc")
    public boolean removeMarshBlocks = false;
    @ConfigEntry.Category("misc")
    public boolean removeQuicksandBlocks = false;
    //Plains
    @ConfigEntry.Category("plains")
    public int setPlainsGrassColor = 11063154;
    @ConfigEntry.Category("plains")
    public int setPlainsFoliageColor = 7386187;
    @ConfigEntry.Category("plains")
    public boolean removeVanillaPlainsFlowers = true;
    @ConfigEntry.Category("plains")
    public boolean removeVanillaPlainsTrees = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsTrees = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsFlowers = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsGrass = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsStoneBoulders = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsStoneMounds = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsGravelBeaches = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsStoneSlabs = true;
    @ConfigEntry.Category("plains")
    public boolean addBloomingNaturePlainsBurriedTravertin = true;
    //Sunflower Plains
    @ConfigEntry.Category("sunflowerplains")
    public boolean addBloomingNatureSunflowerPlainsTrees = true;
    @ConfigEntry.Category("sunflowerplains")
    public boolean addBloomingNatureSunflowerPlainsFlowers = true;
    //River
    @ConfigEntry.Category("river")
    public int setRiverGrassColor = 11063154;
    @ConfigEntry.Category("river")
    public int setRiverFoliageColor = 10399058;
    @ConfigEntry.Category("river")
    public boolean removeVanillaRiverFlowers = true;
    @ConfigEntry.Category("river")
    public boolean removeVanillaRiverTrees = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverTrees = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverGrass = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverStoneBoulders = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverStoneMounds = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverGravelBeaches = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverStoneSlabs = true;
    @ConfigEntry.Category("river")
    public boolean addBloomingNatureRiverBurriedTravertin = true;
    //ASPEN
    @ConfigEntry.Category("aspen")
    public int setOldGrowthBirchForestGrassColor = 14406505;
    @ConfigEntry.Category("aspen")
    public int setOldGrowthBirchForestFoliageColor = 10399058;
    @ConfigEntry.Category("aspen")
    public boolean removeVanillaOldGrowthBirchForestFlowers = true;
    @ConfigEntry.Category("aspen")
    public boolean removeVanillaOldGrowthBirchForestTrees = true;
    @ConfigEntry.Category("aspen")
    public boolean addBloomingNatureOldGrowthBirchForestTrees = true;
    @ConfigEntry.Category("aspen")
    public boolean addBloomingNatureOldGrowthBirchForestFallenTrees = true;
    @ConfigEntry.Category("aspen")
    public boolean addBloomingNatureOldGrowthBirchForestFlowers = true;
    @ConfigEntry.Category("aspen")
    public boolean addBloomingNatureOldGrowthBirchForestGrass = true;
    @ConfigEntry.Category("aspen")
    public boolean addBloomingNatureOldGrowthBirchStoneSlabs = true;
    //BIRCH
    @ConfigEntry.Category("birch")
    public int setBirchForestGrassColor = 10799444;
    @ConfigEntry.Category("birch")
    public int setBirchForestFoliageColor = 8567370;
    @ConfigEntry.Category("birch")
    public boolean removeVanillaBirchForestFlowers = true;
    @ConfigEntry.Category("birch")
    public boolean removeVanillaBirchForestTrees = true;
    @ConfigEntry.Category("birch")
    public boolean addBloomingNatureBirchForestTrees = true;
    @ConfigEntry.Category("birch")
    public boolean addBloomingNatureBirchForestFallenTrees = true;
    @ConfigEntry.Category("birch")
    public boolean addBloomingNatureBirchForestFlowers = true;
    @ConfigEntry.Category("birch")
    public boolean addBloomingNatureBirchForestGrass = true;
    @ConfigEntry.Category("birch")
    public boolean addBloomingNatureBirchStoneSlabs = true;

    //FOREST
    @ConfigEntry.Category("forest")
    public int setForestGrassColor = 10799444;
    @ConfigEntry.Category("forest")
    public int setForestFoliageColor = 10399058;
    @ConfigEntry.Category("forest")
    public boolean removeVanillaForestFlowers = true;
    @ConfigEntry.Category("forest")
    public boolean removeVanillaForestTrees = true;
    @ConfigEntry.Category("forest")
    public boolean addBloomingNatureForestTrees = true;
    @ConfigEntry.Category("forest")
    public boolean addBloomingNatureForestFallenTrees = true;
    @ConfigEntry.Category("forest")
    public boolean addBloomingNatureForestFlowers = true;
    @ConfigEntry.Category("forest")
    public boolean addBloomingNatureForestGrass = true;
    @ConfigEntry.Category("forest")
    public boolean addBloomingNatureForestStoneBoulder = true;
    @ConfigEntry.Category("forest")
    public boolean addBloomingNatureForestStoneSlabs = true;
    //FLOWERFOREST
    @ConfigEntry.Category("flowerforest")
    public int setFlowerforestGrassColor = 10799444;
    @ConfigEntry.Category("flowerforest")
    public int setFlowerforestFoliageColor = 10399058;
    @ConfigEntry.Category("flowerforest")
    public boolean removeVanillaFlowerforestFlowers = true;
    @ConfigEntry.Category("flowerforest")
    public boolean removeVanillaFlowerforestTrees = true;
    @ConfigEntry.Category("flowerforest")
    public boolean addBloomingNatureFlowerforestTrees = true;
    @ConfigEntry.Category("flowerforest")
    public boolean addBloomingNatureFlowerforestFallenTrees = true;
    @ConfigEntry.Category("flowerforest")
    public boolean addBloomingNatureFlowerforestFlowers = true;
    @ConfigEntry.Category("flowerforest")
    public boolean addBloomingNatureFlowerforestGrass = true;
    @ConfigEntry.Category("flowerforest")
    public boolean addBloomingNatureFlowerforestStoneSlabs = true;
    //CHERRYGROVE
    @ConfigEntry.Category("cherrygrove")
    public boolean removeVanillaCherryGroveFlowers = true;
    @ConfigEntry.Category("cherrygrove")
    public boolean removeVanillaCherryGroveTrees = true;
    @ConfigEntry.Category("cherrygrove")
    public boolean addBloomingNatureCherryGroveTrees = true;
    @ConfigEntry.Category("cherrygrove")
    public boolean addBloomingNatureCherryGroveFlowers = true;
    //SNOWYPLAINS
    @ConfigEntry.Category("snowyplains")
    public boolean removeVanillaSnowyPlainsFlowers = true;
    @ConfigEntry.Category("snowyplains")
    public boolean removeVanillaSnowyPlainsTrees = true;
    @ConfigEntry.Category("snowyplains")
    public boolean addBloomingNatureSnowyPlainsTrees = true;
    @ConfigEntry.Category("snowyplains")
    public boolean addBloomingNatureSnowyPlainsAdditionalTrees = true;
    @ConfigEntry.Category("snowyplains")
    public boolean addBloomingNatureSnowyPlainsStoneBoulders = true;
    @ConfigEntry.Category("snowyplains")
    public boolean addBloomingNatureSnowyPlainsStoneMound = true;
    @ConfigEntry.Category("snowyplains")
    public boolean addBloomingNatureSnowyPlainsGravelBeach = true;
    @ConfigEntry.Category("snowyplains")
    public boolean addBloomingNatureSnowyPlainsStoneSlabs = true;
    //SNOWYTAIGA
    @ConfigEntry.Category("snowytaiga")
    public boolean removeVanillaSnowyTaigaTrees = true;
    @ConfigEntry.Category("snowytaiga")
    public boolean addBloomingSnowyTaigaTrees = true;
    @ConfigEntry.Category("snowytaiga")
    public boolean addBloomingNatureSnowyTaigaStoneBoulders = true;
    @ConfigEntry.Category("snowytaiga")
    public boolean addBloomingNatureSnowyTaigaStoneMounds = true;
    @ConfigEntry.Category("snowytaiga")
    public boolean addBloomingNatureSnowyTaigaGravelBeaches = true;
    @ConfigEntry.Category("snowytaiga")
    public boolean addBloomingNatureSnowyTaigaStoneSlabs = true;
    //SWAMP
    @ConfigEntry.Category("swamp")
    public boolean removeVanillaSwampTrees = true;
    @ConfigEntry.Category("swamp")
    public boolean removeVanillaSwampFlowers = true;
    @ConfigEntry.Category("swamp")
    public boolean removeVanillaSwampGrass = true;
    @ConfigEntry.Category("swamp")
    public boolean addBloomingNatureSwampWaterBasins = true;
    @ConfigEntry.Category("swamp")
    public boolean addBloomingNatureSwampMarshBasins = true;
    @ConfigEntry.Category("swamp")
    public boolean addBloomingNatureSwampFloatingLeaves = true;
    @ConfigEntry.Category("swamp")
    public boolean addBloomingNatureSwampMud = true;
    @ConfigEntry.Category("swamp")
    public boolean addBloomingNatureSwampadditionalMud = true;
    @ConfigEntry.Category("swamp")
    public boolean addBloomingNatureSwampTrees = true;
    @ConfigEntry.Category("swamp")
    public boolean addBloomingNatureSwampVegetation = true;
    @ConfigEntry.Category("swamp")
    public boolean addBloomingNatureSwampReed = true;
    @ConfigEntry.Category("swamp")
    public boolean addBloomingNatureSwampCattails = true;
    @ConfigEntry.Category("swamp")
    public boolean addBloomingNatureSwampGrass = true;
    @ConfigEntry.Category("swamp")
    public boolean addBloomingNatureSwampFlowers = true;
    //MangroveSwamp
    @ConfigEntry.Category("mangroveswamp")
    public boolean addBloomingNatureMangroveSwampWaterBasins = true;
    @ConfigEntry.Category("mangroveswamp")
    public boolean addBloomingNatureMangroveSwampMarshBasins = true;
    @ConfigEntry.Category("mangroveswamp")
    public boolean addBloomingNatureMangroveSwampFloatingLeaves = true;
    @ConfigEntry.Category("mangroveswamp")
    public boolean addBloomingNatureMangroveSwampMud = true;
    @ConfigEntry.Category("mangroveswamp")
    public boolean addBloomingNatureMangroveSwampadditionalMud = true;
    @ConfigEntry.Category("mangroveswamp")
    public boolean addBloomingNatureMangroveSwampVegetation = true;
    @ConfigEntry.Category("mangroveswamp")
    public boolean addBloomingNatureMangroveSwampCattails = true;
    @ConfigEntry.Category("mangroveswamp")
    public boolean addBloomingNatureMangroveSwampReed = true;

}